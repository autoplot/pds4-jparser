//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.09.19 at 05:23:51 PM PDT 
//


package gov.nasa.arc.pds.xml.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 *  The Record_Binary class is a component of the table class and defines a record of the table. 
 * 
 * <p>Java class for Record_Binary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Record_Binary">
 *   &lt;complexContent>
 *     &lt;extension base="{http://pds.nasa.gov/pds4/pds/v03}Record">
 *       &lt;sequence>
 *         &lt;element name="record_length" type="{http://pds.nasa.gov/pds4/pds/v03}record_length"/>
 *         &lt;choice maxOccurs="unbounded">
 *           &lt;element name="Field_Binary" type="{http://pds.nasa.gov/pds4/pds/v03}Field_Binary"/>
 *           &lt;element name="Group_Field_Binary" type="{http://pds.nasa.gov/pds4/pds/v03}Group_Field_Binary"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Record_Binary", propOrder = {
    "recordLength",
    "fieldBinariesAndGroupFieldBinaries"
})
public class RecordBinary
    extends Record
{

    @XmlElement(name = "record_length", required = true)
    protected RecordLength recordLength;
    @XmlElements({
        @XmlElement(name = "Group_Field_Binary", type = GroupFieldBinary.class),
        @XmlElement(name = "Field_Binary", type = FieldBinary.class)
    })
    protected List<Object> fieldBinariesAndGroupFieldBinaries;

    /**
     * Gets the value of the recordLength property.
     * 
     * @return
     *     possible object is
     *     {@link RecordLength }
     *     
     */
    public RecordLength getRecordLength() {
        return recordLength;
    }

    /**
     * Sets the value of the recordLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecordLength }
     *     
     */
    public void setRecordLength(RecordLength value) {
        this.recordLength = value;
    }

    /**
     * Gets the value of the fieldBinariesAndGroupFieldBinaries property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fieldBinariesAndGroupFieldBinaries property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFieldBinariesAndGroupFieldBinaries().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GroupFieldBinary }
     * {@link FieldBinary }
     * 
     * 
     */
    public List<Object> getFieldBinariesAndGroupFieldBinaries() {
        if (fieldBinariesAndGroupFieldBinaries == null) {
            fieldBinariesAndGroupFieldBinaries = new ArrayList<Object>();
        }
        return this.fieldBinariesAndGroupFieldBinaries;
    }

}