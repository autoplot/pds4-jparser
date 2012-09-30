//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.09.19 at 05:23:51 PM PDT 
//


package gov.nasa.arc.pds.xml.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 *  The Mission PDS3 class describes an activity involved in the collection of data. This class captures the PDS3 catalog Mission information. 
 * 
 * <p>Java class for Mission_PDS3 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Mission_PDS3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mission_name" type="{http://pds.nasa.gov/pds4/pds/v03}ASCII_Short_String_Collapsed"/>
 *         &lt;element name="mission_desc" type="{http://pds.nasa.gov/pds4/pds/v03}ASCII_Text_Preserved"/>
 *         &lt;element name="mission_objectives_summary" type="{http://pds.nasa.gov/pds4/pds/v03}ASCII_Text_Preserved"/>
 *         &lt;element name="mission_start_date" type="{http://pds.nasa.gov/pds4/pds/v03}ASCII_Short_String_Collapsed"/>
 *         &lt;element name="mission_stop_date" type="{http://pds.nasa.gov/pds4/pds/v03}ASCII_Short_String_Collapsed"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Mission_PDS3", propOrder = {
    "missionName",
    "missionDesc",
    "missionObjectivesSummary",
    "missionStartDate",
    "missionStopDate"
})
public class MissionPDS3 {

    @XmlElement(name = "mission_name", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String missionName;
    @XmlElement(name = "mission_desc", required = true)
    protected String missionDesc;
    @XmlElement(name = "mission_objectives_summary", required = true)
    protected String missionObjectivesSummary;
    @XmlElement(name = "mission_start_date", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String missionStartDate;
    @XmlElement(name = "mission_stop_date", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String missionStopDate;

    /**
     * Gets the value of the missionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMissionName() {
        return missionName;
    }

    /**
     * Sets the value of the missionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMissionName(String value) {
        this.missionName = value;
    }

    /**
     * Gets the value of the missionDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMissionDesc() {
        return missionDesc;
    }

    /**
     * Sets the value of the missionDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMissionDesc(String value) {
        this.missionDesc = value;
    }

    /**
     * Gets the value of the missionObjectivesSummary property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMissionObjectivesSummary() {
        return missionObjectivesSummary;
    }

    /**
     * Sets the value of the missionObjectivesSummary property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMissionObjectivesSummary(String value) {
        this.missionObjectivesSummary = value;
    }

    /**
     * Gets the value of the missionStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMissionStartDate() {
        return missionStartDate;
    }

    /**
     * Sets the value of the missionStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMissionStartDate(String value) {
        this.missionStartDate = value;
    }

    /**
     * Gets the value of the missionStopDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMissionStopDate() {
        return missionStopDate;
    }

    /**
     * Sets the value of the missionStopDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMissionStopDate(String value) {
        this.missionStopDate = value;
    }

}
