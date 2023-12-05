package logic.esideal;

import data.dao.Customer;
import data.dao.Vehicle;
import logic.esideal.interfaces.ICustomerManager;

public class CustomerManager implements ICustomerManager {
    private final Customer customerDAO;

    public CustomerManager() {
        customerDAO = Customer.getInstance();
    }

    public logic.Customer get(String id) throws Exception {
        return customerDAO.getCustomer(id);
    }

}
