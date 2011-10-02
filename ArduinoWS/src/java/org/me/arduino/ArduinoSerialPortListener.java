/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.me.arduino;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.InputStream;
import java.io.OutputStream;
/**
 *
 * @author P90Puma
 */
public class ArduinoSerialPortListener implements SerialPortEventListener{

    public SerialPort serial_port;
    public InputStream input;
    public OutputStream output;

    public ArduinoSerialPortListener() {
        try{
        init();
        } catch (Exception e){
            int i =0;
            
        }
    }
    
    public void writeToArduino(String str) throws Exception{
        Thread.sleep(1500);

		output.write(str.getBytes());

		Thread.sleep(1000);

		input.close();
		input=null;

		output.close();
		output=null;

		    serial_port.close();
		    serial_port=null;
    }
    public void init() throws Exception{
        CommPortIdentifier portId = CommPortIdentifier.getPortIdentifier("COM4");//(CommPortIdentifier) n.nextElement();//CommPortIdentifier.getPortIdentifier(CommPortIdentifier.getPortIdentifiers());

            serial_port = (SerialPort) portId.open("Arduino", 2000);
            serial_port.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

            input = serial_port.getInputStream();
            output = serial_port.getOutputStream();

            // add event listeners
            serial_port.addEventListener((SerialPortEventListener)this);
            serial_port.notifyOnDataAvailable(true);
       
    }
     /**
     * This should be called when you stop using the port.
     * This will prevent port locking on platforms like Linux.
     */
    public synchronized void close() {
        if (serial_port != null) {
            serial_port.removeEventListener();
            serial_port.close();
        }
    }

    /**
     * Handle an event on the serial port. Read the data and print it.
     */
    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                int available = input.available();
                byte chunk[] = new byte[available];
                input.read(chunk, 0, available);

                // Displayed results are codepage dependent
                System.out.print(new String(chunk));
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
        // Ignore all the other eventTypes, but you should consider the other ones.
    }

}
