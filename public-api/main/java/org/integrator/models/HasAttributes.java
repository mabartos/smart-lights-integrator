package org.integrator.models;

import io.smallrye.mutiny.Uni;

import java.util.Map;

public interface HasAttributes {

    Uni<Map<String, String>> getAttributes();

    Uni<String> getAttribute(String name);

    void setAttribute(String name, String value);

    void removeAttribute(String name);

}
