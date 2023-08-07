package org.integrator.models.jpa.entities;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.uuid.UuidGenerator;
import org.integrator.models.Coordinates;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class DeviceEntity extends PanacheEntityBase implements HasEntityAttributes<DeviceAttributeEntity> {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", type = UuidGenerator.class)
    private UUID id;
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

    public String getId() {
        return id.toString();
    }

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
