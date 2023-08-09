package org.integrator.models;

import java.util.Map;
import java.util.Optional;

public interface HasAttributes {

    Map<String, String> getAttributes();

    Optional<String> getAttribute(String name);

    void setAttribute(String name, String value);

    void removeAttribute(String name);

}
