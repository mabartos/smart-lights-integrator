package org.integrator.models.jpa;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.integrator.models.CityModel;
import org.integrator.models.StreetModel;

import java.util.Map;

public class StreetAdapter implements StreetModel {
    @Override
    public Uni<Map<String, String>> getAttributes() {
        return null;
    }

    @Override
    public Uni<String> getAttribute(String name) {
        return null;
    }

    @Override
    public void setAttribute(String name, String value) {

    }

    @Override
    public void removeAttribute(String name) {

    }

    @Override
    public Uni<String> getId() {
        return null;
    }

    @Override
    public void setId(String id) {

    }

    @Override
    public Uni<String> getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public Uni<CityModel> getCity() {
        return null;
    }

    @Override
    public void setCity(CityModel city) {

    }

    @Override
    public Multi<StreetModel> getChildrenStreets() {
        return null;
    }

    @Override
    public void addChildrenStreet(StreetModel street) {

    }

    @Override
    public void removeChildrenStreet(StreetModel street) {

    }

    @Override
    public Uni<StreetModel> getParentStreet() {
        return null;
    }

    @Override
    public void setParentStreet(StreetModel street) {

    }
}
