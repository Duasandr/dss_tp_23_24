package logic.esideal;

import logic.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EsIdealFacadeTest {

    @Test
    void test() throws Exception {
        EsIdealFacade facade = new EsIdealFacade();

        Customer customer = facade.getCostumer("123456789");

        Vehicle vehicle = customer.getVehicles().iterator().next();

        Service service = facade.getService("Troca");

        Quote quote = facade.request(vehicle, service);

        facade.confirm(quote);

        Worker worker = new Worker("123456789", true);

        facade.completeNextService(worker);
    }

}