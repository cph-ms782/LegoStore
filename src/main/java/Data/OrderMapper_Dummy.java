package Data;

import Logic.DTO.Order;
import Logic.OrderSampleException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author martin
 */
public class OrderMapper_Dummy
{
    private static List<Order> orders;
    private static int orderID = 1;

    public OrderMapper_Dummy()
    {
        orders = new ArrayList<>();
        Order o = new Order(1,3,7,5,false);
        o.setOrderID(++orderID);
        orders.add(o);
        
         o = new Order(1,3,7,5,false);
        o.setOrderID(++orderID);
        orders.add(o);
        
         o = new Order(3,3,7,5,false);
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

    public static Order findOrder(int orderID) throws OrderSampleException
    {
        for (Order order : orders)
        {
            if (order.getOrderID() == orderID)
            {
                return order;
            }
        }
        throw new OrderSampleException("No order found");
    }

    public static List<Order> findOrders() throws OrderSampleException
    {
        return orders;
    }

}
