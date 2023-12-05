package logic;


import java.time.LocalDateTime;

public class WorkStation {
    private final String id;
    private final Service providedService;
    private final data.dao.VehicleQueue vehicleQueueDAO;
    private final data.dao.Vehicle vehicleDAO;

    public WorkStation(String id, Service providedService) {
        this.id = id;
        this.providedService = providedService;
        this.vehicleQueueDAO = data.dao.VehicleQueue.getInstance();
        this.vehicleDAO = data.dao.Vehicle.getInstance();
    }

    public String getId() {
        return id;
    }

    public void enqueue(Vehicle vehicle) throws Exception {
        vehicleQueueDAO.enqueue(this, vehicle);
    }

    public Vehicle dequeue() throws Exception {
        String vehicleId = vehicleQueueDAO.dequeue(this);
        Vehicle vehicle = vehicleDAO.getVehicle(vehicleId);
        vehicle.addToServiceHistory(providedService, "Completed");
        return vehicle;
    }

    public int size() {
        try {
            return vehicleQueueDAO.size(this);
        } catch (Exception e) {
            return 0;
        }
    }

    public Service getProvidedService() {
        return providedService;
    }

    public LocalDateTime getEstimatedCompletionDate() throws Exception {
        int size = this.size();
        float duration = providedService.getDuration();
        LocalDateTime now = LocalDateTime.now();
        return now.plusHours((long) (duration * size));
    }
}