package org.integrator.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import org.hibernate.reactive.mutiny.Mutiny;
import org.integrator.IntegratorSession;
import org.integrator.models.jpa.providers.JpaCityProvider;
import org.integrator.models.jpa.providers.JpaDeviceProvider;
import org.integrator.models.jpa.providers.JpaStreetProvider;
import org.integrator.providers.CityProvider;
import org.integrator.providers.DeviceProvider;
import org.integrator.providers.StreetProvider;

@RequestScoped
public class DefaultIntegratorSession implements IntegratorSession {

    @ApplicationScoped
    private Mutiny.SessionFactory sf;

    @Override
    public CityProvider cities() {
        return new JpaCityProvider(this, sf);
    }

    @Override
    public StreetProvider streets() {
        return new JpaStreetProvider(this, sf);
    }

    @Override
    public DeviceProvider devices() {
        return new JpaDeviceProvider(this, sf);
    }
}
