package DBAccess;

import Exceptions.LoginException;
import Exceptions.LoginSampleException;
import Exceptions.RegisterException;
import FacadeLayer.KundeFacade;
import Model.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerMapper {

    public static ArrayList<Customer> getCustomerList() {

        ArrayList<Customer> customerList = new ArrayList<>();

        Connection connection;
        PreparedStatement ps;
        ResultSet resultSet;
        String sqlQuery = "SELECT * FROM customers";

        try {
            connection = Connector.connection();
            ps = connection.prepareStatement(sqlQuery);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int customer_id = resultSet.getInt("customer_id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                String zipcode = resultSet.getString("zipcode");
                String city = resultSet.getString("city");
                int role = resultSet.getInt("employee");

                Customer customer = new Customer(customer_id, name, email, password, phone, address, zipcode, city, role);
                customerList.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customerList;

    }

    public static void createCustomer( Customer customer ) {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO customers (name, email, password, phone, address, zipcode, city, employee) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, customer.getName() );
            ps.setString( 2, customer.getEmail() );
            ps.setString( 3, customer.getPassword() );
            ps.setString( 4, customer.getPhone() );
            ps.setString( 5, customer.getAdress() );
            ps.setString(6, customer.getZipcode() );
            ps.setString(7, customer.getCity() );
            ps.setInt(8, 0 );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            customer.setId( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            ex.printStackTrace();
        }
    }

    public static Customer login( String email, String password ) throws LoginException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM customers "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                int customer_id = rs.getInt( "customer_id" );
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String zipcode = rs.getString("zipcode");
                String city = rs.getString("city");
                int role = rs.getInt( "employee" );
                Customer customer = new Customer(name, email, password, phone, address, zipcode, city, role);
                customer.setId( customer_id );
                return customer;
            } else {
                throw new LoginException(email, password, "Login exception, user does not exist ");
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginException(email, password, ex.getMessage());
        }
    }

    public static Customer getCustomer( String search, String action ) {
        String SQL;
        if (action.equals("mail")) {
            SQL = "SELECT * FROM customers "
                    + "WHERE email=?";
        } else {
            SQL = "SELECT * FROM customers "
                    + "WHERE customer_id=?";
        }
        try {
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, search );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                int customer_id = rs.getInt( "customer_id" );
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String zipcode = rs.getString("zipcode");
                String city = rs.getString("city");
                int role = rs.getInt( "employee" );
                Customer customer = new Customer(customer_id, name, email, password, phone, address, zipcode, city, role);
                return customer;
            } else {
                throw new LoginException(search, "n/a", "Login exception, user does not exist ");
            }
        } catch (Exception e) {
        e.printStackTrace();
        }

        return null;
    }
}
