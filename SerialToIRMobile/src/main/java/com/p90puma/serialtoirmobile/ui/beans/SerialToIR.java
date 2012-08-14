/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.p90puma.serialtoirmobile.ui.beans;

import com.p90puma.serialtoirmobile.data.Z5500;
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

    SerialToIRImpl action = new SerialToIRImpl();

    public void sendPower() {
        action.sendSerialInput(Z5500.POWER);
    }

    public void sendOptical() {
        action.sendSerialInput(Z5500.OPTICAL);
    }

    public void sendDirect() {
        action.sendSerialInput(Z5500.DIRECT);
    }

    public void sendVolUP() {
        action.sendSerialInput(Z5500.VOLUP);        
    }

    public void sendVolDOWN() {
        action.sendSerialInput(Z5500.VOLDOWN);
    }
}