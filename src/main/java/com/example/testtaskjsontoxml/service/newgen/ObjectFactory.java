
package com.example.testtaskjsontoxml.service.newgen;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.springsoap.gen.newgen package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
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

    private final static QName _GetClientRequest_QNAME = new QName("http://www.example.com/springsoap/gen", "getClientRequest");
    private final static QName _GetClientResponse_QNAME = new QName("http://www.example.com/springsoap/gen", "getClientResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.springsoap.gen.newgen
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetClientRequest }
     * 
     */
    public GetClientRequest createGetClientRequest() {
        return new GetClientRequest();
    }

    /**
     * Create an instance of {@link GetClientResponse }
     * 
     */
    public GetClientResponse createGetClientResponse() {
        return new GetClientResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClientRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetClientRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.example.com/springsoap/gen", name = "getClientRequest")
    public JAXBElement<GetClientRequest> createGetClientRequest(GetClientRequest value) {
        return new JAXBElement<GetClientRequest>(_GetClientRequest_QNAME, GetClientRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClientResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetClientResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.example.com/springsoap/gen", name = "getClientResponse")
    public JAXBElement<GetClientResponse> createGetClientResponse(GetClientResponse value) {
        return new JAXBElement<GetClientResponse>(_GetClientResponse_QNAME, GetClientResponse.class, null, value);
    }

}
