package services;

import models.customer.Customer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {
    // Database
    private final Map<String, Customer> customers = new HashMap<> ();

    // Singleton
    private static CustomerService ref = new CustomerService ();

    public CustomerService() {
    }


    public static CustomerService getInstance() {
        return ref;
    }

    public void addCustomer(String email, String firstName, String lastName) {
        try {
            final Customer newCustomer = new Customer (firstName, lastName, email);
            customers.put (email, newCustomer);
        } catch (Exception e) {
            throw e;
        }

    }

    public Customer getCustomer(String email) {
        return null;
    }

    public Collection<Customer> getAllCustomers() {
        return null;

    }
}
