package logic.esideal;

import logic.*;
import logic.esideal.interfaces.IEsIdeal;

import java.time.LocalDateTime;
import java.util.Queue;
import java.util.Set;

public class EsIdealFacade implements IEsIdeal {
    private final CustomerManager customerManager;
    private final StationManager stationManager;

    public EsIdealFacade() {
        customerManager = new CustomerManager();
        stationManager = new StationManager();
    }

    @Override
    public Quote request(Vehicle vehicle, Service service) {
        if(!service.canApplyTo(vehicle)) {
            throw new IllegalArgumentException("Service cannot be applied to vehicle");
        }


        LocalDateTime estimatedCompletionDate;
        try {
            vehicle.addToServiceHistory(service, "Requested");
            estimatedCompletionDate = stationManager.getEstimatedCompletionDate(service);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return new Quote(vehicle, service, estimatedCompletionDate);
    }

    @Override
    public void confirm(Quote quote) {
        Vehicle vehicle = quote.getVehicle();
        Service service = quote.getService();

        try {
            Queue<WorkStation> workStations = stationManager.getWorkStations(service);
            WorkStation workStation = workStations.peek();

            if(workStation != null) {
                workStation.enqueue(vehicle);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void completeNextService(Worker worker) {
        try {
            WorkStation workStation = stationManager.getAssignedWorkstation(worker);

            if(workStation != null) {
                workStation.dequeue();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer getCostumer(String costumerId) throws Exception {
        return customerManager.get(costumerId);
    }

    @Override
    public Service getService(String serviceId) throws Exception {
        return stationManager.get(serviceId);
    }

    @Override
    public Set<Service> getServices(Customer customer) {
        return null;
    }

}
