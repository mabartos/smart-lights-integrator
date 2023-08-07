package org.integrator.models.jpa.entities;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;
import org.integrator.models.Coordinates;

import java.util.HashSet;
import java.util.Set;

@Entity
public class DeviceEntity extends PanacheEntity implements HasEntityAttributes<DeviceAttributeEntity> {
    private String serialNo;
    private String deviceType;
    private boolean enabled = true;
    @ManyToOne
    private StreetEntity street;
    @Embedded
    private Coordinates coordinates;
    @ManyToMany
    private Set<DeviceEntity> neighbours;

    @Version
    private int version;

    @OneToMany(cascade = {CascadeType.REMOVE}, orphanRemoval = true, mappedBy = "device", fetch = FetchType.EAGER)
    private Set<DeviceAttributeEntity> attributes = new HashSet<>();

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public StreetEntity getStreet() {
        return street;
    }

    public void setStreet(StreetEntity street) {
        this.street = street;
    }


    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Set<DeviceEntity> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(Set<DeviceEntity> neighbours) {
        this.neighbours = neighbours;
    }

    public Set<DeviceAttributeEntity> getAttributes() {
        return attributes;
    }

}
