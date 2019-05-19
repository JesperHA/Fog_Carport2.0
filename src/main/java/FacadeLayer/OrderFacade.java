package FacadeLayer;

import DBAccess.OrderMapper;
import Model.Order;

import java.util.ArrayList;

public class OrderFacade {

    public static ArrayList<Order> getOrderList() {
        return OrderMapper.getOrderList();
    }

    public static ArrayList<Order> getOrderListForCustomer(int customer_id) {
        return OrderMapper.getOrderListForCustomer(customer_id);
    }

    public static Order getOrder(int id) {
        return OrderMapper.getOrder(id);
    }

    public static String changeStatus(String order_id, int status) {
        return OrderMapper.changeStatus(order_id, status);
    }

    public static Order changeOrder(Order order) {
        return OrderMapper.updateOrder(order);
    }

    public static String deleteOrder(Order order) {
        return OrderMapper.deleteOrder(order);
    }
}
