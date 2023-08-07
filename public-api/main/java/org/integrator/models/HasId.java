package org.integrator.models;

import io.smallrye.mutiny.Uni;

public interface HasId {

    Uni<String> getId();

    void setId(String id);
}
