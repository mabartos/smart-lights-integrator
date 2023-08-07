package org.integrator.models;

import java.util.Map;

public interface HasAttributes {

    Map<String, String> getAttributes();

    void getAttribute(String name);

    void setAttribute(String name, String value);

    void removeAttribute(String name);

}
