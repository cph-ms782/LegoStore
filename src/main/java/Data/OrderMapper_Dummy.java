package Data;

import Logic.DTO.Order;
import Logic.Exceptions.OrderSampleException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author martin
 */
public class OrderMapper_Dummy
{
    private static List<Order> orders;
    private static int orderID = 0 ;

    public OrderMapper_Dummy()
    {
        orders = new ArrayList<>();
        Order o = new Order(1,2,3,4,false);
        o.setOrderID(++orderID);
        orders.add(o);
        
         o = new Order(1,6,2,11,false);
        o.setOrderID(++orderID);
        orders.add(o);
        
         o = new Order(3,2,4,2,false);
        o.setOrderID(++orderID);
        orders.add(o);

        o = new Order(2,3,7,5,false);
        o.setOrderID(++orderID);
        orders.add(o);
    }

    public static Order createOrder(Order order) throws OrderSampleException
    {
        order.setOrderID(++orderID);
        orders.add(order);
        return order;
    }

    public static Order findOrder(int id, String idType) throws OrderSampleException
    {
        for (Order order : orders)
        {
            if ("order".equals(idType) && order.getOrderID() == id)
            {
                return order;
            } else if  ("user".equals(idType) && order.getUserID()== id){
                return order;
            }
        }
        return null;
    }

    public static List<Order> findOrders() throws OrderSampleException
    {
        return orders;
    }

    public static List<Order> findOrders(int userID) throws OrderSampleException
    {
        List<Order> userOrderList=new ArrayList<>();
        for (Order order : orders)
        {
            if(userID == order.getUserID()){
                userOrderList.add(order);
            }
        }
        return userOrderList;
    }
}
