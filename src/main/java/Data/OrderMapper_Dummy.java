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

    public OrderMapper_Dummy()
    {
        orders = new ArrayList<>();
        orders.add(new Order(1,1,3,7,5,false));
        orders.add(new Order(2,2,4,6,3,false));
        orders.add(new Order(3,3,4,7,3,false));
        orders.add(new Order(4,3,5,6,5,false));
    }

    public static void createOrder(Order order) throws OrderSampleException
    {
        orders.add(order);
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

    public List<Order> findOrders() throws OrderSampleException
    {
        return orders;
    }

}
