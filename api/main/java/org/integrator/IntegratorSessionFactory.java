package org.integrator;

import org.integrator.providers.Provider;
import org.integrator.providers.factories.ProviderFactory;

import java.util.Optional;

public interface IntegratorSessionFactory {

    IntegratorSession create();

    void init();

    /**
     * Return default Provider Factory for the Provider
     * If there's no default factory, return the first found
     */
    <T extends Provider> Optional<ProviderFactory<? extends Provider>> getProviderFactory(Class<T> providerClass);

    /**
     * Return Provider Factory for Provider with factory id
     * If there's no such factory, return empty Optional
     */
    <T extends Provider> Optional<ProviderFactory<? extends Provider>> getProviderFactory(Class<T> providerClass, String id);
}
