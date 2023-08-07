package org.integrator.models;

import java.util.Set;

public interface StreetModel extends HasId, HasAttributes {

    String getName();

    void setName(String name);

    CityModel getCity();

    void setCity(CityModel city);

    Set<StreetModel> getChildrenStreets();

    void addChildrenStreet(StreetModel street);

    void removeChildrenStreet(StreetModel street);

    Set<StreetModel> getParentStreets();

    void addParentStreet(StreetModel street);

    void removeParentStreet(StreetModel street);
}
