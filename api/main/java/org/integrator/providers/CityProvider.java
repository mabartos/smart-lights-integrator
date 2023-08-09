package org.integrator.providers;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.integrator.models.CityModel;

import java.util.List;

public interface CityProvider extends Provider {

    Uni<CityModel> createCity(String name);

    Uni<CityModel> getById(String id);

    Uni<List<CityModel>> getByName(String name);

    Uni<List<CityModel>> getAll(Integer firstResult, Integer maxResults);

    default Uni<List<CityModel>> getAll() {
        return getAll(null, null);
    }

    Uni<Boolean> deleteCityById(String id);

    Uni<CityModel> updateCity(String id, CityModel city);


}
