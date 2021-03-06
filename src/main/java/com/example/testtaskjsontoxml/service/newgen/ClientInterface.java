
package com.example.testtaskjsontoxml.service.newgen;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.3-b01
 * Generated source version: 2.2
 *
 */
@WebService(name = "ClientInterface", targetNamespace = "http://www.example.com/springsoap/gen")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
        ObjectFactory.class
})
public interface ClientInterface {


    /**
     *
     * @param request
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "response", targetNamespace = "")
    @RequestWrapper(localName = "getClientRequest", targetNamespace = "http://www.example.com/springsoap/gen", className = "com.example.springsoap.gen.newgen.GetClientRequest")
    @ResponseWrapper(localName = "getClientResponse", targetNamespace = "http://www.example.com/springsoap/gen", className = "com.example.springsoap.gen.newgen.GetClientResponse")
    public GetClientResponse getClientRequest(
            @WebParam(name = "request", targetNamespace = "")
            GetClientRequest request);

}
