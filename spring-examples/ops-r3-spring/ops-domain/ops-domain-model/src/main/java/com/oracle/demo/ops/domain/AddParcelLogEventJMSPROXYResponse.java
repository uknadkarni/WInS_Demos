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
 * <p>Java class for AddParcelLogEventJMSPROXYResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddParcelLogEventJMSPROXYResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResponseHeader" type="{http://demo.oracle.com/ops/domain/services/common}WebServiceResponseHeaderType"/>
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
@XmlType(name = "AddParcelLogEventJMSPROXYResponseType", namespace = "http://demo.oracle.com/ops/domain/services/parcel", propOrder = {
    "responseHeader",
    "parcelLogEvent"
})
@XmlRootElement(name = "AddParcelLogEventJMSPROXYResponse", namespace = "http://demo.oracle.com/ops/domain/services/parcel")
public class AddParcelLogEventJMSPROXYResponse
    implements Serializable
{

    private final static long serialVersionUID = 678L;
    @XmlElement(name = "ResponseHeader", required = true)
    protected WebServiceResponseHeader responseHeader;
    @XmlElement(name = "ParcelLogEvent", required = true)
    protected ParcelEvent parcelLogEvent;

    /**
     * Gets the value of the responseHeader property.
     * 
     * @return
     *     possible object is
     *     {@link WebServiceResponseHeader }
     *     
     */
    public WebServiceResponseHeader getResponseHeader() {
        return responseHeader;
    }

    /**
     * Sets the value of the responseHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link WebServiceResponseHeader }
     *     
     */
    public void setResponseHeader(WebServiceResponseHeader value) {
        this.responseHeader = value;
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
