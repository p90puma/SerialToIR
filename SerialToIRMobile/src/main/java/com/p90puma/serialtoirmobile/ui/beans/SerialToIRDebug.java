/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.p90puma.serialtoirmobile.ui.beans;

import com.p90puma.serialtoirmobile.impl.SerialToIRImpl;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author sjakubowski
 */
@ManagedBean
@ApplicationScoped
public class SerialToIRDebug {

    SerialToIRImpl action = new SerialToIRImpl();

    private String port = "ttyUSB0"; //default

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setupSerial() {
        action.setupSerial(port);
    }

}