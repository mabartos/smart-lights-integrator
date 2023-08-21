package org.integrator.service;

import org.integrator.IntegratorSession;
import org.integrator.IntegratorSessionFactory;
import org.integrator.providers.DatastoreProvider;
import org.integrator.providers.Provider;
import org.integrator.providers.factories.ProviderFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DefaultIntegratorSession implements IntegratorSession {

    private final IntegratorSessionFactory factory;
    private final Map<Integer, Provider> providers = new HashMap<>();

    private DatastoreProvider datastoreProvider;

    public DefaultIntegratorSession(IntegratorSessionFactory factory) {
        this.factory = factory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Provider> T getProvider(Class<T> clazz, String id) {
        int hashCode = clazz.hashCode() + id.hashCode();
        Provider provider = providers.get(hashCode);

        if (provider == null) {
            Optional<ProviderFactory<? extends Provider>> foundFactory = factory.getProviderFactory(clazz, id);
            if (foundFactory.isPresent()) {
                provider = foundFactory.get().create(this);
                providers.put(hashCode, provider);
            }
        }

        return (T) provider;
    }

    @Override
    public void shutdown() {
        //nop
    }

    @Override
    public DatastoreProvider datastore() {
        if (datastoreProvider == null) {
            datastoreProvider = getProvider(DatastoreProvider.class);
        }
        return datastoreProvider;
    }

    @Override
    public IntegratorSessionFactory getIntegratorFactory() {
        return factory;
    }
}
