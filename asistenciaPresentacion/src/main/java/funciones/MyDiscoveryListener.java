package funciones;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;

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

    public void addPropertyListener(PropertyChangeListener l) {
        changes.addPropertyChangeListener(l);
    }

    public void removePropertyListener(PropertyChangeListener l) {
        changes.removePropertyChangeListener(l);
    }

    public MyDiscoveryListener() {
    }

}
