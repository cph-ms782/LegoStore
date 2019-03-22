package Logic;

import Data.OrderMapper_DB;
import Logic.DTO.User;
import Data.UserMapper_DB;
import Logic.DTO.Order;
import Logic.DTO.OrderList;
import java.util.List;

/**
 * The purpose of LogicFacade is to...
 *
 * @author kasper
 */
public class LogicFacade
{

//    private static OrderMapper_Dummy orders = new OrderMapper_Dummy();
//    private static UserMapper_DB users = new UserMapper_DB();
    public static User login(String email, String password) throws LoginSampleException
    {
        return UserMapper_DB.login(email, password);
    }

    public static User createUser(String email, String password) throws LoginSampleException
    {
        User user = new User(email, password, "customer");
        UserMapper_DB.createUser(user);
        return user;
    }

    public static User fetchUser(int userID) throws LoginSampleException
    {
        return UserMapper_DB.getUser(userID);
    }

    public static Order createOrder(Order order) throws OrderSampleException
    {
        return OrderMapper_DB.createOrder(order);
    }

    public static Order fetchOrder(int orderId) throws OrderSampleException
    {
        return OrderMapper_DB.findOrder(orderId, "order");
    }

    public static List<Order> fetchOrders() throws OrderSampleException
    {
        return OrderMapper_DB.findOrders();
    }

    public static List<Order> fetchOrders(int userId) throws OrderSampleException
    {
        return OrderMapper_DB.findOrders(userId);
    }

    public static Order setOrderAsShipped(Order order) throws OrderSampleException
    {
        OrderMapper_DB.changeShipping(order.getOrderID());

//        Used with OrderMapper_Dummy
//        order.setShipped(true);
        return order;
    }

    public static OrderList fillOrderList(List<Order> orders)
    {
        OrderList ol = new OrderList();
        ol.setOrders(orders);
        return ol;
    }

    public static void main(String[] args) throws LoginSampleException, OrderSampleException
    {
//            User u = createUser("hansine@jeppesen.dk", "1234");
//            System.out.println("createUser User: " + u.toString());
        User u = login("hansine@jeppesen.dk", "1234");
        System.out.println("Login User: " + u.toString());

        for (Order fetchOrder : fetchOrders())
        {
            System.out.println(fetchOrder.toString());
        }
        System.out.println("Order 4: " + fetchOrder(4));
        setOrderAsShipped(fetchOrder(4));
        System.out.println("Order 4: " + fetchOrder(4));
    }
}
