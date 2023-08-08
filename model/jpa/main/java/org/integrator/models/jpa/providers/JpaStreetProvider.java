package org.integrator.models.jpa.providers;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import io.smallrye.mutiny.Uni;
import org.hibernate.reactive.mutiny.Mutiny;
import org.integrator.IntegratorSession;
import org.integrator.models.CityModel;
import org.integrator.models.StreetModel;
import org.integrator.models.jpa.StreetAdapter;
import org.integrator.models.jpa.entities.CityEntity;
import org.integrator.models.jpa.entities.StreetEntity;
import org.integrator.providers.StreetProvider;

import java.util.List;
import java.util.stream.Collectors;

public class JpaStreetProvider implements StreetProvider {

    private final IntegratorSession session;
    private final Mutiny.SessionFactory sf;

    public JpaStreetProvider(IntegratorSession session, Mutiny.SessionFactory sf) {
        this.session = session;
        this.sf = sf;
    }

    private Uni<StreetModel> cast(Uni<? extends PanacheEntityBase> entity) {
        return entity.onItem().castTo(StreetEntity.class).map(f -> new StreetAdapter(session, f, sf));
    }

    private Uni<List<StreetModel>> castList(Uni<List<PanacheEntityBase>> list) {
        return list.map(f -> f.stream()
                .map(street -> (StreetEntity) f)
                .map(streetEntity -> new StreetAdapter(session, streetEntity, sf))
                .collect(Collectors.toList()));
    }

    @Override
    public Uni<StreetModel> createStreet(CityModel city, String name) {
        return CityEntity.findById(city.getId())
                .onItem()
                .castTo(CityEntity.class)
                .flatMap(cityEntity -> {
                    StreetEntity street = new StreetEntity();
                    street.setName(name);
                    street.setCity(cityEntity);
                    return cast(street.persistAndFlush());
                });
    }

    @Override
    public Uni<StreetModel> getById(String id) {
        return cast(StreetEntity.findById(id));
    }

    @Override
    public Uni<StreetModel> getByName(String cityName, String streetName) {
        return cast(sf.withTransaction(s -> s.createNamedQuery("StreetEntity.getByName", StreetEntity.class)
                .setParameter("streetName", streetName)
                .setParameter("cityName", cityName)
                .getSingleResult()));
    }

    @Override
    public Uni<Boolean> deleteById(String id) {
        return StreetEntity.deleteById(id);
    }

    @Override
    public Uni<StreetModel> update(String streetId, StreetModel street) {
        //TODO
        return null;
    }
}
