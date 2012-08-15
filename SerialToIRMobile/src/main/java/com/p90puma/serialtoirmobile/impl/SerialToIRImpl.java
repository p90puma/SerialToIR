/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.p90puma.serialtoirmobile.impl;

import com.p90puma.arduinows.ArduinoWS;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 *
 * @author sjakubowski
 */
public class SerialToIRImpl {

    public void sendSerialInput(String msg){

        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.getInInterceptors().add(new LoggingInInterceptor());
        factory.getOutInterceptors().add(new LoggingOutInterceptor());
        factory.setServiceClass(ArduinoWS.class);
        factory.setAddress("http://localhost:8084/ArduinoWS/ArduinoWSService");
        ArduinoWS client = (ArduinoWS) factory.create();
        String reply = client.sendSerialInput(msg);
        System.out.println("Server said: " + reply);
    }

    public void setupSerial(String port){

        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.getInInterceptors().add(new LoggingInInterceptor());
        factory.getOutInterceptors().add(new LoggingOutInterceptor());
        factory.setServiceClass(ArduinoWS.class);
        factory.setAddress("http://localhost:8084/ArduinoWS/ArduinoWSService");
        ArduinoWS client = (ArduinoWS) factory.create();
        String reply = client.setupArduinoSerial(port);
        System.out.println("Server said: " + reply);
    }
    
}
