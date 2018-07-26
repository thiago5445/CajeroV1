/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gnu.monedero.utils;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author dizurieta
 */
public class Monedero extends Thread {
    private static final  Logger logs = LogManager.getLogger("Monedero"); 
    public boolean status = true;
    private Etiqueta dialog;
    public Monedero(Etiqueta dialog){
        this.dialog = dialog;
    }
    
    public void run() {
        SerialPort serialPort = null;
        CommPortIdentifier portId = null;
        InputStream in = null;
        BufferedReader is = null; 
        
        try {//0950223289
            //Sette port
            /*portId = CommPortIdentifier.getPortIdentifier(Config.getValue("serial_port"));
             //portId = CommPortIdentifier.getPortIdentifier("COM1");
            //events
            
            // open serial port, and use class name for the appName.
            serialPort = (SerialPort) portId.open(this.getClass().getName(), Config.getIntValue("serial_timeout"));
            //serialPort = (SerialPort) portId.open(this.getClass().getName(), 2000);
            
            serialPort.setSerialPortParams(Config.getIntValue("serial_baudRate"), 
            //serialPort.setSerialPortParams(9600, 
                                            SerialPort.DATABITS_8,
                                            SerialPort.STOPBITS_1,
                                            SerialPort.PARITY_NONE);
            //serialPort.setDTR(true);

        in = serialPort.getInputStream();
            int valor = Config.getInt(dialog.dolar);
            int data = 0;
            byte[] buffer = new byte[1024];
            int moneda = 25;
            
            while(status){
                int len = 0;
                while (in.available() > 0)
                {
                    data = in.read();
                    if ( data == -1 || data == '\n' ) {
                        break;
                    }
                    buffer[len++] = (byte) data;
                }
            
                
                */
                //int len = 1;
                //int valor = 25;
                
                //if (len > 0){
                //if (true){
                    //String moneda_string = new String(buffer,0,len);
                    //moneda+= Integer.parseInt(moneda_string.trim());
                    //dialog.changeMessage(String.format(dialog.message,dialog.dolar,moneda));
                    //dialog.changeMessage("hola");
                    //if (valor <= moneda)
                    //{
                        //status = false;
                    //}
                //}
                
            
            //serialPort.close();
            JOptionPane.showMessageDialog(null, "De click en aceptar e inserte moneda");
            
            sleep(1500);
            dialog.status = true;
            dialog.setVisible(false);
            
        } catch (Exception ex) {
            logs.error("Exception: ",ex);
        }
    }
}

