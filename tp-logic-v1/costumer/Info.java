package logic.costumer;

import java.util.Map;

public record Info<TaxNumber, Name, Email, CellPhoneNumber, VehicleIdentifier, Engine, Fuel, LicensePlate>
        (logic.person.Info<TaxNumber, Name, Email, CellPhoneNumber> personInfo,
         Map<VehicleIdentifier, logic.vehicle.Info<Engine, Fuel, LicensePlate>> vehicleInfoMap) {
}
