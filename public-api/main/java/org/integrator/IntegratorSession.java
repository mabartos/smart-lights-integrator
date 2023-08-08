package org.integrator;

import org.integrator.providers.CityProvider;
import org.integrator.providers.DatastoreProvider;
import org.integrator.providers.DeviceProvider;
import org.integrator.providers.StreetProvider;

public interface IntegratorSession {

    DatastoreProvider datastore();

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
