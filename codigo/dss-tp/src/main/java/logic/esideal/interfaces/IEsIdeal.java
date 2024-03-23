package logic.esideal.interfaces;

import logic.*;

import java.util.Set;

public interface IEsIdeal {

    Quote request(Vehicle vehicle, Service service);
    void confirm(Quote quote);
    void completeNextService(Worker worker);

    Customer getCostumer(String costumerId) throws Exception;
    Service getService(String serviceId) throws Exception;

    Set<Service> getServices(Customer customer);
}
