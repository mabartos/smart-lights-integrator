package org.integrator.models;

import io.smallrye.mutiny.Uni;

import java.util.Optional;
import java.util.Set;

public interface CityModel extends HasId, HasAttributes {

    String getName();

    void setName(String name);

    Set<CityModel> getChildrenDistricts();

    void addChildrenDistrict(CityModel district);

    boolean removeChildrenDistrict(CityModel district);

    Optional<CityModel> getParentDistrict();

    void setParentDistrict(CityModel district);

    Uni<StreetModel> addStreet(String name);
}
