package org.integrator.models;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import java.util.Set;

public interface CityModel extends HasId, HasAttributes {

    Uni<String> getName();

    void setName(String name);

    Multi<CityModel> getChildrenDistricts();

    void addChildrenDistrict(CityModel district);

    void removeChildrenDistrict(CityModel district);


    Multi<CityModel> getParentDistricts();

    void addParentDistrict(CityModel district);

    void removeParentDistrict(CityModel district);
}
