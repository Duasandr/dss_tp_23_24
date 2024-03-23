package data.dao;

import data.DAO;
import persistance.Database;

public class Worker extends DAO {
    private static Worker instance = null;

    private Worker(Database database) {
        super(database, database.getTable("Worker"));
    }

    public static Worker getInstance() {
        if(instance == null) {
            instance = new Worker(Database.getInstance());
        }
        return instance;
    }

    public logic.Worker getWorker(String id) throws Exception {
        java.sql.ResultSet rs = this.getById(id);
        if(!rs.next()) {
            throw new Exception("Worker not found");
        }

        return new logic.Worker(
                rs.getString("id"),
                rs.getBoolean("clockedIn")
        );
    }

}
