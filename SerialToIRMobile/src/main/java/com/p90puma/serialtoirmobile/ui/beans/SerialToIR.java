/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.p90puma.serialtoirmobile.ui.beans;

import com.p90puma.serialtoirmobile.data.HD20;
import com.p90puma.serialtoirmobile.data.HDMISwitch;
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

    //Z5500
    public void sendZ5500Power() {
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

    //OPTOMA HD20
    public void sendOptomaPowerON() {
        action.sendSerialInput(HD20.POWERON);
    }

    public void sendOptomaPowerOFF() {
        action.sendSerialInput(HD20.POWEROFF);
    }

    //HDMI Switch
    public void sendHDMIInput1() {
        action.sendSerialInput(HDMISwitch.INPUT1);
    }

    public void sendHDMIInput2() {
        action.sendSerialInput(HDMISwitch.INPUT2);
    }

    public void sendHDMIInput3() {
        action.sendSerialInput(HDMISwitch.INPUT3);
    }

    public void sendHDMIInput4() {
        action.sendSerialInput(HDMISwitch.INPUT4);
    }

}