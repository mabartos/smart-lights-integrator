package org.integrator.models;

import java.util.Set;

public interface StreetModel extends HasId, HasAttributes {

    String getName();

    void setName(String name);

    CityModel getCity();

    void setCity(CityModel city);

    Set<StreetModel> getSubStreets();

    void addSubStreet(StreetModel street);

    boolean removeSubStreet(StreetModel street);

    StreetModel getParentStreet();

    void setParentStreet(StreetModel street);
}
