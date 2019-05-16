package DBAccess;

import Exceptions.LoginSampleException;
import Model.Order;

import java.sql.*;
import java.util.ArrayList;

public class OrderMapper {
    public static ArrayList<Order> getOrderList() {

        ArrayList<Order> orderList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        String sqlQuery = "SELECT * FROM orders";

        try {
            connection = Connector.connection();
            ps = connection.prepareStatement(sqlQuery);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int order_id = resultSet.getInt("order_id");
                int customer_id = resultSet.getInt("customer_id");
                int length = resultSet.getInt("length");
                int height = resultSet.getInt("height");
                int width = resultSet.getInt("width");
                int roof = resultSet.getInt("roof");
                int shed = resultSet.getInt("shed");
                int shedtype = resultSet.getInt("shedtype");
                int order_status = resultSet.getInt("order_status");
                String date = resultSet.getString("date");

                Order order = new Order(order_id, customer_id, length, height, width, roof, shed ,shedtype, order_status, date);
                orderList.add(order);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList;
    }

    public static void createOrder( Order order ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders (customer_id, length, height, width, roof, shed, shedtype, order_status, date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setInt( 1, order.getCustomer_id());
            ps.setInt( 2, order.getLength());
            ps.setInt( 3, order.getHeight());
            ps.setInt( 4, order.getWidth());
            ps.setInt( 5, order.getRoof());
            ps.setInt(6, order.getShed());
            ps.setInt(7, order.getShedtype() );
            ps.setInt(8, order.getOrder_status());
            ps.setString(9, order.getDate());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            order.setOrder_id(id);
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }

    public static Order getOrder(int id) {

        Order order = null;
        String idString = "" + id;

        ArrayList<Order> orderList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        String sqlQuery = "SELECT * FROM orders WHERE order_id = ?";

        try {
            connection = Connector.connection();
            ps = connection.prepareStatement(sqlQuery);

            ps.setString(1, idString);

            resultSet = ps.executeQuery();

            if (resultSet.next()) {
                int order_id = resultSet.getInt("order_id");
                int customer_id = resultSet.getInt("customer_id");
                int length = resultSet.getInt("length");
                int height = resultSet.getInt("height");
                int width = resultSet.getInt("width");
                int roof = resultSet.getInt("roof");
                int shed = resultSet.getInt("shed");
                int shedtype = resultSet.getInt("shedtype");
                int order_status = resultSet.getInt("order_status");
                String date = resultSet.getString("date");

                order = new Order(order_id, customer_id, length, height, width, roof, shed ,shedtype, order_status, date);
                return order;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }
}