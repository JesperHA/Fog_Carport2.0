package FacadeLayer;

import DBAccess.CustomerMapper;
import Exceptions.LoginSampleException;
import Model.Customer;

import java.util.ArrayList;

public class KundeFacade {

    private static ArrayList<Customer> customerList;

    public static ArrayList<Customer> getKunderList() {
//        if (kundeList == null) {
        customerList = CustomerMapper.getCustomerList();
//        }
        return customerList;
    }

    public static Customer getCustomer(String search, String action) {
        return CustomerMapper.getCustomer(search, action);
    }

}
