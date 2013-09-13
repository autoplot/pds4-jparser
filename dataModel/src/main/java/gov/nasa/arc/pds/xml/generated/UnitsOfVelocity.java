//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.06.06 at 03:37:38 PM PDT 
//


package gov.nasa.arc.pds.xml.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Units_of_Velocity.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Units_of_Velocity">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="cm/s"/>
 *     &lt;enumeration value="km/s"/>
 *     &lt;enumeration value="m/s"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Units_of_Velocity")
@XmlEnum
public enum UnitsOfVelocity {

    @XmlEnumValue("cm/s")
    CM_S("cm/s"),
    @XmlEnumValue("km/s")
    KM_S("km/s"),
    @XmlEnumValue("m/s")
    M_S("m/s");
    private final String value;

    UnitsOfVelocity(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static UnitsOfVelocity fromValue(String v) {
        for (UnitsOfVelocity c: UnitsOfVelocity.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}