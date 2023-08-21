package org.integrator.spi;

import org.integrator.providers.DeviceProvider;
import org.integrator.providers.Provider;
import org.integrator.providers.factories.DeviceProviderFactory;
import org.integrator.providers.factories.ProviderFactory;

public class DeviceSpi implements Spi {
    @Override
    public String getName() {
        return "device";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return DeviceProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory<? extends Provider>> getProviderFactoryClass() {
        return DeviceProviderFactory.class;
    }
}
