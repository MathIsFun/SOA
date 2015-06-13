
package com.soa_study.main;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "HelloWorldStudentService", targetNamespace = "http://service.soa_study.com/", wsdlLocation = "http://localhost:8080/lab_soa-ejb-1.0/HelloWorldStudent?wsdl")
public class HelloWorldStudentService
    extends Service
{

    private final static URL HELLOWORLDSTUDENTSERVICE_WSDL_LOCATION;
    private final static WebServiceException HELLOWORLDSTUDENTSERVICE_EXCEPTION;
    private final static QName HELLOWORLDSTUDENTSERVICE_QNAME = new QName("http://service.soa_study.com/", "HelloWorldStudentService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/lab_soa-ejb-1.0/HelloWorldStudent?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        HELLOWORLDSTUDENTSERVICE_WSDL_LOCATION = url;
        HELLOWORLDSTUDENTSERVICE_EXCEPTION = e;
    }

    public HelloWorldStudentService() {
        super(__getWsdlLocation(), HELLOWORLDSTUDENTSERVICE_QNAME);
    }

    public HelloWorldStudentService(WebServiceFeature... features) {
        super(__getWsdlLocation(), HELLOWORLDSTUDENTSERVICE_QNAME, features);
    }

    public HelloWorldStudentService(URL wsdlLocation) {
        super(wsdlLocation, HELLOWORLDSTUDENTSERVICE_QNAME);
    }

    public HelloWorldStudentService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, HELLOWORLDSTUDENTSERVICE_QNAME, features);
    }

    public HelloWorldStudentService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HelloWorldStudentService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns HelloWorldStudent
     */
    @WebEndpoint(name = "HelloWorldStudentPort")
    public HelloWorldStudent getHelloWorldStudentPort() {
        return super.getPort(new QName("http://service.soa_study.com/", "HelloWorldStudentPort"), HelloWorldStudent.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HelloWorldStudent
     */
    @WebEndpoint(name = "HelloWorldStudentPort")
    public HelloWorldStudent getHelloWorldStudentPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.soa_study.com/", "HelloWorldStudentPort"), HelloWorldStudent.class, features);
    }

    private static URL __getWsdlLocation() {
        if (HELLOWORLDSTUDENTSERVICE_EXCEPTION!= null) {
            throw HELLOWORLDSTUDENTSERVICE_EXCEPTION;
        }
        return HELLOWORLDSTUDENTSERVICE_WSDL_LOCATION;
    }

}