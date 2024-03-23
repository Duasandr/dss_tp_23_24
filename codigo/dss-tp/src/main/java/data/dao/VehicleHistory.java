package data.dao;

import data.DAO;
import logic.Vehicle;
import logic.vehicle.HistoryEntry;
import persistance.Database;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class VehicleHistory extends DAO {
    private static VehicleHistory instance;

    private VehicleHistory() {
        this(Database.getInstance());
    }

    public VehicleHistory(Database database) {
        super(database, database.getTable("VehicleHistory"));
    }

    public static VehicleHistory getInstance() {
        if(instance == null) {
            instance = new VehicleHistory();
        }
        return instance;
    }

    public void addToHistory(logic.Vehicle vehicle, logic.Service service, String status) throws Exception {
        this.add(
                vehicle.getLicensePlate(),
                service.getName(),
                new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()),
                status
        );
    }

    public Set<HistoryEntry> getHistory(Vehicle vehicle) throws Exception {
        Set<HistoryEntry> records = new HashSet<>();

        ResultSet resultSet = this.getByColumn("vehicleId", vehicle.getLicensePlate());
        while(resultSet.next()) {
            records.add(new HistoryEntry(
                    resultSet.getString("serviceId"),
                    resultSet.getString("timeStamp"),
                    resultSet.getString("status")
            ));
        }

        return records;
    }
}
