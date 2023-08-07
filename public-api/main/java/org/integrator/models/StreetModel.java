package org.integrator.models;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import java.util.Set;

public interface StreetModel extends HasId, HasAttributes {

    Uni<String> getName();

    void setName(String name);

    Uni<CityModel> getCity();

    void setCity(CityModel city);

    Multi<StreetModel> getChildrenStreets();

    void addChildrenStreet(StreetModel street);

    void removeChildrenStreet(StreetModel street);

    Multi<StreetModel> getParentStreets();

    void addParentStreet(StreetModel street);

    void removeParentStreet(StreetModel street);
}
