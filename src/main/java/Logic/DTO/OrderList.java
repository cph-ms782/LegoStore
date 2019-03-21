package Logic.DTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author martin
 */
public class OrderList
{
    private List<Order> orders=null;

    public OrderList()
    {
    }

    public List<Order> getOrders()
    {
        return orders;
    }

    public void setOrders(List<Order> orders)
    {
        this.orders = orders;
    }
    
}
