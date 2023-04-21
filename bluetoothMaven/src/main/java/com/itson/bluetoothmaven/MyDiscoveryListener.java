/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.bluetoothmaven;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;

/**
 *
 * @author gilberto.borrego
 */
public class MyDiscoveryListener implements DiscoveryListener {
    private PropertyChangeSupport changes = new PropertyChangeSupport(this);
    private List<RemoteDevice> devicesDiscovered = new ArrayList<>();
    private Boolean finished = false;

    @Override
    public void deviceDiscovered(RemoteDevice rd, DeviceClass dc) {
        Object[] before = devicesDiscovered.toArray(RemoteDevice[]::new);
        devicesDiscovered.add(rd);
        Object[] after = devicesDiscovered.toArray(RemoteDevice[]::new);
        changes.firePropertyChange("devices", before, after);
    }

    @Override
    public void servicesDiscovered(int i, ServiceRecord[] srs) {

    }

    @Override
    public void serviceSearchCompleted(int i, int i1) {
        
    }

    @Override
    public void inquiryCompleted(int i) {
        finished = true;
        devicesDiscovered.clear();
    }
    
    public void addPropertyListener(PropertyChangeListener l){
        changes.addPropertyChangeListener(l);
    }
    
    public void removePropertyListener(PropertyChangeListener l){
        changes.removePropertyChangeListener(l);
    }

    public MyDiscoveryListener() {
    }
    
}
