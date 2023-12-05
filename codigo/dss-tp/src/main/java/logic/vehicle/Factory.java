package logic.vehicle;

import logic.Vehicle;

import java.util.Map;
import java.util.function.Supplier;

public class Factory {
    private static final Map<String, Supplier<Vehicle>> suppliers = Map.of(
            Petrol.class.getSimpleName(), Petrol::new,
            Diesel.class.getSimpleName(), Diesel::new,
            Electric.class.getSimpleName(), Electric::new,
            PetrolEV.class.getSimpleName(), PetrolEV::new,
            DieselEV.class.getSimpleName(), DieselEV::new
    );

    public static Vehicle create(String type, String licensePlate) {
        Supplier<Vehicle> supplier = suppliers.get(type);
        if (supplier == null) {
            throw new IllegalArgumentException("Invalid vehicle type: " + type);
        }

        Vehicle vehicle = supplier.get();
        vehicle.setLicensePlate(licensePlate);

        return vehicle;
    }
}
