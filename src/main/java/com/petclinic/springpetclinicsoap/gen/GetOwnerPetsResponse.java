//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.05.17 at 02:01:12 AM CEST 
//


package com.petclinic.springpetclinicsoap.gen;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="pet" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="petId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                   &lt;element name="birthDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                   &lt;element name="petType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "pet"
})
@XmlRootElement(name = "getOwnerPetsResponse")
public class GetOwnerPetsResponse {

    protected List<GetOwnerPetsResponse.Pet> pet;

    /**
     * Gets the value of the pet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetOwnerPetsResponse.Pet }
     * 
     * 
     */
    public List<GetOwnerPetsResponse.Pet> getPet() {
        if (pet == null) {
            pet = new ArrayList<GetOwnerPetsResponse.Pet>();
        }
        return this.pet;
    }

    public void setPet(List<Pet> pet) {
        this.pet = pet;
    }

    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="petId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *         &lt;element name="birthDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *         &lt;element name="petType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "petId",
        "birthDate",
        "petType"
    })
    public static class Pet {

        protected int petId;
        @XmlElement(required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar birthDate;
        @XmlElement(required = true)
        protected String petType;

        /**
         * Gets the value of the petId property.
         * 
         */
        public int getPetId() {
            return petId;
        }

        /**
         * Sets the value of the petId property.
         * 
         */
        public void setPetId(int value) {
            this.petId = value;
        }

        /**
         * Gets the value of the birthDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getBirthDate() {
            return birthDate;
        }

        /**
         * Sets the value of the birthDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setBirthDate(XMLGregorianCalendar value) {
            this.birthDate = value;
        }

        /**
         * Gets the value of the petType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPetType() {
            return petType;
        }

        /**
         * Sets the value of the petType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPetType(String value) {
            this.petType = value;
        }

    }

}
