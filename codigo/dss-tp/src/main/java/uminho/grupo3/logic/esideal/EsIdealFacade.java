package uminho.grupo3.logic.esideal;

import uminho.grupo3.logic.costumer.Costumer;
import uminho.grupo3.logic.costumer.interfaces.ICostumer;
import uminho.grupo3.logic.esideal.interfaces.IEsIdeal;
import uminho.grupo3.logic.service.Service;
import uminho.grupo3.logic.service.interfaces.IService;
import uminho.grupo3.logic.vehicle.interfaces.IVehicle;
import uminho.grupo3.logic.worker.Worker;
import uminho.grupo3.logic.workstation.WorkStation;
import uminho.grupo3.logic.workstation.interfaces.IWorkStation;

import java.util.HashMap;
import java.util.Map;

public class EsIdealFacade implements IEsIdeal {
    public Map<String, ICostumer> costumerMap;
    public Map<String, IWorkStation> workStationMap;
    public Map<String, IService> serviceMap;


    EsIdealFacade(Map<String, ICostumer> costumerMap, Map<String, WorkStation> workStationMap, Map<String, IService> serviceMap) {
        this.costumerMap = new HashMap<>(costumerMap);
        this.workStationMap = new HashMap<>();
        this.serviceMap = new HashMap<>();
    }

    @Override
    public boolean request(IService service, IVehicle vehicle, ICostumer costumer) {
        if(service.canApplyTo(vehicle)) {
            return true;
        }
        throw new IllegalArgumentException("Can not apply service to vehicle.");
    }

    @Override
    public ICostumer getCostumer(String costumerId) {
        return costumerMap.get(costumerId);
    }

    @Override
    public IService getService(String serviceId) {
        return serviceMap.get(serviceId);
    }
}
