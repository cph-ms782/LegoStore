package Logic;

import Logic.Exceptions.LoginSampleException;
import Logic.Exceptions.OrderSampleException;
import Data.OrderMapper_DB;
import Logic.DTO.User;
import Data.UserMapper_DB;
import Logic.DTO.Order;
import Logic.DTO.OrderList;
import java.util.List;

/**
 * facade for handling traffic between data and logic and between logic and presentation
 *
 * @author kasper and martin bøgh
 */
public class LogicFacade
{

//    private static OrderMapper_Dummy orders = new OrderMapper_Dummy();
//    private static UserMapper_DB users = new UserMapper_DB();
    
    /**
     * return a User object when given email and password Strings
     * 
     * @param email
     * @param password
     * @return User object
     * @throws LoginSampleException 
     */
    public static User login(String email, String password) throws LoginSampleException
    {
        return UserMapper_DB.login(email, password);
    }

    
    /**
     * 
     * @param email
     * @param password
     * @return
     * @throws LoginSampleException 
     */
    public static User createUser(String email, String password) throws LoginSampleException
    {
        User user = new User(email, password, "customer");
        UserMapper_DB.createUser(user);
        return user;
    }

    
    /**
     * 
     * @param userID
     * @return
     * @throws LoginSampleException 
     */
    public static User fetchUser(int userID) throws LoginSampleException
    {
        return UserMapper_DB.getUser(userID);
    }

    
    /**
     * 
     * @param order
     * @return
     * @throws OrderSampleException 
     */
    public static Order createOrder(Order order) throws OrderSampleException, LoginSampleException
    {
        return OrderMapper_DB.createOrder(order);
    }

    
    /**
     * 
     * @param orderId
     * @return
     * @throws OrderSampleException 
     */
    public static Order fetchOrder(int orderId) throws OrderSampleException, LoginSampleException
    {
        return OrderMapper_DB.findOrder(orderId, "order");
    }

    
    /**
     * 
     * @return
     * @throws OrderSampleException 
     */
    public static List<Order> fetchOrders() throws OrderSampleException, LoginSampleException
    {
        return OrderMapper_DB.findOrders();
    }

    
    /**
     * 
     * @param userId
     * @return
     * @throws OrderSampleException 
     */
    public static List<Order> fetchOrders(int userId) throws OrderSampleException, LoginSampleException
    {
        return OrderMapper_DB.findOrders(userId);
    }

    
    /**
     * changes an orders status in database
     * 
     * @param order
     * @return Order object
     * @throws OrderSampleException 
     */
    public static Order setOrderAsShipped(Order order) throws OrderSampleException, LoginSampleException
    {
        OrderMapper_DB.changeShipping(order.getOrderID());

//        Used with OrderMapper_Dummy
//        order.setShipped(true);
        return order;
    }

    
    /**
     * wrap list of Order's in OrderList object (for storing in session later)
     * 
     * @param orders
     * @return Orderlist object
     */
    public static OrderList fillOrderList(List<Order> orders)
    {
        OrderList ol = new OrderList();
        ol.setOrders(orders);
        return ol;
    }
}
