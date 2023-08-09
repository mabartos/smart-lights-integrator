package org.integrator.providers;

import io.smallrye.mutiny.Uni;
import org.integrator.models.Coordinates;
import org.integrator.models.DeviceModel;
import org.integrator.models.StreetModel;

public interface DeviceProvider {

    default Uni<DeviceModel> createDevice(StreetModel street, String serialNo) {
        return createDevice(street, serialNo, null);
    }

    Uni<DeviceModel> createDevice(StreetModel street, String serialNo, Coordinates coordinates);

    Uni<DeviceModel> getById(String id);

    Uni<DeviceModel> getBySerialNo(String serialNo);

    Uni<Boolean> removeById(String id);

    Uni<Boolean> removeBySerialNo(String serialNo);

}
