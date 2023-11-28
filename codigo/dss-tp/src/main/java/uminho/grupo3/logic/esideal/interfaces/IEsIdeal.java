package uminho.grupo3.logic.esideal.interfaces;

import uminho.grupo3.logic.costumer.interfaces.ICostumer;
import uminho.grupo3.logic.service.interfaces.IService;
import uminho.grupo3.logic.vehicle.interfaces.IVehicle;

public interface IEsIdeal {
    boolean request(IService service, IVehicle vehicle, ICostumer costumer);
    ICostumer getCostumer(String costumerId);
    IService getService(String serviceId);
}
