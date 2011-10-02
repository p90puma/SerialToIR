
package org.me.arduino;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.me.arduino package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SendSerialInput_QNAME = new QName("http://arduino.me.org/", "SendSerialInput");
    private final static QName _SendSerialInputResponse_QNAME = new QName("http://arduino.me.org/", "SendSerialInputResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.me.arduino
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SendSerialInput }
     * 
     */
    public SendSerialInput createSendSerialInput() {
        return new SendSerialInput();
    }

    /**
     * Create an instance of {@link SendSerialInputResponse }
     * 
     */
    public SendSerialInputResponse createSendSerialInputResponse() {
        return new SendSerialInputResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendSerialInput }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://arduino.me.org/", name = "SendSerialInput")
    public JAXBElement<SendSerialInput> createSendSerialInput(SendSerialInput value) {
        return new JAXBElement<SendSerialInput>(_SendSerialInput_QNAME, SendSerialInput.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendSerialInputResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://arduino.me.org/", name = "SendSerialInputResponse")
    public JAXBElement<SendSerialInputResponse> createSendSerialInputResponse(SendSerialInputResponse value) {
        return new JAXBElement<SendSerialInputResponse>(_SendSerialInputResponse_QNAME, SendSerialInputResponse.class, null, value);
    }

}
