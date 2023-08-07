package org.integrator.models.jpa.entities;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
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
public class StreetEntity extends PanacheEntityBase implements HasEntityAttributes<StreetAttributeEntity> {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", type = UuidGenerator.class)
    private UUID id;
    private String name;
    @ManyToOne
    private CityEntity city;
    @OneToMany
    private Set<StreetEntity> subStreets;
    @ManyToOne
    private StreetEntity parentStreet;

    @Version
    private int version;

    @OneToMany(cascade = {CascadeType.REMOVE}, orphanRemoval = true, mappedBy = "street", fetch = FetchType.EAGER)
    private Set<StreetAttributeEntity> attributes = new HashSet<>();

    public String getId() {
        return id.toString();
    }

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

    public Set<StreetAttributeEntity> getAttributes() {
        return attributes;
    }
}
