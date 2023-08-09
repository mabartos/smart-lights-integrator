package org.integrator;

import org.integrator.providers.Provider;
import org.integrator.providers.factories.ProviderFactory;

import java.util.Optional;

public interface IntegratorSessionFactory {

    IntegratorSession create();

    void init();

    <T extends Provider> Optional<ProviderFactory<T>> getProviderFactory(Class<T> providerClass);

    <T extends Provider> Optional<ProviderFactory<T>> getProviderFactory(Class<T> providerClass, String id);
}
