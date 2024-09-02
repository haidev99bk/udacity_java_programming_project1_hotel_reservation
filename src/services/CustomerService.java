package services;

import models.customer.Customer;

import java.util.Collection;

public class CustomerService {
    private static CustomerService ref = new CustomerService ();

    public CustomerService() {
    }


    public static CustomerService getInstance() {
        return ref;
    }

    public void addCustomer(Customer customer) {
    }

    public Customer getCustomer(String email) {
        return null;

    }

    public Collection<Customer> getAllCustomers() {
        return null;

    }
}
