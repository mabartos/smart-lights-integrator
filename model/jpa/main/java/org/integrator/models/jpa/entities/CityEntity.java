package org.integrator.models.jpa.entities;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class CityEntity extends PanacheEntity {
    private String name;

    private CityEntity parent;
    private Set<CityEntity> districts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    public CityEntity getParent() {
        return parent;
    }

    public void setParent(CityEntity parent) {
        this.parent = parent;
    }

    @OneToMany
    public Set<CityEntity> getChildrenDistricts() {
        return districts;
    }

    public void setChildrenDistricts(Set<CityEntity> districts) {
        this.districts = districts;
    }

}
