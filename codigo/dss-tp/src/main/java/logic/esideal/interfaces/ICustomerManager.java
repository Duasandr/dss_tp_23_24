package logic.esideal.interfaces;

import logic.Customer;

public interface ICustomerManager {
    Customer get(String id) throws Exception;
}
