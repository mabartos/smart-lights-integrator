package org.integrator;

import org.integrator.providers.CityProvider;
import org.integrator.providers.DatastoreProvider;
import org.integrator.providers.DeviceProvider;
import org.integrator.providers.Provider;
import org.integrator.providers.StreetProvider;

import java.util.Optional;

import static org.integrator.providers.factories.ProviderFactory.DEFAULT_ID;

public interface IntegratorSession {

    default <T extends Provider> T getProvider(Class<T> clazz) {
        return getProvider(clazz, DEFAULT_ID);
    }

    <T extends Provider> T getProvider(Class<T> clazz, String id);

    void shutdown();

    DatastoreProvider datastore();

    IntegratorSessionFactory getIntegratorFactory();

    default CityProvider cities() {
        return datastore().cities();
    }

    default StreetProvider streets() {
        return datastore().streets();
    }

    default DeviceProvider devices() {
        return datastore().devices();
    }

}
