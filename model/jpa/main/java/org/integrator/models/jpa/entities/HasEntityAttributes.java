package org.integrator.models.jpa.entities;

import java.util.Set;

public interface HasEntityAttributes<T extends AttributeEntity> {

    Set<T> getAttributes();

}
