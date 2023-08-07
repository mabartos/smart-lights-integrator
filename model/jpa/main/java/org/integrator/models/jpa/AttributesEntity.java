package org.integrator.models.jpa;

import org.integrator.models.HasAttributes;
import org.integrator.models.jpa.entities.AttributeEntity;
import org.integrator.models.jpa.entities.HasEntityAttributes;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class AttributesEntity<U extends AttributeEntity, T extends HasEntityAttributes<U>> implements HasAttributes {

    private final T entity;

    public AttributesEntity(T entity) {
        this.entity = entity;
    }

    public Map<String, String> getAttributes() {
        return entity.getAttributes().stream().collect(Collectors.toMap(AttributeEntity::getName, AttributeEntity::getValue));
    }

    @Override
    public Optional<String> getAttribute(String name) {
        return entity.getAttributes()
                .stream()
                .filter(f -> f.getName().equals(name))
                .map(AttributeEntity::getValue)
                .findFirst();
    }

    @Override
    public void setAttribute(String name, String value) {
        //todo find attribute
    }

    @Override
    public void removeAttribute(String name) {
        entity.getAttributes().removeIf(f -> f.getName().equals(name));
    }
}
