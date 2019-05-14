package DBAccess;

import Exceptions.LoginSampleException;
import Model.Customer;
import Model.User;

import java.sql.*;
import java.util.ArrayList;

public class CustomerMapper {

    public static ArrayList<Customer> getCustomerList() {

        ArrayList<Customer> customerList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
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

    public static void createCustomer( Customer customer ) throws LoginSampleException {
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
            throw new LoginSampleException( ex.getMessage() );
        }
    }

    public static Customer login( String email, String password ) throws LoginSampleException {
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
                throw new LoginSampleException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
}
