package org.integrator.models.jpa.providers;

import org.hibernate.reactive.mutiny.Mutiny;
import org.integrator.IntegratorSession;
import org.integrator.providers.CityProvider;
import org.integrator.providers.DatastoreProvider;
import org.integrator.providers.DeviceProvider;
import org.integrator.providers.StreetProvider;

public class JpaDataStoreProvider implements DatastoreProvider {

    private final IntegratorSession session;
    private final Mutiny.SessionFactory sf;

    private CityProvider cityProvider;
    private StreetProvider streetProvider;
    private DeviceProvider deviceProvider;
    
    public JpaDataStoreProvider(IntegratorSession session, Mutiny.SessionFactory sf) {
        this.session = session;
        this.sf = sf;
    }

    @Override
    public CityProvider cities() {
        if (cityProvider == null) {
            cityProvider = new JpaCityProvider(session, sf);
        }
        return cityProvider;
    }

    @Override
    public StreetProvider streets() {
        if (streetProvider == null) {
            streetProvider = new JpaStreetProvider(session, sf);
        }
        return streetProvider;
    }

    @Override
    public DeviceProvider devices() {
        if (deviceProvider == null) {
            deviceProvider = new JpaDeviceProvider(session, sf);
        }
        return deviceProvider;
    }
}
