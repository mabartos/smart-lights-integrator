package org.integrator.spi;

import org.integrator.providers.DatastoreProvider;
import org.integrator.providers.Provider;
import org.integrator.providers.factories.DatastoreProviderFactory;
import org.integrator.providers.factories.ProviderFactory;

public class DatastoreSpi implements Spi {

    @Override
    public String getName() {
        return "datastore";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return DatastoreProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory<? extends Provider>> getProviderFactoryClass() {
        return DatastoreProviderFactory.class;
    }
}
