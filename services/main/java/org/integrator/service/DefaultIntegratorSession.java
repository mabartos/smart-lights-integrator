package org.integrator.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import org.hibernate.reactive.mutiny.Mutiny;
import org.integrator.IntegratorSession;
import org.integrator.models.jpa.providers.JpaDataStoreProvider;
import org.integrator.models.jpa.providers.JpaDataStoreProviderFactory;
import org.integrator.providers.DatastoreProvider;

@RequestScoped
public class DefaultIntegratorSession implements IntegratorSession {

    private DatastoreProvider datastoreProvider;

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
}
