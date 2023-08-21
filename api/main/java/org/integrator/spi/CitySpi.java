package org.integrator.spi;

import org.integrator.providers.CityProvider;
import org.integrator.providers.Provider;
import org.integrator.providers.factories.CityProviderFactory;
import org.integrator.providers.factories.ProviderFactory;

public class CitySpi implements Spi {
    @Override
    public String getName() {
        return "city";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return CityProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory<? extends Provider>> getProviderFactoryClass() {
        return CityProviderFactory.class;
    }
}
