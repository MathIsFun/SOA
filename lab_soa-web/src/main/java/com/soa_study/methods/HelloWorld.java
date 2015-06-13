package com.soa_study.methods;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
//Specifies the mapping of the Web Service onto the SOAP message protocol.

public interface HelloWorld {

    @WebMethod
    String getHelloWorldFor(String name);


}
