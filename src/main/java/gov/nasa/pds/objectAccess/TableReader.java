// Copyright 2019, California Institute of Technology ("Caltech").
// U.S. Government sponsorship acknowledged.
//
// All rights reserved.
//
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are met:
//
// * Redistributions of source code must retain the above copyright notice,
// this list of conditions and the following disclaimer.
// * Redistributions must reproduce the above copyright notice, this list of
// conditions and the following disclaimer in the documentation and/or other
// materials provided with the distribution.
// * Neither the name of Caltech nor its operating division, the Jet Propulsion
// Laboratory, nor the names of its contributors may be used to endorse or
// promote products derived from this software without specific prior written
// permission.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
// AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
// IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
// ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
// LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
// CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
// SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
// INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
// CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
// ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
// POSSIBILITY OF SUCH DAMAGE.

package gov.nasa.pds.objectAccess;

import gov.nasa.pds.label.object.FieldDescription;
import gov.nasa.pds.label.object.TableRecord;
import gov.nasa.pds.objectAccess.table.AdapterFactory;
import gov.nasa.pds.objectAccess.table.TableAdapter;
import gov.nasa.pds.objectAccess.table.TableDelimitedAdapter;
import gov.nasa.pds.objectAccess.table.TableCharacterAdapter;
import gov.nasa.pds.objectAccess.utility.Utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import au.com.bytecode.opencsv.CSVReader;

/**
 * The <code>TableReader</code> class defines methods for reading table records.
 */
public class TableReader {
	private static final Logger LOGGER = LoggerFactory.getLogger(TableReader.class);

	private TableAdapter adapter;
	private long offset;
	private int currentRow = 0;
	private TableRecord record = null;
	protected ByteWiseFileAccessor accessor = null;
	private Map<String, Integer> map = new HashMap<String, Integer>();
	private CSVReader csvReader = null;
	private List<String[]> delimitedRecordList;
	private BufferedReader bufferedReader = null;
	private long recordSize = 0;

	public TableReader(Object table, File dataFile) throws Exception {
	  this(table, dataFile.toURI().toURL());
	}
	
	 /**
   * Constructs a <code>TableReader</code> instance for reading records from a
   * data file associated with a table object.
   *
   * @param table a table object
   * @param dataFile an input data file
   *
   * @throws NullPointerException if table offset is null
   */
  public TableReader(Object table, URL dataFile) throws Exception {
    this(table, dataFile, true);
  }
	
  public TableReader(Object table, URL dataFile, boolean checkSize) throws Exception {
    this(table, dataFile, checkSize, false);
  }
  
	/**
	 * Constructs a <code>TableReader</code> instance for reading records from a
	 * data file associated with a table object.
	 *
	 * @param table a table object
	 * @param dataFile an input data file
   * @param checkSize check that the size of the data file is equal to the 
   * size of the table (length * records) + offset.
	 *
	 * @throws NullPointerException if table offset is null
	 */
	public TableReader(Object table, URL dataFile, boolean checkSize, 
	    boolean readEntireFile) throws Exception {
		adapter = AdapterFactory.INSTANCE.getTableAdapter(table);
		try {
			offset = adapter.getOffset();
		} catch (NullPointerException ex) {
			LOGGER.error("The table offset cannot be null.");
			throw ex;
		}
		if (adapter instanceof TableDelimitedAdapter) {
		  TableDelimitedAdapter tda = (TableDelimitedAdapter) adapter;
		  InputStream is = Utility.openConnection(dataFile.openConnection());
			is.skip(offset);
			bufferedReader = new BufferedReader(new InputStreamReader(is, "US-ASCII"));
			accessor = new ByteWiseFileAccessor(dataFile, offset, -1);
			csvReader = new CSVReader(bufferedReader, tda.getFieldDelimiter());
			delimitedRecordList = csvReader.readAll();
		} else {
		  if (readEntireFile) {
		    accessor = new ByteWiseFileAccessor(dataFile, offset, adapter.getRecordLength());
		    
		  } else {
		    accessor = new ByteWiseFileAccessor(dataFile, offset, adapter.getRecordLength(),
			    adapter.getRecordCount(), checkSize);
		  }
		}
		createFieldMap();
	}

