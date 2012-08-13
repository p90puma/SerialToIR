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
public class SerialToIR {

    private final static String Z5500_POWER = "10EF08F7";
    private final static String Z5500_DIRECT = "10EF08F7";
    private final static String Z5500_OPTICAL = "10EF08F7";
    private final static String Z5500_VOLUP = "10EF08F7";
    private final static String Z5500_VOLDOWN = "10EF08F7";
    
    SerialToIRImpl action = new SerialToIRImpl();

    public void sendPower() {
        action.sendSerialInput(Z5500_POWER);
    }

    public void sendOptical() {
        action.sendSerialInput(Z5500_OPTICAL);
    }

    public void sendDirect() {
        action.sendSerialInput(Z5500_DIRECT);
    }

    public void sendVolUP() {
        action.sendSerialInput(Z5500_VOLUP);        
    }

    public void sendVolDOWN() {
        action.sendSerialInput(Z5500_VOLDOWN);
    }
}