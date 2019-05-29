package DBAccess;

import Exceptions.LoginException;
import Model.Customer;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerMapperTest {

    @Test
    public void login() throws LoginException {
        String email = "simon@mail.dk";
        String password = "1234";
        Customer customer = CustomerMapper.login(email, password);
        assertTrue(customer != null);
    }

    @Test
    public void getCustomer() {
        String email = "simon@mail.dk";
        String id = "3";
        Customer customer_email = CustomerMapper.getCustomer(email, "mail");
        Customer customer_id = CustomerMapper.getCustomer(id, "id");
        assertTrue(customer_email != null);
        assertTrue(customer_id != null);
    }


}
