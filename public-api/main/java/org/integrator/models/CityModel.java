package org.integrator.models;

import java.util.Set;

public interface CityModel extends HasId, HasAttributes {

    String getName();

    void setName(String name);

    Set<CityModel> getChildrenDistricts();

    void addChildrenDistrict(CityModel district);

    void removeChildrenDistrict(CityModel district);


    Set<CityModel> getParentDistricts();

    void addParentDistrict(CityModel district);

    void removeParentDistrict(CityModel district);
}
