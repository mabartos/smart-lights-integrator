package org.integrator.service;

import org.integrator.IntegratorSession;
import org.integrator.IntegratorSessionFactory;
import org.integrator.providers.Provider;
import org.integrator.providers.factories.ProviderFactory;
import org.integrator.spi.Spi;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.ServiceLoader;

import static org.integrator.providers.factories.ProviderFactory.DEFAULT_ID;

public class DefaultIntegratorSessionFactory implements IntegratorSessionFactory {
    protected volatile Map<Class<? extends Provider>, Map<String, ProviderFactory<? extends Provider>>> factories = new HashMap<>();

    @Override
    public IntegratorSession create() {
        return new DefaultIntegratorSession(this);
    }

    @Override
    public void init() {
        for (Spi spi : ServiceLoader.load(Spi.class)) {
            Map<String, ProviderFactory<? extends Provider>> foundFactories = new HashMap<>();
            for (ProviderFactory<? extends Provider> factory : ServiceLoader.load(spi.getProviderFactoryClass())) {
                foundFactories.put(factory.getId(), factory);
            }
            factories.put(spi.getProviderClass(), foundFactories);
        }
    }

    @Override
    public <T extends Provider> Optional<ProviderFactory<? extends Provider>> getProviderFactory(Class<T> providerClass) {
        return getProviderFactory(providerClass, DEFAULT_ID).or(() -> factories.get(providerClass).values().stream().findFirst());
    }

    @Override
    public <T extends Provider> Optional<ProviderFactory<? extends Provider>> getProviderFactory(Class<T> providerClass, String id) {
        final Map<String, ProviderFactory<? extends Provider>> foundFactories = Optional.ofNullable(factories.get(providerClass)).orElseGet(HashMap::new);

        return Optional.of(foundFactories).map(f -> f.get(id));
    }
}
