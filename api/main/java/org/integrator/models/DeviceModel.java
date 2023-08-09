package org.integrator.models;

import java.util.Optional;
import java.util.Set;

public interface DeviceModel extends HasId, HasAttributes {
    String getSerialNo();

    void setSerialNo(String serialNo);

    Optional<String> getDeviceType();

    void setDeviceType(String type);

    StreetModel getStreet();

    void setStreet(StreetModel street);

    boolean isEnabled();

    void enable(boolean enable);

    Optional<Coordinates> getCoordinates();

    void setCoordinates(Coordinates coordinates);

    Set<DeviceModel> getNeighbours();

    void addNeighbour(DeviceModel device);

    boolean removeNeighbour(DeviceModel device);
}
