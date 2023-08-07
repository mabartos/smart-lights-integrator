package org.integrator.models.jpa;

import org.integrator.models.Coordinates;
import org.integrator.models.DeviceModel;
import org.integrator.models.StreetModel;
import org.integrator.models.jpa.entities.DeviceAttributeEntity;
import org.integrator.models.jpa.entities.DeviceEntity;

import java.util.Set;
import java.util.stream.Collectors;

public class DeviceAdapter extends AttributesEntity<DeviceAttributeEntity, DeviceEntity> implements DeviceModel {

    private final DeviceEntity entity;

    public DeviceAdapter(DeviceEntity entity) {
        super(entity);
        this.entity = entity;
    }

    @Override
    public String getId() {
        return entity.id.toString();
    }

    @Override
    public void setId(String id) {
        //todo UUID
    }

    @Override
    public String getSerialNo() {
        return entity.getSerialNo();
    }

    @Override
    public void setSerialNo(String serialNo) {
        entity.setSerialNo(serialNo);
    }

    @Override
    public String getDeviceType() {
        return entity.getDeviceType();
    }

    @Override
    public void setDeviceType(String type) {
        entity.setDeviceType(type);
    }

    @Override
    public StreetModel getStreet() {
        return new StreetAdapter(entity.getStreet());
    }

    @Override
    public void setStreet(StreetModel street) {
        //todo find
    }

    @Override
    public boolean isEnabled() {
        return entity.isEnabled();
    }

    @Override
    public void enable(boolean enable) {
        entity.setEnabled(enable);
    }

    @Override
    public Coordinates getCoordinates() {
        return entity.getCoordinates();
    }

    @Override
    public void setCoordinates(Coordinates coordinates) {
        entity.setCoordinates(coordinates);
    }

    @Override
    public Set<DeviceModel> getNeighbours() {
        return entity.getNeighbours().stream().map(DeviceAdapter::new).collect(Collectors.toSet());
    }

    @Override
    public boolean addNeighbour(DeviceModel device) {
        //todo find
        return false;
    }

    @Override
    public boolean removeNeighbour(DeviceModel device) {
        //TODO IDs
        return entity.getNeighbours().removeIf(f -> device.getId().equals(f.id.toString()));
    }
}
