package org.integrator.providers;

public interface DatastoreProvider {

    CityProvider cities();

    StreetProvider streets();

    DeviceProvider devices();
}
