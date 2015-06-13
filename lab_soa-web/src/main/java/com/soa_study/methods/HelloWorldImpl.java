package com.soa_study.methods;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


@WebService(endpointInterface = "com.soa_study.methods.HelloWorld")
public class HelloWorldImpl implements HelloWorld {
    private Logger logger = Logger.getLogger(HelloWorldImpl.class.getName());

    @Resource
    WebServiceContext wsctx;

    @Schedule(minute="*/3", hour="*")
    public void scheduleFunc(){
        System.out.println("schedule");
        logger.info((new Date()).toString()  + " schedule");
    }

    @Override
    public String getHelloWorldFor(String name) {
        MessageContext mctx = wsctx.getMessageContext();

        Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
        List userList = (List) http_headers.get("Username");
        List passList = (List) http_headers.get("Password");

        String username;
        String password;

        if(userList!=null)
            username = userList.get(0).toString();
        else
            username = "";

        if(passList!=null)
            password = passList.get(0).toString();
        else
            password ="";

        if (username.equals("pawel") && password.equals("pass")){
            return "Hello my saved user !" + username;
        }else{
            return "Unknown User!";
        }
    }
}
