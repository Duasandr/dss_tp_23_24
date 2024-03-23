package data.dao;

import data.DAO;
import persistance.Database;

import java.sql.ResultSet;

public class Customer extends DAO {
    private static Customer instance = null;

    private Customer(Database database) {
        super(database, database.getTable("Customer"));
    }

    private Customer() {
        this(Database.getInstance());
    }

    public static Customer getInstance() {
        if(instance == null) {
            instance = new Customer();
        }
        return instance;
    }

    public logic.Customer getCustomer(String taxNumber) throws Exception {
        ResultSet rs = this.getById(taxNumber);
        if(!rs.next()) {
            throw new Exception("Customer not found");
        }

        return new logic.Customer(
            rs.getString("taxNumber"),
            rs.getString("name"),
            rs.getString("email"),
            rs.getString("address"),
            rs.getString("phone")
        );
    }

}
