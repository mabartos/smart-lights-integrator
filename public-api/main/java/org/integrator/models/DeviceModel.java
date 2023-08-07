package org.integrator.models;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public interface DeviceModel extends HasId, HasAttributes {
    Uni<String> getSerialNo();

    void setSerialNo(String serialNo);

    Uni<String> getDeviceType();

    void setDeviceType(String type);

    Uni<StreetModel> getStreet();

    void setStreet(StreetModel street);

    Uni<Boolean> isEnabled();

    void enable(boolean enable);

    Uni<Coordinates> getCoordinates();

    void setCoordinates(Coordinates coordinates);

    Multi<DeviceModel> getNeighbours();

    boolean addNeighbour(DeviceModel device);

    boolean removeNeighbour(DeviceModel device);
}
