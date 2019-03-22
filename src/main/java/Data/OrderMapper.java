package Data;

import Logic.DTO.Order;
import Logic.OrderSampleException;
import java.util.List;

/**
 *
 * @author martin
 */
public interface OrderMapper
{
    void createOrder(Order order) throws OrderSampleException;
    Order findOrder(int orderID) throws OrderSampleException;
    List<Order> findOrders() throws OrderSampleException;
}
