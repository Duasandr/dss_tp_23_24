package persistance;

import java.util.Map;

public class TestSchema extends Schema {
    public TestSchema() {
        this.setName("EsIdealTest");
        this.addTable(getCustomer());
        this.addTable(getVehicle());
        this.addTable(getWorker());
        this.addTable(getService());
        this.addTable(getVehicleHistory());
        this.addTable(getWorkStation());
        this.addTable(getVehicleQueue());
    }

    public static Table getService() {
        Table service = new Table();

        service.setName("Service");
        service.addColumn("id VARCHAR(255) PRIMARY KEY");
        service.addColumn("name VARCHAR(255) NOT NULL");
        service.addColumn("description VARCHAR(255) NOT NULL");
        service.addColumn("price DECIMAL(10, 2) NOT NULL");
        service.addColumn("duration DECIMAL(10, 2) NOT NULL");
        service.addColumn("type VARCHAR(255) NOT NULL");

        return service;
    }

    private static Table getVehicle() {
        Table vehicle = new Table();

        vehicle.setName("Vehicle");
        vehicle.addColumn("id VARCHAR(255) PRIMARY KEY");
        vehicle.addColumn("licensePlate VARCHAR(10)");
        vehicle.addColumn("type VARCHAR(50) NOT NULL");
        vehicle.addColumn("owner VARCHAR(255) NOT NULL REFERENCES Customer(id)");

        return vehicle;
    }

    private static Table getCustomer() {
        Table customer = new Table();

        customer.setName("Customer");
        customer.addColumn("id VARCHAR(255) PRIMARY KEY");
        customer.addColumn("taxNumber VARCHAR(10)");
        customer.addColumn("name VARCHAR(255) NOT NULL");
        customer.addColumn("address VARCHAR(255) NOT NULL");
        customer.addColumn("phone VARCHAR(255) NOT NULL");
        customer.addColumn("email VARCHAR(255) NOT NULL");

        return customer;
    }

    private static Table getWorker() {
        Table worker = new Table();

        worker.setName("Worker");
        worker.addColumn("id VARCHAR(255) PRIMARY KEY");
        worker.addColumn("clockedIn BOOLEAN NOT NULL");

        return worker;
    }

    public static Table getVehicleHistory() {
        Table vehicleHistory = new Table();

        vehicleHistory.setName("VehicleHistory");
        vehicleHistory.addColumn("vehicleId VARCHAR(255) NOT NULL REFERENCES Vehicle(id)");
        vehicleHistory.addColumn("serviceId VARCHAR(255) NOT NULL REFERENCES Service(id)");
        vehicleHistory.addColumn("timeStamp DATETIME NOT NULL");
        vehicleHistory.addColumn("status VARCHAR(255) NOT NULL");

        return vehicleHistory;
    }

    public static Table getWorkStation() {
        Table workStation = new Table();

        workStation.setName("WorkStation");
        workStation.addColumn("id VARCHAR(255) PRIMARY KEY");
        workStation.addColumn("assignedWorker VARCHAR(255) REFERENCES Worker(id)");
        workStation.addColumn("providedService VARCHAR(255) NOT NULL REFERENCES Service(id)");


        return workStation;
    }

    public static Table getVehicleQueue() {
        Table vehicleQueue = new Table();

        vehicleQueue.setName("VehicleQueue");
        vehicleQueue.addColumn("vehicleId VARCHAR(255) NOT NULL REFERENCES Vehicle(id)");
        vehicleQueue.addColumn("workstationId VARCHAR(255) NOT NULL REFERENCES WorkStation(id)");
        vehicleQueue.addColumn("timeStamp DATETIME NOT NULL");

        return vehicleQueue;
    }
}
