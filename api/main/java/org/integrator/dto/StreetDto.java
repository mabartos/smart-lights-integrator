package org.integrator.dto;

import org.integrator.models.HasId;
import org.integrator.models.StreetModel;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public record StreetDto(String id,
                        String name,
                        String cityId,
                        String parentStreetId,
                        Set<String> subStreetsIds,
                        Map<String, String> attributes) {

    public StreetDto(StreetModel model) {
        this(model.getId(),
                model.getName(),
                model.getCity().getId(),
                model.getParentStreet().map(HasId::getId).orElse(""),
                model.getSubStreets().stream().map(HasId::getId).collect(Collectors.toSet()),
                model.getAttributes());
    }
}
