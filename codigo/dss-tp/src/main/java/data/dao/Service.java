package data.dao;

import data.DAO;
import persistance.Database;

import java.sql.ResultSet;

public class Service extends DAO {
    private static Service instance;

    private Service() {
        this(Database.getInstance());
    }

    public Service(Database database) {
        super(database, database.getTable("Service"));
    }

    public static Service getInstance() {
        if(instance == null) {
            instance = new Service();
        }
        return instance;
    }

    public logic.Service getService(String name) throws Exception {
        ResultSet resultSet = this.getById(name);
        if(resultSet.next()) {
            return logic.Service.create(
                    resultSet.getString("name"),
                    resultSet.getString("description"),
                    resultSet.getFloat("price"),
                    resultSet.getFloat("duration"),
                    resultSet.getString("type")
            );
        }
        return null;
    }

}
