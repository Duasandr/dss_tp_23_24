package logic.costumer;

public interface ICostumer<TaxNumber, Name, Email, CellPhoneNumber, VehicleIdentifier, Engine, Fuel, LicensePlate> {
    TaxNumber getTaxNumber();
    Name getName();
    Email getEmail();
    CellPhoneNumber getCellPhoneNumber();
    Engine getEngine(VehicleIdentifier vehicleIdentifier);

    Fuel getFuel(VehicleIdentifier vehicleIdentifier);
    LicensePlate getLicensePlate(VehicleIdentifier vehicleIdentifier);

}
