/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.p90puma.arduinows;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.inject.Singleton;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author P90Puma
 */
@WebService()
@Singleton
public class ArduinoWS {

    SerialPort serial_port;
    InputStream input;
    OutputStream output;
    static ArduinoSerialPortListener aspl;

    @WebMethod(operationName = "SendSerialInput")
    public String sendSerialInput(@WebParam(name = "inputToArduino") String inputToArduino) {
        try {
            if (aspl == null) {
                aspl = new ArduinoSerialPortListener();
            }
            aspl.writeToArduino(inputToArduino);
            return "Sent [" + inputToArduino + "] via Serial!";
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return ex.toString();
        }
    }

    @WebMethod(operationName = "SetupArduinoSerial")
    public String setupArduinoSerial(@WebParam(name = "serialPort") String serialPort) {
        try {
            //close the serial connection if it already exists, to prevent port conflicts.
            if (aspl != null) {
                aspl.close();
            }
            aspl = new ArduinoSerialPortListener(serialPort);
            return "Setup the Arduino on port: [" + serialPort + "]";
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return ex.toString();
        }
    }

    @WebMethod(operationName = "closeArduinoSerial")
    public String closeArduinoSerial() {
        try {
            aspl.close();
            aspl = null;
            return "Closed the Arduino serial connection";
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return ex.toString();
        }
    }

    @WebMethod(operationName = "getSerialPortNames")
    public ArrayList<String> getSerialPortNames() {
        ArrayList<String> portNames = new ArrayList<String>();

        try {
            if (aspl == null) {
                aspl = new ArduinoSerialPortListener();
            }
            ArrayList<CommPortIdentifier> ports = ArduinoSerialPortListener.getSerialPorts();
            for (CommPortIdentifier cpi : ports) {
                portNames.add(cpi.getName());
            }

        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            return portNames;
        }
    }
}
