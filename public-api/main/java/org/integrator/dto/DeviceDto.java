package org.integrator.dto;

import org.integrator.models.Coordinates;
import org.integrator.models.DeviceModel;
import org.integrator.models.HasId;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public record DeviceDto(String id,
                        String serialNo,
                        String deviceType,
                        String streetId,
                        boolean enabled,
                        Coordinates coordinates,
                        Set<String> neighboursIds,
                        Map<String, String> attributes) {

    public DeviceDto(DeviceModel model) {
        this(model.getId(),
                model.getSerialNo(),
                model.getDeviceType().orElse("unknown"),
                model.getStreet().getId(),
                model.isEnabled(),
                model.getCoordinates().orElse(null),
                model.getNeighbours().stream().map(HasId::getId).collect(Collectors.toSet()),
                model.getAttributes());
    }
}
