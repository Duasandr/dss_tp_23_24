package logic.esideal;


import logic.Service;
import logic.WorkStation;
import logic.Worker;
import logic.workstation.CapacityComparator;

import java.time.LocalDateTime;
import java.util.PriorityQueue;
import java.util.Queue;

public class StationManager {
    private final data.dao.Service serviceDAO;
    private final data.dao.WorkStation workStationDAO;

    public StationManager() {
        serviceDAO = data.dao.Service.getInstance();
        workStationDAO = data.dao.WorkStation.getInstance();
    }

    public logic.Service get(String serviceId) throws Exception {
        return serviceDAO.getService(serviceId);
    }

    public LocalDateTime getEstimatedCompletionDate(logic.Service service) throws Exception {
        Queue<WorkStation> workStations = workStationDAO.getWorkStations(service);
        WorkStation workStation = workStations.peek();

        if(workStation != null) {
            return workStation.getEstimatedCompletionDate();
        }

        return null;
    }

    public Queue<WorkStation> getWorkStations(Service service) {
        try {
            return workStationDAO.getWorkStations(service);
        } catch (Exception e) {
            return new PriorityQueue<>(new CapacityComparator());
        }
    }

    public WorkStation  getAssignedWorkstation(Worker worker) {
        return workStationDAO.getAssignedWorkstation(worker);
    }
}
