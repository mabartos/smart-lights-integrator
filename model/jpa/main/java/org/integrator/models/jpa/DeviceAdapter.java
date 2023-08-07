package org.integrator.models.jpa;

import org.integrator.models.Coordinates;
import org.integrator.models.DeviceModel;
import org.integrator.models.StreetModel;

import java.util.Map;
import java.util.Set;

public class DeviceAdapter implements DeviceModel {
    @Override
    public String getSerialNo() {
        return null;
    }

    @Override
    public void setSerialNo(String serialNo) {

    }

    @Override
    public String getDeviceType() {
        return null;
    }

    @Override
    public void setDeviceType(String type) {

    }

    @Override
    public StreetModel getStreet() {
        return null;
    }

    @Override
    public void setStreet(StreetModel street) {

    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public void enable(boolean enable) {

    }

    @Override
    public Coordinates getCoordinates() {
        return null;
    }

    @Override
    public void setCoordinates(Coordinates coordinates) {

    }

    @Override
    public Set<DeviceModel> getNeighbours() {
        return null;
    }

    @Override
    public boolean addNeighbour(DeviceModel device) {
        return false;
    }

    @Override
    public boolean removeNeighbour(DeviceModel device) {
        return false;
    }

    @Override
    public Map<String, String> getAttributes() {
        return null;
    }

    @Override
    public void getAttribute(String name) {

    }

    @Override
    public void setAttribute(String name, String value) {

    }

    @Override
    public void removeAttribute(String name) {

    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(String id) {

    }
}
