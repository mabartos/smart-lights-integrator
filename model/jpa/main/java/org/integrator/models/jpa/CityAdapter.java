package org.integrator.models.jpa;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.integrator.models.CityModel;

import java.util.Map;

public class CityAdapter implements CityModel {
    @Override
    public Uni<String> getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public Multi<CityModel> getChildrenDistricts() {
        return null;
    }

    @Override
    public void addChildrenDistrict(CityModel district) {

    }

    @Override
    public void removeChildrenDistrict(CityModel district) {

    }

    @Override
    public Uni<CityModel> getParentDistrict() {
        return null;
    }

    @Override
    public void setParentDistrict(CityModel district) {

    }

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
}
