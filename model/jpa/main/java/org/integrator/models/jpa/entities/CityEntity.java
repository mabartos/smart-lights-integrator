package org.integrator.models.jpa.entities;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.uuid.UuidGenerator;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class CityEntity extends PanacheEntityBase implements HasEntityAttributes<CityAttributeEntity> {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", type = UuidGenerator.class)
    private UUID id;
    private String name;
    @ManyToOne
    private CityEntity parent;
    @OneToMany
    private Set<CityEntity> districts;

    @OneToMany
    private Set<StreetEntity> streets;

    @Version
    private int version;

    @OneToMany(cascade = {CascadeType.REMOVE}, orphanRemoval = true, mappedBy = "city", fetch = FetchType.EAGER)
    private Set<CityAttributeEntity> attributes = new HashSet<>();

    public String getId() {
        return id.toString();
    }

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

    public Set<StreetEntity> getStreets() {
        return streets;
    }

    public void setStreets(Set<StreetEntity> streets) {
        this.streets = streets;
    }

}
