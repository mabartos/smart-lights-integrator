package org.integrator.models.jpa.entities;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;

import java.util.HashSet;
import java.util.Set;

@Entity
public class CityEntity extends PanacheEntity implements HasEntityAttributes<CityAttributeEntity> {
    private String name;
    @ManyToOne
    private CityEntity parent;
    @OneToMany
    private Set<CityEntity> districts;

    @Version
    private int version;

    @OneToMany(cascade = {CascadeType.REMOVE}, orphanRemoval = true, mappedBy = "city", fetch = FetchType.EAGER)
    private Set<CityAttributeEntity> attributes = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CityEntity getParent() {
        return parent;
    }

    public void setParent(CityEntity parent) {
        this.parent = parent;
    }

    public Set<CityEntity> getChildrenDistricts() {
        return districts;
    }

    public void setChildrenDistricts(Set<CityEntity> districts) {
        this.districts = districts;
    }

    public Set<CityAttributeEntity> getAttributes() {
        return attributes;
    }

}
