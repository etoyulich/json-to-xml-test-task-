
package com.example.testtaskjsontoxml.service.newgen;

import org.springframework.beans.factory.annotation.Value;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.3-b01
 * Generated source version: 2.2
 * 
 */

@WebServiceClient(name = "ClientWSService", targetNamespace = "http://www.example.com/springsoap/gen")
public class ClientWSService
    extends Service
{

    private final static URL CLIENTWSSERVICE_WSDL_LOCATION;
    private final static WebServiceException CLIENTWSSERVICE_EXCEPTION;
    private final static QName CLIENTWSSERVICE_QNAME = new QName("http://www.example.com/springsoap/gen", "ClientWSService");

    static {
        WebServiceException e = null;
        CLIENTWSSERVICE_WSDL_LOCATION = ClientWSService.class.getClassLoader().getResource("client.wsdl");
        if(CLIENTWSSERVICE_WSDL_LOCATION == null){
            e = new WebServiceException("Can't find find wsdl file in classpath.");
        }
        CLIENTWSSERVICE_EXCEPTION = e;
    }

    public ClientWSService() {
        super(__getWsdlLocation(), CLIENTWSSERVICE_QNAME);
    }

    public ClientWSService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CLIENTWSSERVICE_QNAME, features);
    }

    public ClientWSService(URL wsdlLocation) {
        super(wsdlLocation, CLIENTWSSERVICE_QNAME);
    }

    public ClientWSService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CLIENTWSSERVICE_QNAME, features);
    }

    public ClientWSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ClientWSService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ClientInterface
     */
    @WebEndpoint(name = "ClientInterface")
    public ClientInterface getClientWSPortBinding() {
        return super.getPort(new QName("http://www.example.com/springsoap/gen", "ClientWSPortBindingSoap11"), ClientInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {&#064;link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the &lt;code&gt;features&lt;/code&gt; parameter will have their default values.
     * @return
     *     returns ClientInterface
     */
    @WebEndpoint(name = "ClientInterface")
    public ClientInterface getClientWSPortBinding(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.example.com/springsoap/gen", "ClientWSPortBindingSoap11"), ClientInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CLIENTWSSERVICE_EXCEPTION!= null) {
            throw CLIENTWSSERVICE_EXCEPTION;
        }
        return CLIENTWSSERVICE_WSDL_LOCATION;
    }

}
