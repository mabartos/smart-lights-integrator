package org.integrator.models;

import java.util.Set;

public interface DeviceModel extends HasId, HasAttributes {
    String getSerialNo();

    void setSerialNo(String serialNo);

    String getDeviceType();

    void setDeviceType(String type);

    StreetModel getStreet();

    void setStreet(StreetModel street);

    boolean isEnabled();

    void enable(boolean enable);

    Coordinates getCoordinates();

    void setCoordinates(Coordinates coordinates);

    Set<DeviceModel> getNeighbours();

    boolean addNeighbour(DeviceModel device);

    boolean removeNeighbour(DeviceModel device);
}
