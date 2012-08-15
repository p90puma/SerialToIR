/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.p90puma.arduinows;

import gnu.io.CommPortIdentifier;
import java.util.ArrayList;
import java.util.Enumeration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sjakubowski
 */
public class ArduinoWSTest {

    public ArduinoWSTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of sendSerialInput method, of class ArduinoWS.
     */
    @Test
    public void testSendSerialInput() {
        System.out.println("sendSerialInput");
    }

    /**
     * Test of setupArduinoSerial method, of class ArduinoWS.
     */
    @Test
    public void testSetupArduinoSerial() {
        System.out.println("setupArduinoSerial");
    }

    /**
     * Test of closeArduinoSerial method, of class ArduinoWS.
     */
    @Test
    public void testCloseArduinoSerial() {
        System.out.println("closeArduinoSerial");
    }

    /**
     * Test of getSerialPortNames method, of class ArduinoWS.
     */
    @Test
    public void testGetSerialPortNames() {
        ArrayList<CommPortIdentifier> ports = new ArrayList<CommPortIdentifier>();
        CommPortIdentifier port;
        Enumeration portList = CommPortIdentifier.getPortIdentifiers();
        System.out.println("Get List");
        while (portList.hasMoreElements()) {
            port = (CommPortIdentifier) portList.nextElement();
                            System.out.println("NOT SERIAL " + port.getName());

            if (port.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                ports.add(port);
                System.out.println(port.getName());
            }
        }
    }
}
