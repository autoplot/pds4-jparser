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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 *  The Ingest_DD class provides a form for collecting class and attribute definitions for ingesting into the data dictionary database. 
 * 
 * <p>Java class for Ingest_DD complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Ingest_DD">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="full_name" type="{http://pds.nasa.gov/pds4/pds/v03}ASCII_Short_String_Collapsed"/>
 *         &lt;element name="local_identifier" type="{http://pds.nasa.gov/pds4/pds/v03}ASCII_Short_String_Collapsed" minOccurs="0"/>
 *         &lt;element name="comment" type="{http://pds.nasa.gov/pds4/pds/v03}ASCII_Text_Preserved" minOccurs="0"/>
 *         &lt;element name="last_modification_date_time" type="{http://pds.nasa.gov/pds4/pds/v03}ASCII_Date_Time_YMD"/>
 *         &lt;element name="pds4_merge_flag" type="{http://pds.nasa.gov/pds4/pds/v03}ASCII_Boolean" minOccurs="0"/>
 *         &lt;element name="DD_Attribute" type="{http://pds.nasa.gov/pds4/pds/v03}DD_Attribute" maxOccurs="unbounded"/>
 *         &lt;element name="DD_Class" type="{http://pds.nasa.gov/pds4/pds/v03}DD_Class" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ingest_DD", propOrder = {
    "fullName",
    "localIdentifier",
    "comment",
    "lastModificationDateTime",
    "pds4MergeFlag",
    "ddAttributes",
    "ddClasses"
})
@XmlRootElement(name = "Ingest_DD")
public class IngestDD {

    @XmlElement(name = "full_name", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String fullName;
    @XmlElement(name = "local_identifier")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String localIdentifier;
    protected String comment;
    @XmlElement(name = "last_modification_date_time", required = true)
    protected String lastModificationDateTime;
    @XmlElement(name = "pds4_merge_flag")
    protected Boolean pds4MergeFlag;
    @XmlElement(name = "DD_Attribute", required = true)
    protected List<DDAttribute> ddAttributes;
    @XmlElement(name = "DD_Class")
    protected List<DDClass> ddClasses;

    /**
     * Gets the value of the fullName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the value of the fullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullName(String value) {
        this.fullName = value;
    }

    /**
     * Gets the value of the localIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalIdentifier() {
        return localIdentifier;
    }

    /**
     * Sets the value of the localIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalIdentifier(String value) {
        this.localIdentifier = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

    /**
     * Gets the value of the lastModificationDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastModificationDateTime() {
        return lastModificationDateTime;
    }

    /**
     * Sets the value of the lastModificationDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastModificationDateTime(String value) {
        this.lastModificationDateTime = value;
    }

    /**
     * Gets the value of the pds4MergeFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPds4MergeFlag() {
        return pds4MergeFlag;
    }

    /**
     * Sets the value of the pds4MergeFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPds4MergeFlag(Boolean value) {
        this.pds4MergeFlag = value;
    }

    /**
     * Gets the value of the ddAttributes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ddAttributes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDDAttributes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DDAttribute }
     * 
     * 
     */
    public List<DDAttribute> getDDAttributes() {
        if (ddAttributes == null) {
            ddAttributes = new ArrayList<DDAttribute>();
        }
        return this.ddAttributes;
    }

    /**
     * Gets the value of the ddClasses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ddClasses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDDClasses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DDClass }
     * 
     * 
     */
    public List<DDClass> getDDClasses() {
        if (ddClasses == null) {
            ddClasses = new ArrayList<DDClass>();
        }
        return this.ddClasses;
    }

}
