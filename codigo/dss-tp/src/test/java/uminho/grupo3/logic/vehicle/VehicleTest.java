package uminho.grupo3.logic.vehicle;

import org.junit.Test;
import uminho.grupo3.logic.vehicle.interfaces.IVehicle;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    @Test
    public void constructorTest() {
        IVehicle vehicle = new Electric("");
    }
}