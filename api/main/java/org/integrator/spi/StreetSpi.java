package org.integrator.spi;

import org.integrator.providers.Provider;
import org.integrator.providers.StreetProvider;
import org.integrator.providers.factories.ProviderFactory;
import org.integrator.providers.factories.StreetProviderFactory;

public class StreetSpi implements Spi {
    @Override
    public String getName() {
        return "street";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return StreetProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory<? extends Provider>> getProviderFactoryClass() {
        return StreetProviderFactory.class;
    }
}
