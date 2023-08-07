package org.integrator.models;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public interface StreetModel extends HasId, HasAttributes {

    Uni<String> getName();

    void setName(String name);

    Uni<CityModel> getCity();

    void setCity(CityModel city);

    Multi<StreetModel> getChildrenStreets();

    void addChildrenStreet(StreetModel street);

    void removeChildrenStreet(StreetModel street);

    Uni<StreetModel> getParentStreet();

    void setParentStreet(StreetModel street);
}
