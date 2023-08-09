package org.integrator.providers.factories;

import org.integrator.IntegratorSession;

public interface ProviderFactory<T> {

    String DEFAULT_ID = "default";

    String getId();

    T create(IntegratorSession session);

    default void init() {
        //NOP
    }

    default boolean isSupported() {
        return true;
    }
}
