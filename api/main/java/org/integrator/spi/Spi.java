package org.integrator.spi;

import org.integrator.providers.Provider;
import org.integrator.providers.factories.ProviderFactory;

public interface Spi {

    String getName();

    default boolean isEnabled() {
        return true;
    }

    Class<? extends Provider> getProviderClass();

    Class<? extends ProviderFactory<? extends Provider>> getProviderFactoryClass();
}
