package FunctionLayer;

import DBAccess.CustomerMapper;
import DBAccess.UserMapper;
import Exceptions.LoginSampleException;
import Model.Customer;
import Model.User;

/**
 * The purpose of Authentication is to...
 * @author kasper
 */
public class Authentication {

    public static Customer login(String email, String password ) throws LoginSampleException {
        return CustomerMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User(email, password);
        UserMapper.createUser( user );
        return user;
    }

    public static Customer createCustomer(String name, String email, String password, String phone, String address, String zipcode, String city) throws LoginSampleException {
        Customer customer = new Customer(name, email, password, phone, address, zipcode, city, 0);
        CustomerMapper.createCustomer(customer);
        return customer;
    }
}
