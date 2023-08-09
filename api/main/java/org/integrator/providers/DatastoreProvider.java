package org.integrator.providers;

public interface DatastoreProvider extends Provider {

    CityProvider cities();

    StreetProvider streets();

    DeviceProvider devices();
}
