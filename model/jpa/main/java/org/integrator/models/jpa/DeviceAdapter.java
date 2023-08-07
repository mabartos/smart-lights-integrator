package org.integrator.models.jpa;

import org.hibernate.reactive.mutiny.Mutiny;
import org.integrator.models.Coordinates;
import org.integrator.models.DeviceModel;
import org.integrator.models.StreetModel;
import org.integrator.models.jpa.entities.DeviceAttributeEntity;
import org.integrator.models.jpa.entities.DeviceEntity;
import org.integrator.models.jpa.entities.StreetEntity;

import java.util.Set;
import java.util.stream.Collectors;

public class DeviceAdapter extends AttributesEntity<DeviceAttributeEntity, DeviceEntity> implements DeviceModel {

    private final DeviceEntity entity;
    private final Mutiny.SessionFactory sf;

    public DeviceAdapter(DeviceEntity entity, Mutiny.SessionFactory sf) {
        super(entity);
        this.entity = entity;
        this.sf = sf;
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
        return new StreetAdapter(entity.getStreet(), sf);
    }

    @Override
    public void setStreet(StreetModel street) {
        sf.withTransaction(session -> StreetEntity.findById(street.getId())
                .onItem()
                .castTo(StreetEntity.class)
                .invoke(entity::setStreet));
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
        return entity.getNeighbours()
                .stream()
                .map(f -> new DeviceAdapter(entity, sf))
                .collect(Collectors.toSet());
    }

    @Override
    public void addNeighbour(DeviceModel device) {
        //TODO Could be fetched from cache
        sf.withTransaction(session -> DeviceEntity.findById(device.getId())
                .onItem()
                .castTo(DeviceEntity.class)
                .invoke(dev -> entity.getNeighbours().add(dev)));
    }

    @Override
    public boolean removeNeighbour(DeviceModel device) {
        //TODO IDs
        return entity.getNeighbours().removeIf(f -> device.getId().equals(f.id.toString()));
    }
}
