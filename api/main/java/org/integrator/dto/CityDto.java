package org.integrator.dto;

import org.integrator.models.CityModel;
import org.integrator.models.HasId;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public record CityDto(String id,
                      String name,
                      String parentDistrictId,
                      Set<String> childrenDistrictsIds,
                      Map<String, String> attributes) {

    public CityDto(CityModel model) {
        this(model.getId(),
                model.getName(),
                model.getParentDistrict().map(HasId::getId).orElse(""),
                model.getChildrenDistricts().stream().map(HasId::getId).collect(Collectors.toSet()),
                model.getAttributes());
    }
}
