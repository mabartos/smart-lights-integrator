package org.integrator.models.jpa.providers;

import jakarta.enterprise.context.ApplicationScoped;
import org.hibernate.reactive.mutiny.Mutiny;
import org.integrator.IntegratorSession;
import org.integrator.providers.DatastoreProvider;
import org.integrator.providers.factories.DatastoreProviderFactory;

public class JpaDataStoreProviderFactory implements DatastoreProviderFactory {
    public final String FACTORY_ID = "jpa";

    @ApplicationScoped
    private Mutiny.SessionFactory sf;

    @Override
    public String getId() {
        return FACTORY_ID;
    }

    @Override
    public DatastoreProvider create(IntegratorSession session) {
        return new JpaDataStoreProvider(session, sf);
    }
}
