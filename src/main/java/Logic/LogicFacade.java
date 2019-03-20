package Logic;

import Data.OrderMapper_Dummy;
import Logic.DTO.User;
import Data.UserMapper_DB;
import Data.UserMapper_Dummy;
import Logic.DTO.Order;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The purpose of LogicFacade is to...
 *
 * @author kasper
 */
public class LogicFacade
{

    private static OrderMapper_Dummy orders = new OrderMapper_Dummy();
    private static UserMapper_Dummy users = new UserMapper_Dummy();

    public static User login(String email, String password) throws LoginSampleException
    {
        return UserMapper_Dummy.login(email, password);
    }

    public static User createUser(String email, String password) throws LoginSampleException
    {
        User user = new User(email, password, "customer");
        UserMapper_Dummy.createUser(user);
        return user;
    }

    
    public static Order CreateOrder(Order order) throws OrderSampleException
    {
        return OrderMapper_Dummy.createOrder(order);
    }
    
    public static Order fetchOrder(int orderId) throws OrderSampleException
    {
        return OrderMapper_Dummy.findOrder(orderId);
    }

    public static List<Order> fetchOrders() throws OrderSampleException
    {
        return OrderMapper_Dummy.findOrders();
    }
    
    public static Order setOrderAsShipped(Order order)
    {
        order.setShipped(true);
        return order;
    }
    
    public static void main(String[] args) throws LoginSampleException
    {
        try
        {
            User u = createUser("hans@jensen.dk", "1234");
            System.out.println("createUser User: " + u.toString());
            u = login("hans@jensen.dk", "1234");
            System.out.println("Login User: " + u.toString());
            
            for (Order fetchOrder : fetchOrders())
            {
                System.out.println(fetchOrder.toString());
                        }
            System.out.println("Order 2: " + fetchOrder(2));
            setOrderAsShipped(fetchOrder(2));
            System.out.println("Order 2: " + fetchOrder(2));
            for (String arg : args)
            {
                
            }
        } catch (OrderSampleException ex)
        {
            Logger.getLogger(LogicFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
