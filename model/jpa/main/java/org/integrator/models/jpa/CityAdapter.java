package org.integrator.models.jpa;

import org.integrator.models.CityModel;
import org.integrator.models.jpa.entities.CityAttributeEntity;
import org.integrator.models.jpa.entities.CityEntity;

import java.util.Set;
import java.util.stream.Collectors;

public class CityAdapter extends AttributesEntity<CityAttributeEntity, CityEntity> implements CityModel {

    private final CityEntity entity;

    public CityAdapter(CityEntity entity) {
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
    public String getName() {
        return entity.getName();
    }

    @Override
    public void setName(String name) {
        entity.setName(name);
    }

    @Override
    public Set<CityModel> getChildrenDistricts() {
        return entity.getChildrenDistricts()
                .stream()
                .map(CityAdapter::new)
                .collect(Collectors.toSet());
    }

    @Override
    public void addChildrenDistrict(CityModel district) {
        //TODO find
    }

    @Override
    public boolean removeChildrenDistrict(CityModel district) {
        //todo change ID
        return entity.getChildrenDistricts().removeIf(f -> f.id.toString().equals(district.getId()));
    }

    @Override
    public CityModel getParentDistrict() {
        return new CityAdapter(entity.getParent());
    }

    @Override
    public void setParentDistrict(CityModel district) {
        // todo find parent
        //entity.setParent(district);
    }
}
