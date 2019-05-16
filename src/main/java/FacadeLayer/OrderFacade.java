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

    public static Order getOrder(int id) {
        Order order = OrderMapper.getOrder(id);
        return order;
    }
}
