package org.integrator.providers;

import io.smallrye.mutiny.Uni;
import org.integrator.models.CityModel;
import org.integrator.models.StreetModel;

public interface StreetProvider {

    Uni<StreetModel> createStreet(CityModel city, String name);

    Uni<StreetModel> getById(String id);

    Uni<StreetModel> getByName(String cityName, String streetName);

    Uni<Boolean> deleteById(String id);

    Uni<StreetModel> update(String streetId, StreetModel street);

}
