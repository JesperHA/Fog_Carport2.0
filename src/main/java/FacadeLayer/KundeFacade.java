package FacadeLayer;

import DBAccess.CustomerMapper;
import Exceptions.LoginException;
import Exceptions.RegisterException;
import Model.Customer;

import java.util.ArrayList;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class KundeFacade {

    private static ArrayList<Customer> customerList;

    public static ArrayList<Customer> getKunderList() {
        customerList = CustomerMapper.getCustomerList();
        return customerList;
    }

    public static Customer getCustomer(String search, String action) {
        return CustomerMapper.getCustomer(search, action);
    }

    public static Customer checkRegister(Customer newCustomer) throws RegisterException {
        Customer customerCheck;
        customerCheck = KundeFacade.getCustomer(newCustomer.getEmail(), "mail");

        if (customerCheck == null) {
            CustomerMapper.createCustomer(newCustomer);
            return newCustomer;
        } else {
            throw new RegisterException("En bruger med den mail eksisterer allerede!");
        }
    }

    public static Customer checkLogin(String mail, String password) throws LoginException {
        Customer customer;
        customer = getCustomer(mail, "mail");

        if (customer != null) {
            if (customer.getPassword().equals(password)) {
                return customer;
            } else {
                throw new LoginException(mail, password, "Login exception, email and password did not match ");
            }
        } else {
            throw new LoginException(mail, password, "Login exception, user does not exist ");
        }
    }

}
