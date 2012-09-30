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
import javax.xml.bind.annotation.XmlType;


/**
 *  The Document Format Set class is a set consisting of a document format and associated files. 
 * 
 * <p>Java class for Document_Format_Set complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Document_Format_Set">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Document_Format" type="{http://pds.nasa.gov/pds4/pds/v03}Document_Format"/>
 *         &lt;element name="Document_File" type="{http://pds.nasa.gov/pds4/pds/v03}Document_File" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Document_Format_Set", propOrder = {
    "documentFormat",
    "documentFiles"
})
public class DocumentFormatSet {

    @XmlElement(name = "Document_Format", required = true)
    protected DocumentFormat documentFormat;
    @XmlElement(name = "Document_File", required = true)
    protected List<DocumentFile> documentFiles;

    /**
     * Gets the value of the documentFormat property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentFormat }
     *     
     */
    public DocumentFormat getDocumentFormat() {
        return documentFormat;
    }

    /**
     * Sets the value of the documentFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentFormat }
     *     
     */
    public void setDocumentFormat(DocumentFormat value) {
        this.documentFormat = value;
    }

    /**
     * Gets the value of the documentFiles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the documentFiles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentFiles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentFile }
     * 
     * 
     */
    public List<DocumentFile> getDocumentFiles() {
        if (documentFiles == null) {
            documentFiles = new ArrayList<DocumentFile>();
        }
        return this.documentFiles;
    }

}
