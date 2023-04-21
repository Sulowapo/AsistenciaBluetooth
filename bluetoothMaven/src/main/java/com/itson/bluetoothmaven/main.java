/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.itson.bluetoothmaven;

import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.bluetooth.BluetoothStateException;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;

/**
 *
 * @author gilberto.borrego
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Vector<RemoteDevice> devices = new RemoteDeviceDiscovery().getDevices();
            for (RemoteDevice d : devices) {
                System.out.println(d.getFriendlyName(true));
            }
            
        } catch (BluetoothStateException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private LocalDevice localDevice; // local Bluetooth Manager
    private DiscoveryAgent discoveryAgent; // discovery agent
    
    /**
     * Initialize
     */
    public void btInit() throws BluetoothStateException {
        localDevice = null;
        discoveryAgent = null;
        // Retrieve the local device to get to the Bluetooth Manager
     
        localDevice = LocalDevice.getLocalDevice();                   
        // Servers set the discoverable mode to GIAC
        localDevice.setDiscoverable(DiscoveryAgent.GIAC);                   
        // Clients retrieve the discovery agent
        discoveryAgent =  localDevice.getDiscoveryAgent();   
        RemoteDevice[] devices = discoveryAgent.retrieveDevices(0);
        try {
            System.out.println("remote = " + devices[0].getFriendlyName(true)); 
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
