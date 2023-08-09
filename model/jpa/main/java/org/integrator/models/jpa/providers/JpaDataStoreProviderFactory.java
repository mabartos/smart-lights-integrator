package org.integrator.models.jpa.providers;

import io.quarkus.arc.Arc;
import org.hibernate.reactive.mutiny.Mutiny;
import org.integrator.IntegratorSession;
import org.integrator.providers.DatastoreProvider;
import org.integrator.providers.factories.DatastoreProviderFactory;

public class JpaDataStoreProviderFactory implements DatastoreProviderFactory {
    public final String FACTORY_ID = "jpa";

    @Override
    public String getId() {
        return FACTORY_ID;
    }

    @Override
    public DatastoreProvider create(IntegratorSession session) {
        return new JpaDataStoreProvider(session, Arc.container().instance(Mutiny.SessionFactory.class).get());
    }
}
