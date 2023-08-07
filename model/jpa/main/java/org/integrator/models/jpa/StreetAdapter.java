package org.integrator.models.jpa;

import org.hibernate.reactive.mutiny.Mutiny;
import org.integrator.models.CityModel;
import org.integrator.models.StreetModel;
import org.integrator.models.jpa.entities.CityEntity;
import org.integrator.models.jpa.entities.StreetAttributeEntity;
import org.integrator.models.jpa.entities.StreetEntity;

import java.util.Set;
import java.util.stream.Collectors;

public class StreetAdapter extends AttributesEntity<StreetAttributeEntity, StreetEntity> implements StreetModel {

    private final StreetEntity entity;
    private final Mutiny.SessionFactory sf;

    public StreetAdapter(StreetEntity entity, Mutiny.SessionFactory sf) {
        super(entity);
        this.entity = entity;
        this.sf = sf;
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
        return new CityAdapter(entity.getCity(), sf);
    }

    @Override
    public void setCity(CityModel city) {
        //todo IDs
        sf.withTransaction(session -> CityEntity.findById(city.getId())
                .onItem()
                .castTo(CityEntity.class)
                .invoke(entity::setCity));
    }

    @Override
    public Set<StreetModel> getSubStreets() {
        return entity.getSubStreets()
                .stream()
                .map(f -> new StreetAdapter(entity, sf))
                .collect(Collectors.toSet());
    }

    @Override
    public void addSubStreet(StreetModel street) {
        sf.withTransaction(session -> StreetEntity.findById(street.getId())
                .onItem()
                .castTo(StreetEntity.class)
                .invoke(s -> entity.getSubStreets().add(s)));
    }

    @Override
    public boolean removeSubStreet(StreetModel street) {
        //todo IDs
        return entity.getSubStreets().removeIf(f -> f.id.toString().equals(street.getId()));
    }

    @Override
    public StreetModel getParentStreet() {
        return new StreetAdapter(entity.getParentStreet(), sf);
    }

    @Override
    public void setParentStreet(StreetModel street) {
        sf.withTransaction(session -> StreetEntity.findById(street.getId())
                .onItem()
                .castTo(StreetEntity.class)
                .invoke(entity::setParentStreet));
    }
}
