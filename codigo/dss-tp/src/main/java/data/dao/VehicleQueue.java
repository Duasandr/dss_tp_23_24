package data.dao;

import data.DAO;
import logic.WorkStation;
import persistance.Database;

import java.sql.ResultSet;
import java.util.Calendar;

public class VehicleQueue extends DAO {
    private static VehicleQueue instance = null;

    private VehicleQueue(Database database) {
        super(database, database.getTable("VehicleQueue"));
    }

    public static VehicleQueue getInstance() {
        if(instance == null) {
            instance = new VehicleQueue(Database.getInstance());
        }
        return instance;
    }

    public void enqueue(logic.WorkStation workStation, logic.Vehicle vehicle) throws Exception {
        this.add(
                vehicle.getLicensePlate(),
                workStation.getId(),
                new java.sql.Timestamp(Calendar.getInstance().getTime().getTime())
        );
    }

    public String dequeue(logic.WorkStation workStation) throws Exception {
        String sql = "SELECT * FROM VehicleQueue WHERE workstationId = '"+ workStation.getId() + "' ORDER BY timeStamp ASC LIMIT 1";
        try (ResultSet rs = this.executeQuery(sql)){
            rs.next();
            String licensePlate = rs.getString("vehicleId");
            this.deleteByColumn("vehicleId", licensePlate);
            return licensePlate;
        } catch (Exception e) {
            throw new Exception("No vehicles in queue");
        }
    }

    public int size(logic.WorkStation workStation) throws Exception {
        try (ResultSet rs = this.countByColumn("workstationId", workStation.getId()))
        {
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }


}
