package org.integrator.models.jpa;

import org.hibernate.reactive.mutiny.Mutiny;
import org.integrator.IntegratorSession;
import org.integrator.models.CityModel;
import org.integrator.models.StreetModel;
import org.integrator.models.jpa.entities.CityEntity;
import org.integrator.models.jpa.entities.StreetAttributeEntity;
import org.integrator.models.jpa.entities.StreetEntity;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class StreetAdapter extends AttributesEntity<StreetAttributeEntity, StreetEntity> implements StreetModel {

    private final IntegratorSession session;
    private final StreetEntity entity;
    private final Mutiny.SessionFactory sf;

    public StreetAdapter(IntegratorSession session, StreetEntity entity, Mutiny.SessionFactory sf) {
        super(entity);
        this.session = session;
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
    public CityModel getCity() {
        return new CityAdapter(session, entity.getCity(), sf);
    }

    @Override
    public void setCity(CityModel city) {
        sf.withTransaction(session -> CityEntity.findById(city.getId())
                .onItem()
                .castTo(CityEntity.class)
                .invoke(entity::setCity));
    }

    @Override
    public Set<StreetModel> getSubStreets() {
        return entity.getSubStreets()
                .stream()
                .map(f -> new StreetAdapter(session, entity, sf))
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
        return entity.getSubStreets().removeIf(f -> f.getId().equals(street.getId()));
    }

    @Override
    public Optional<StreetModel> getParentStreet() {
        final StreetEntity found = entity.getParentStreet();
        return found != null ? Optional.of(new StreetAdapter(session, entity.getParentStreet(), sf)) : Optional.empty();
    }

    @Override
    public void setParentStreet(StreetModel street) {
        sf.withTransaction(session -> StreetEntity.findById(street.getId())
                .onItem()
                .castTo(StreetEntity.class)
                .invoke(entity::setParentStreet));
    }
}
