/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.p90puma.serialtoirmobile.ui.beans;

import com.p90puma.serialtoirmobile.impl.SerialToIRImpl;
import java.util.ArrayList;
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
    private String ports = "Click me->"; //default

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPorts() {
        return ports;
    }

    public void setPorts(String ports) {
        this.ports = ports;
    }

    public void setupSerial() {
        action.setupSerial(port);
    }

    public void getSerialPorts() {
        ArrayList<String> serialPorts = action.getSerialPorts();
        ports = "";
        for (String str : serialPorts) {
            ports = ports + str + " ";
        }
        ports = ports.trim();
        setPorts(ports);
    }
}