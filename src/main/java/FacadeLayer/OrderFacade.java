package FacadeLayer;

import DBAccess.OrderMapper;
import Model.Order;

import java.util.ArrayList;

public class OrderFacade {

    private static ArrayList<Order> ordermapper;

    public static ArrayList<Order> getOrderList(){

        ordermapper = OrderMapper.getOrderList();

        return ordermapper;
    }

    public static Order getOrderById(int id){

        return OrderMapper.getOrder(id);
    }

}
