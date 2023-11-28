package logic.costumer;

public class Costumer<TaxNumber, Name, Email, CellPhoneNumber, VehicleIdentifier, Engine, Fuel, LicensePlate>
        implements ICostumer<TaxNumber, Name, Email, CellPhoneNumber, VehicleIdentifier, Engine, Fuel, LicensePlate> {
    private final Info<TaxNumber, Name, Email, CellPhoneNumber, VehicleIdentifier, Engine, Fuel, LicensePlate> costumerInfo;

    public Costumer(Info<TaxNumber, Name, Email, CellPhoneNumber, VehicleIdentifier, Engine, Fuel, LicensePlate> costumerInfo) {
        this.costumerInfo = costumerInfo;
    }


    @Override
    public TaxNumber getTaxNumber() {
        return costumerInfo.personInfo().taxNumber();
    }

    @Override
    public Name getName() {
        return costumerInfo.personInfo().name();
    }

    @Override
    public Email getEmail() {
        return costumerInfo.personInfo().email();
    }

    @Override
    public CellPhoneNumber getCellPhoneNumber() {
        return costumerInfo.personInfo().cellPhoneNumber();
    }

    @Override
    public Engine getEngine(VehicleIdentifier vehicleIdentifier) {
        return costumerInfo.vehicleInfoMap().get(vehicleIdentifier).engine();
    }

    @Override
    public Fuel getFuel(VehicleIdentifier vehicleIdentifier) {
        return costumerInfo.vehicleInfoMap().get(vehicleIdentifier).fuel();
    }

    @Override
    public LicensePlate getLicensePlate(VehicleIdentifier vehicleIdentifier) {
        return costumerInfo.vehicleInfoMap().get(vehicleIdentifier).licensePlate();
    }

    @Override
    public String toString() {
        return "Costumer{" +
                "costumerInfo=" + costumerInfo +
                '}';
    }
}
