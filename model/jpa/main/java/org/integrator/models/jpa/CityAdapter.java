package org.integrator.models.jpa;

import org.integrator.models.CityModel;

import java.util.Map;
import java.util.Set;

public class CityAdapter implements CityModel {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public Set<CityModel> getChildrenDistricts() {
        return null;
    }

    @Override
    public void addChildrenDistrict(CityModel district) {

    }

    @Override
    public void removeChildrenDistrict(CityModel district) {

    }

    @Override
    public Set<CityModel> getParentDistricts() {
        return null;
    }

    @Override
    public void addParentDistrict(CityModel district) {

    }

    @Override
    public void removeParentDistrict(CityModel district) {

    }

    @Override
    public Map<String, String> getAttributes() {
        return null;
    }

    @Override
    public void getAttribute(String name) {

    }

    @Override
    public void setAttribute(String name, String value) {

    }

    @Override
    public void removeAttribute(String name) {

    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(String id) {

    }
}
