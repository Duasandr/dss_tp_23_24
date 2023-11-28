package uminho.grupo3.logic.service;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import uminho.grupo3.logic.service.interfaces.IService;
import uminho.grupo3.logic.vehicle.*;
import uminho.grupo3.logic.vehicle.interfaces.*;

import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {

    // Vehicles

    private final IVehicle petrolVehicle = new uminho.grupo3.logic.vehicle.Petrol("00-00-00");
    private final IVehicle dieselVehicle = new uminho.grupo3.logic.vehicle.Diesel("00-00-11");
    private final IVehicle electricVehicle = new uminho.grupo3.logic.vehicle.Electric("00-00-22");
    private final IVehicle petrolEV = new uminho.grupo3.logic.vehicle.PetrolEV("00-00-33");
    private final IVehicle dieselEV = new uminho.grupo3.logic.vehicle.DieselEV("00-00-44");
    private final Set<IVehicle> petrolVehicleSet = Set.of(petrolVehicle, petrolEV);
    private final Set<IVehicle> dieselVehicleSet = Set.of(dieselVehicle, dieselEV);
    private final Set<IVehicle> electricVehicleSet = Set.of(electricVehicle, petrolEV, dieselEV);
    private final Set<IVehicle> combustionVehicleSet = Set.of(petrolVehicle, dieselVehicle, petrolEV, dieselEV);
    private final Set<IVehicle> allVehicleSet = Set.of(
            petrolVehicle,
            dieselVehicle,
            electricVehicle,
            petrolEV,
            dieselEV
    );

    // Services

    private final Details mockServiceDetails = new Details(1.0f,1.0f,"mock");
    private final IService petrolService = new Petrol(mockServiceDetails);
    private final IService dieselService = new Diesel(mockServiceDetails);
    private final IService combustionService = new Combustion(mockServiceDetails);
    private final IService electricService = new Electric(mockServiceDetails);
    private final IService universalService = new Universal(mockServiceDetails);

    @Test
    public void canApplyToPetrol() {
        petrolVehicleSet.stream().map(petrolService::canApplyTo).toList().forEach(Assertions::assertTrue);
        dieselVehicleSet.stream().map(petrolService::canApplyTo).toList().forEach(Assertions::assertFalse);
        assertFalse(petrolService.canApplyTo(electricVehicle));
    }

    @Test
    public void canApplyToDiesel() {
        dieselVehicleSet.stream().map(dieselService::canApplyTo).toList().forEach(Assertions::assertTrue);
        petrolVehicleSet.stream().map(dieselService::canApplyTo).toList().forEach(Assertions::assertFalse);
        assertFalse(petrolService.canApplyTo(electricVehicle));
    }

    @Test
    public void canApplyToElectric() {
        electricVehicleSet.forEach(v -> assertTrue(electricService.canApplyTo(v), "Vehicle: " + v));
        assertFalse(electricService.canApplyTo(petrolVehicle));
        assertFalse(electricService.canApplyTo(dieselVehicle));
    }

    @Test
    public void canApplyToCombustion() {
        combustionVehicleSet.forEach(v -> assertTrue(combustionService.canApplyTo(v), "Vehicle: " + v));
        assertFalse(combustionService.canApplyTo(electricVehicle));
    }

    @Test
    public void canApplyToUniversal() {
        allVehicleSet.forEach(v -> assertTrue(universalService.canApplyTo(v), "Vehicle: " + v));
    }

}