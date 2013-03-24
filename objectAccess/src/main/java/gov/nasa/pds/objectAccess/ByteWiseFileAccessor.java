package gov.nasa.pds.objectAccess;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class that provides common I/O functionality for PDS data objects.
 * 
 * @author psarram
 */
public class ByteWiseFileAccessor {
	private static final Logger LOGGER = LoggerFactory.getLogger(ByteWiseFileAccessor.class);		
	private int recordLength;
	private MappedByteBuffer mappedBuffer = null;

	/**
	 * Constructs a <code>ByteWiseFileAccessor</code> object which maps a region of the data file into memory.
	 *  
	 * @param file    the data file
	 * @param offset  the offset within the data file
	 * @param length  the record length in bytes
	 * @param records the number of records
	 * @throws FileNotFoundException If <code>file</code> does not exist, is a directory rather than a regular file,
     *                               or for some other reason cannot be opened for reading                   
	 * @throws IOException           If an I/O error occurs
	 */
	public ByteWiseFileAccessor(File file, long offset, int length, int records) throws FileNotFoundException, IOException {		
		this.recordLength = length;			
		try {
			FileInputStream is = new FileInputStream(file);
			FileChannel channel = is.getChannel();	
			int size = length * records;
			this.mappedBuffer = channel.map(FileChannel.MapMode.READ_ONLY, offset, size);
		} catch(FileNotFoundException ex) {
			LOGGER.error("The data file does not exist or for some other reason cannot be opened for reading.", ex);
			throw ex;
		} catch(IOException ex) {
			LOGGER.error("I/O error.", ex);			
			throw ex;
		}
	}
	
	/**
	 * Reads <code>length</code> bytes of data from a specified record at the given offset.
	 * 
	 * @param recordNum the record number to read bytes from (1-relative)
	 * @param offset    an offset within the record
	 * @param length    the number of bytes to read from the record 
	 * @return an array of bytes
	 */
	public byte[] readRecordBytes(int recordNum, int offset, int length) {
		assert recordNum > 0;
		
		// The offset within the mapped buffer		
		int fileOffset = (recordNum - 1) * this.recordLength;
		byte[] buf = new byte[this.recordLength];
		
		mappedBuffer.position(fileOffset);		
		mappedBuffer.get(buf);
		
		return Arrays.copyOfRange(buf, offset, (offset + length));
	}
}