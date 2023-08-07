package org.integrator.models.jpa;

import org.integrator.models.CityModel;
import org.integrator.models.StreetModel;
import org.integrator.models.jpa.entities.StreetAttributeEntity;
import org.integrator.models.jpa.entities.StreetEntity;

import java.util.Set;
import java.util.stream.Collectors;

public class StreetAdapter extends AttributesEntity<StreetAttributeEntity, StreetEntity> implements StreetModel {

    private final StreetEntity entity;

    public StreetAdapter(StreetEntity entity) {
        super(entity);
        this.entity = entity;
    }

    @Override
    //TODO
    public String getId() {
        return entity.id.toString();
    }

    @Override
    public void setId(String id) {
        //todo
    }

    @Override
    public String getName() {
        return entity.getName();
    }

    @Override
    public void setName(String name) {
        entity.setName(name);
    }

    @Override
    public CityModel getCity() {
        return new CityAdapter(entity.getCity());
    }

    @Override
    public void setCity(CityModel city) {
        //todo
    }

    @Override
    public Set<StreetModel> getSubStreets() {
        return entity.getSubStreets().stream().map(StreetAdapter::new).collect(Collectors.toSet());
    }

    @Override
    public void addSubStreet(StreetModel street) {
        //todo
    }

    @Override
    public boolean removeSubStreet(StreetModel street) {
        //todo
        return entity.getSubStreets().removeIf(f -> f.id.toString().equals(street.getId()));
    }

    @Override
    public StreetModel getParentStreet() {
        return new StreetAdapter(entity.getParentStreet());
    }

    @Override
    public void setParentStreet(StreetModel street) {
        //todo
    }
}
