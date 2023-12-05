package data.dao;

import data.DAO;
import logic.Worker;
import persistance.Database;

import java.sql.ResultSet;
import java.util.*;
import java.util.stream.Collectors;

public class WorkStation extends DAO {
    private static WorkStation instance = null;

    private WorkStation(Database database) {
        super(database, database.getTable("WorkStation"));
    }

    public static WorkStation getInstance() {
        if(instance == null) {
            instance = new WorkStation(Database.getInstance());
        }
        return instance;
    }

    public Queue<logic.WorkStation> getWorkStations(logic.Service service) throws Exception {
        ResultSet rs = this.getByColumn("providedService", service.getName());
        Queue<logic.WorkStation> workStations = new PriorityQueue<>(new logic.workstation.CapacityComparator());

        while(rs.next()) {
            workStations.add(new logic.WorkStation(
                    rs.getString("id"),
                    service
            ));
        }

        return workStations;
    }

    public logic.WorkStation getAssignedWorkstation(Worker worker) {
        try {
            ResultSet rs = this.getByColumn("assignedWorker", worker.getId());
            if(rs.next()) {
                return new logic.WorkStation(
                        rs.getString("id"),
                        data.dao.Service.getInstance().getService(rs.getString("providedService"))
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
