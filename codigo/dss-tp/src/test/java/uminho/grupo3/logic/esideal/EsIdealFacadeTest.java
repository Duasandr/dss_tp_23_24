package uminho.grupo3.logic.esideal;

import org.junit.Test;
import uminho.grupo3.*;
import uminho.grupo3.logic.costumer.Costumer;
import uminho.grupo3.logic.costumer.interfaces.ICostumer;
import uminho.grupo3.logic.esideal.interfaces.IEsIdeal;
import uminho.grupo3.logic.person.Details;
import uminho.grupo3.logic.service.interfaces.IService;
import uminho.grupo3.logic.vehicle.interfaces.IVehicle;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class EsIdealFacadeTest {
    public IVehicle mockPetrolVehicle = new uminho.grupo3.logic.vehicle.Petrol("00-00-00");
    public uminho.grupo3.logic.person.Details mockCostumerDetails =
            new uminho.grupo3.logic.person.Details("testCostumer", "1010","address","test@email.com","1234");
    public ICostumer mockCostumer = new Costumer(mockCostumerDetails, Set.of( mockPetrolVehicle ) );
    public uminho.grupo3.logic.service.Details mockServiceDetails =
            new uminho.grupo3.logic.service.Details(1.0f,1.0f,"mockService");
    public IService mockPetrolService = new uminho.grupo3.logic.service.Petrol(mockServiceDetails);

    public Map<String, ICostumer> mockCostumerMap = Map.of(
            mockCostumer.getTaxNumber(),
            mockCostumer
    );

    public IEsIdeal esIdeal = new EsIdealFacade(mockCostumerMap,null,null);

    @Test
    public void requestValidService() {
        System.out.println(esIdeal.getCostumer(mockCostumerDetails.taxNumber()));
        System.out.println(esIdeal.request(mockPetrolService, mockPetrolVehicle, mockCostumer));
    }

}