package data.dao;

import data.DAO;
import logic.Customer;
import persistance.Database;

import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

public class Vehicle extends DAO {
    private static Vehicle instance = null;

    private Vehicle(Database database) {
        super(database, database.getTable("Vehicle"));
    }

    private Vehicle() {
        this(Database.getInstance());
    }

    public static Vehicle getInstance() {
        if(instance == null) {
            instance = new Vehicle();
        }
        return instance;
    }

    public logic.Vehicle getVehicle(String licensePlate) throws Exception {
        ResultSet rs = this.getById(licensePlate);
        if(!rs.next()) {
            throw new Exception("Vehicle not found");
        }

        return logic.vehicle.Factory.create(
                rs.getString("type"),
                rs.getString("licensePlate")
        );
    }

    public Set<logic.Vehicle> getVehicles(Customer customer) throws Exception {
        ResultSet rs = this.getByColumn("owner", customer.getTaxNumber());
        Set<logic.Vehicle> vehicles = new HashSet<>();

        while(rs.next()) {
            vehicles.add(logic.vehicle.Factory.create(
                    rs.getString("type"),
                    rs.getString("licensePlate")
            ));
        }

        return vehicles;
    }

}
