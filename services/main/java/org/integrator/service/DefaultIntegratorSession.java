package org.integrator.service;


import jakarta.enterprise.context.ApplicationScoped;
import org.hibernate.reactive.mutiny.Mutiny;
import org.integrator.IntegratorSession;
import org.integrator.IntegratorSessionFactory;
import org.integrator.models.jpa.providers.JpaDataStoreProvider;
import org.integrator.models.jpa.providers.JpaDataStoreProviderFactory;
import org.integrator.providers.DatastoreProvider;

public class DefaultIntegratorSession implements IntegratorSession {

    private final IntegratorSessionFactory factory;
    private DatastoreProvider datastoreProvider;

    public DefaultIntegratorSession(IntegratorSessionFactory factory) {
        this.factory = factory;
    }

    @ApplicationScoped
    private Mutiny.SessionFactory sf;

    @Override
    public DatastoreProvider datastore() {
        if (datastoreProvider == null) {
            datastoreProvider = new JpaDataStoreProviderFactory().create(this);
            new JpaDataStoreProvider(this, sf);
        }
        return datastoreProvider;
    }

    @Override
    public IntegratorSessionFactory getIntegratorFactory() {
        return factory;
    }
}
