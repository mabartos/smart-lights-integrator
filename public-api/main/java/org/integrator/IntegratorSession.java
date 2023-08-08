package org.integrator;

import org.integrator.providers.CityProvider;
import org.integrator.providers.DeviceProvider;
import org.integrator.providers.StreetProvider;

public interface IntegratorSession {

    CityProvider cities();

    StreetProvider streets();

    DeviceProvider devices();

}
