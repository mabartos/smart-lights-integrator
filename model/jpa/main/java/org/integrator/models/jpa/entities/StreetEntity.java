package org.integrator.models.jpa.entities;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class StreetEntity extends PanacheEntity {
    private String name;
    @ManyToOne
    private CityEntity city;
    @OneToMany
    private Set<StreetEntity> subStreets;
    @ManyToOne
    private StreetEntity parentStreet;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }

    public Set<StreetEntity> getSubStreets() {
        return subStreets;
    }

    public void setSubStreets(Set<StreetEntity> subStreets) {
        this.subStreets = subStreets;
    }

    public StreetEntity getParentStreet() {
        return parentStreet;
    }

    public void setParentStreet(StreetEntity street) {
        this.parentStreet = street;
    }
}
