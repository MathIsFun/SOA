package com.soa_study.service;

import org.jboss.ejb3.annotation.SecurityDomain;
import org.jboss.ws.api.annotation.AuthMethod;
import org.jboss.ws.api.annotation.TransportGuarantee;
import org.jboss.ws.api.annotation.WebContext;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@Stateless
@WebService(name="AuthorizationSecurityService", targetNamespace = "http://localhost:8080/")
@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.LITERAL)
@SecurityDomain("soapLabWsSD")
@RolesAllowed("Admin")
@WebContext(transportGuarantee = TransportGuarantee.NONE, secureWSDLAccess = false, authMethod = AuthMethod.BASIC)

public class AuthorizationSecurity {
    @WebMethod
    @RolesAllowed("Admin")
    public String hello(@WebParam(name = "UserName") String name){
        return "Witam admina: " + name;
    }
}
