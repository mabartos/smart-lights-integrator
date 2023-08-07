package org.integrator.models.jpa;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.integrator.models.Coordinates;
import org.integrator.models.DeviceModel;
import org.integrator.models.StreetModel;

import java.util.Map;

public class DeviceAdapter implements DeviceModel {

    @Override
    public Uni<String> getSerialNo() {
        return null;
    }

    @Override
    public void setSerialNo(String serialNo) {

    }

    @Override
    public Uni<String> getDeviceType() {
        return null;
    }

    @Override
    public void setDeviceType(String type) {

    }

    @Override
    public Uni<StreetModel> getStreet() {
        return null;
    }

    @Override
    public void setStreet(StreetModel street) {

    }

    @Override
    public Uni<Boolean> isEnabled() {
        return null;
    }

    @Override
    public void enable(boolean enable) {

    }

    @Override
    public Uni<Coordinates> getCoordinates() {
        return null;
    }

    @Override
    public void setCoordinates(Coordinates coordinates) {

    }

    @Override
    public Multi<DeviceModel> getNeighbours() {
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
    public Uni<Map<String, String>> getAttributes() {
        return null;
    }

    @Override
    public Uni<String> getAttribute(String name) {
        return null;
    }

    @Override
    public void setAttribute(String name, String value) {

    }

    @Override
    public void removeAttribute(String name) {

    }

    @Override
    public Uni<String> getId() {
        return null;
    }

    @Override
    public void setId(String id) {

    }
}
