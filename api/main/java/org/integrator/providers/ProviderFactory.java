package org.integrator.providers;

import org.integrator.IntegratorSession;

public interface ProviderFactory<T> {

    T create(IntegratorSession session);
}
