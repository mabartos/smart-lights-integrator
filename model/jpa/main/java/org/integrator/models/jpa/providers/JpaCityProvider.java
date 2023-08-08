package org.integrator.models.jpa.providers;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import io.smallrye.mutiny.Uni;
import org.hibernate.reactive.mutiny.Mutiny;
import org.integrator.IntegratorSession;
import org.integrator.models.CityModel;
import org.integrator.models.jpa.CityAdapter;
import org.integrator.models.jpa.entities.CityEntity;
import org.integrator.providers.CityProvider;

import java.util.List;
import java.util.stream.Collectors;

public class JpaCityProvider implements CityProvider {

    private final IntegratorSession session;
    private final Mutiny.SessionFactory sf;

    public JpaCityProvider(IntegratorSession session, Mutiny.SessionFactory sf) {
        this.session = session;
        this.sf = sf;
    }

    private Uni<CityModel> cast(Uni<? extends PanacheEntityBase> entity) {
        return entity.onItem().castTo(CityEntity.class).map(f -> new CityAdapter(session, f, sf));
    }

    private Uni<List<CityModel>> castList(Uni<List<PanacheEntityBase>> list) {
        return list.map(f -> f.stream()
                .map(city -> (CityEntity) f)
                .map(cityEntity -> new CityAdapter(session, cityEntity, sf))
                .collect(Collectors.toList()));
    }

    @Override
    public Uni<CityModel> createCity(String name) {
        CityEntity city = new CityEntity();
        city.setName(name);
        return cast(city.persistAndFlush());
    }

    @Override
    public Uni<CityModel> getById(String id) {
        return cast(CityEntity.findById(id));
    }

    @Override
    public Uni<List<CityModel>> getByName(String name) {
        return castList(CityEntity.find("name", name).list());
    }

    @Override
    public Uni<List<CityModel>> getAll(Integer firstResult, Integer maxResults) {
        return castList(CityEntity.findAll().range(firstResult, firstResult + maxResults).list());
    }

    @Override
    public Uni<Boolean> deleteCityById(String id) {
        return CityEntity.deleteById(id);
    }

    @Override
    public Uni<CityModel> updateCity(String id, CityModel city) {
        //TODO properly update

        return cast(CityEntity.findById(id)
                .onItem()
                .castTo(CityEntity.class)
                .invoke((s) -> {
                    s.setName(city.getName());

                    if (!s.getParent().getId().equals(city.getParentDistrict().getId())) {
                        CityEntity.findById(city.getParentDistrict().getId()).onItem().castTo(CityEntity.class).invoke(s::setParent);
                    }
                }));
    }
}
