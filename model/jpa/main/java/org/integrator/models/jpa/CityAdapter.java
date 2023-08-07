package org.integrator.models.jpa;

import org.hibernate.reactive.mutiny.Mutiny;
import org.integrator.models.CityModel;
import org.integrator.models.jpa.entities.CityAttributeEntity;
import org.integrator.models.jpa.entities.CityEntity;

import java.util.Set;
import java.util.stream.Collectors;

public class CityAdapter extends AttributesEntity<CityAttributeEntity, CityEntity> implements CityModel {

    private final CityEntity entity;
    private final Mutiny.SessionFactory sf;

    public CityAdapter(CityEntity entity, Mutiny.SessionFactory sf) {
        super(entity);
        this.entity = entity;
        this.sf = sf;
    }

    @Override
    public String getId() {
        return entity.getId();
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
                .map(f -> new CityAdapter(f, sf))
                .collect(Collectors.toSet());
    }

    @Override
    public void addChildrenDistrict(CityModel district) {
        sf.withTransaction(session -> CityEntity.findById(district.getId())
                .onItem()
                .castTo(CityEntity.class)
                .invoke(s -> entity.getChildrenDistricts().add(s)));
    }

    @Override
    public boolean removeChildrenDistrict(CityModel district) {
        return entity.getChildrenDistricts().removeIf(f -> f.getId().equals(district.getId()));
    }

    @Override
    public CityModel getParentDistrict() {
        return new CityAdapter(entity.getParent(), sf);
    }

    @Override
    public void setParentDistrict(CityModel district) {
        sf.withTransaction(session -> CityEntity.findById(district.getId())
                .onItem()
                .castTo(CityEntity.class)
                .invoke(entity::setParent));
    }
}
