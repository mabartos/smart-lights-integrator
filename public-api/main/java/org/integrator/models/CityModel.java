package org.integrator.models;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public interface CityModel extends HasId, HasAttributes {

    Uni<String> getName();

    void setName(String name);

    Multi<CityModel> getChildrenDistricts();

    void addChildrenDistrict(CityModel district);

    void removeChildrenDistrict(CityModel district);


    Uni<CityModel> getParentDistrict();

    void setParentDistrict(CityModel district);
}
