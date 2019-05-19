package FacadeLayer;

import DBAccess.OrderMapper;
import Model.Order;

import java.util.ArrayList;

public class OrderFacade {

    private static ArrayList<Order> orderList;

    public static ArrayList<Order> getOrderList() {
        orderList = OrderMapper.getOrderList();
        return orderList;
    }

    public static ArrayList<Order> getOrderListForCustomer(int customer_id) {
        orderList = OrderMapper.getOrderListForCustomer(customer_id);
        return orderList;
    }

    public static Order getOrder(int id) {
        Order order = OrderMapper.getOrder(id);
        return order;
    }

    public static String changeStatus(String order_id, int status) {
        String success = OrderMapper.changeStatus(order_id, status);

        return success;
    }

    public static Order changeOrder(Order order) {
        order = OrderMapper.updateOrder(order);

        return order;
    }

    public static String deleteOrder(Order order) {
        String success = OrderMapper.deleteOrder(order);

        return success;
    }
}
