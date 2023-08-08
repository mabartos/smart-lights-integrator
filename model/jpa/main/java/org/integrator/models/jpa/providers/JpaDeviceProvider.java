package org.integrator.models.jpa.providers;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import io.smallrye.mutiny.Uni;
import org.hibernate.reactive.mutiny.Mutiny;
import org.integrator.IntegratorSession;
import org.integrator.models.Coordinates;
import org.integrator.models.DeviceModel;
import org.integrator.models.StreetModel;
import org.integrator.models.jpa.DeviceAdapter;
import org.integrator.models.jpa.entities.DeviceEntity;
import org.integrator.models.jpa.entities.StreetEntity;
import org.integrator.providers.DeviceProvider;

import java.util.List;
import java.util.stream.Collectors;

public class JpaDeviceProvider implements DeviceProvider {

    private final IntegratorSession session;
    private final Mutiny.SessionFactory sf;

    public JpaDeviceProvider(IntegratorSession session, Mutiny.SessionFactory sf) {
        this.session = session;
        this.sf = sf;
    }

    private Uni<DeviceModel> cast(Uni<? extends PanacheEntityBase> entity) {
        return entity.onItem().castTo(DeviceEntity.class).map(f -> new DeviceAdapter(session, f, sf));
    }

    private Uni<List<DeviceModel>> castList(Uni<List<PanacheEntityBase>> list) {
        return list.map(f -> f.stream()
                .map(dev -> (DeviceEntity) f)
                .map(devEntity -> new DeviceAdapter(session, devEntity, sf))
                .collect(Collectors.toList()));
    }

    @Override
    public Uni<DeviceModel> createDevice(StreetModel street, String serialNo, Coordinates coordinates) {
        return cast(sf.withTransaction(s -> StreetEntity.findById(street.getId())
                .onItem()
                .castTo(StreetEntity.class)
                .invoke(streetEntity -> {
                    DeviceEntity device = new DeviceEntity();
                    device.setSerialNo(serialNo);
                    device.setEnabled(true);
                    if (coordinates != null) {
                        device.setCoordinates(coordinates);
                    }
                    device.setStreet(streetEntity);
                })));
    }

    @Override
    public Uni<DeviceModel> getById(String id) {
        return cast(DeviceEntity.findById(id));
    }

    @Override
    public Uni<DeviceModel> getBySerialNo(String serialNo) {
        return cast(DeviceEntity.find("serialNo", serialNo).singleResult());
    }

    @Override
    public Uni<Boolean> removeById(String id) {
        return DeviceEntity.deleteById(id);
    }

    @Override
    public Uni<Boolean> removeBySerialNo(String serialNo) {
        return DeviceEntity.delete("serialNo", serialNo).onItem().transform(f -> f > 0);
    }
}
