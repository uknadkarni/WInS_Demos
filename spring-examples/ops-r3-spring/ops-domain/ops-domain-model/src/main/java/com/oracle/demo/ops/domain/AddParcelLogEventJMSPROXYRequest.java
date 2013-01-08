//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.12.06 at 12:30:16 PM PST 
//


package com.oracle.demo.ops.domain;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddParcelLogEventJMSPROXYRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddParcelLogEventJMSPROXYRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RequestHeader" type="{http://demo.oracle.com/ops/domain/services/common}WebServiceRequestHeaderType"/>
 *         &lt;element name="ParcelLogEvent" type="{http://demo.oracle.com/ops/domain/schema/shipping}ParcelEventType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddParcelLogEventJMSPROXYRequestType", namespace = "http://demo.oracle.com/ops/domain/services/parcel", propOrder = {
    "requestHeader",
    "parcelLogEvent"
})
@XmlRootElement(name = "AddParcelLogEventJMSPROXYRequest", namespace = "http://demo.oracle.com/ops/domain/services/parcel")
public class AddParcelLogEventJMSPROXYRequest
    implements Serializable
{

    private final static long serialVersionUID = 678L;
    @XmlElement(name = "RequestHeader", required = true)
    protected WebServiceRequestHeader requestHeader;
    @XmlElement(name = "ParcelLogEvent", required = true)
    protected ParcelEvent parcelLogEvent;

    /**
     * Gets the value of the requestHeader property.
     * 
     * @return
     *     possible object is
     *     {@link WebServiceRequestHeader }
     *     
     */
    public WebServiceRequestHeader getRequestHeader() {
        return requestHeader;
    }

    /**
     * Sets the value of the requestHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link WebServiceRequestHeader }
     *     
     */
    public void setRequestHeader(WebServiceRequestHeader value) {
        this.requestHeader = value;
    }

    /**
     * Gets the value of the parcelLogEvent property.
     * 
     * @return
     *     possible object is
     *     {@link ParcelEvent }
     *     
     */
    public ParcelEvent getParcelLogEvent() {
        return parcelLogEvent;
    }

    /**
     * Sets the value of the parcelLogEvent property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParcelEvent }
     *     
     */
    public void setParcelLogEvent(ParcelEvent value) {
        this.parcelLogEvent = value;
    }

}