	public TableAdapter getAdapter() {
	  return this.adapter;
	}
	
	/**
	 * Gets the field descriptions for fields in the table.
	 *
	 * @return an array of field descriptions
	 */
	public FieldDescription[] getFields() {
		return adapter.getFields();
	}

	/**
	 * 
	 * @return the field map.
	 */
	public Map<String, Integer> getFieldMap() {
	  return map;
	}
	
	/**
	 * Reads the next record from the data file.
	 *
	 * @return the next record, or null if no further records.
	 */
	public TableRecord readNext() throws IOException {
		currentRow++;
		if (currentRow > adapter.getRecordCount()) {
			return null;
		}

		return getTableRecord();
	}
	
	/**
	 * Gets access to the table record given the index. The current row is set to
	 * this index, thus, subsequent call to readNext() gets the next record from
	 * this position.
	 *
	 * @param index the record index (1-relative)
	 * @return an instance of <code>TableRecord</code>
	 * @throws IllegalArgumentException if index is greater than the record number
	 */
	public TableRecord getRecord(int index) throws IllegalArgumentException, IOException {
		int recordCount = adapter.getRecordCount();
		if (index < 1 || index > recordCount) {
			String msg = "The index is out of range 1 - " + recordCount;
			LOGGER.error(msg);
			throw new IllegalArgumentException(msg);
		}

		currentRow = index;
		return getTableRecord();
	}

	private TableRecord getTableRecord() throws IOException {
		if (adapter instanceof TableDelimitedAdapter) {
			String[] recordValue = delimitedRecordList.get(currentRow-1);
			if (recordValue.length != adapter.getFieldCount()) {
				throw new IOException("Record " + currentRow + " has wrong number of fields "
						+ "(expected " + adapter.getFieldCount() + ", got " + recordValue.length + ")"
				);
			}

			if (record != null) {
				((DelimitedTableRecord) record).setRecordValue(recordValue);
			} else {
				record = new DelimitedTableRecord(map, adapter.getFieldCount(), recordValue);
			}

		} else {
			byte[] recordValue = accessor.readRecordBytes(currentRow, 0, adapter.getRecordLength());
			if (record != null) {
				((FixedTableRecord) record).setRecordValue(recordValue);
			} else {
				record = new FixedTableRecord(recordValue, map, adapter.getFields());
			}
		}

		return record;
	}

	private void createFieldMap() {
		map = new HashMap<String, Integer>();
		int fieldIndex = 1;

		for (FieldDescription field : adapter.getFields()) {
			if (!map.containsKey(field.getName())) {
				map.put(field.getName(), fieldIndex);
			}

			++fieldIndex;
		}
	}
	
	/**
	 * Sets the current row.
	 * 
	 * @param row The row to set.
	 */
	public void setCurrentRow(int row) {
	  this.currentRow = row;
	}
	
	/**
	 * 
	 * @return the current row.
	 */
	public int getCurrentRow() {
	  return this.currentRow;
	}
	
	public ByteWiseFileAccessor getAccessor() {
	  return this.accessor;
	}
	
	/**
	 * @return the size of record (i.e. number of lines)
	 */
	public long getRecordSize(URL dataFile, Object table) throws Exception {
		adapter = AdapterFactory.INSTANCE.getTableAdapter(table);
		InputStream is = Utility.openConnection(dataFile.openConnection());
		try {
			offset = adapter.getOffset();
		} catch (NullPointerException ex) {
			LOGGER.error("The table offset cannot be null.");
			throw ex;
		}
		if (adapter instanceof TableDelimitedAdapter) {
			this.recordSize = delimitedRecordList.size();
		} else {
			is.skip(offset);
			bufferedReader = new BufferedReader(new InputStreamReader(is, "US-ASCII"));
			if (adapter instanceof TableCharacterAdapter) {
				int numLines = 0;
				while (bufferedReader.readLine()!=null) {
					numLines++;
				}
				this.recordSize = numLines;
			}
			else {
				this.recordSize = is.available();	
			}
		}	
		return this.recordSize;
	}
	
	public long getOffset() {
		return this.offset;
	}
}