package org.integrator.models;

import java.util.Set;

public interface CityModel extends HasId, HasAttributes {

    String getName();

    void setName(String name);

    Set<CityModel> getChildrenDistricts();

    void addChildrenDistrict(CityModel district);

    boolean removeChildrenDistrict(CityModel district);

    CityModel getParentDistrict();

    void setParentDistrict(CityModel district);
}
