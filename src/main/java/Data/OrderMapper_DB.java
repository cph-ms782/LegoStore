package Data;

import Logic.DTO.Order;
import Logic.Exceptions.OrderSampleException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * The purpose of UserMapper_DB is to...
 *
 * @author kasper
 */
public class OrderMapper_DB
{

    public static Order createOrder(Order order) throws OrderSampleException
    {
        try
        {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO `order` (userid, length, width, height, shipped) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getUserID());
            ps.setInt(2, order.getLength());
            ps.setInt(3, order.getWidth());
            ps.setInt(4, order.getHeight());
            ps.setBoolean(5, order.isShipped());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int orderid = ids.getInt(1);
            order.setOrderID(orderid);
            return order;
        } catch (SQLException | ClassNotFoundException ex)
        {
            throw new OrderSampleException("Kunne ikke skabe ny ordre: " + ex.getMessage());
        }
    }

    /**
     * Find and return one order object.
     *
     * @param id id number (either orderID or userID - see below)
     * @param idType Either "user" or "order"
     * @return
     * @throws OrderSampleException
     */
    public static Order findOrder(int id, String idType) throws OrderSampleException
    {
        try
        {
            Connection con = Connector.connection();
            String i = null;
            if ("order".equals(idType))
            {
                i = "orderid";
            } else if ("user".equals(idType))
            {
                i = "userid";
            } else
            {
                throw new OrderSampleException("No order found");
            }
            String SQL = "SELECT orderid, userid, length, width, height, shipped FROM `order` "
                    + "WHERE " + i + "=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                int orderid = rs.getInt("orderid");
                int userid = rs.getInt("userid");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                boolean shipped = rs.getBoolean("shipped");
                Order order = new Order(userid, length, width, height, shipped);
                order.setOrderID(orderid);
                return order;
            } else
            {
                throw new OrderSampleException("Kunne ikke finde ny ordre");
            }
        } catch (ClassNotFoundException | SQLException ex)
        {
            throw new OrderSampleException(ex.getMessage());
        }
    }

    public static List<Order> findOrders() throws OrderSampleException
    {
        List<Order> orders = new ArrayList<>();

        try
        {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM `order`";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                Order o = new Order(
                        rs.getInt("userid"),
                        rs.getInt("length"),
                        rs.getInt("width"),
                        rs.getInt("height"),
                        rs.getBoolean("shipped")
                );
                o.setOrderID(rs.getInt("orderid"));
                if (o.getOrderID() > 0)
                {
                    orders.add(o);
                }
            }
        } catch (ClassNotFoundException | SQLException ex)
        {
            throw new OrderSampleException("Der skete en fejl da liste af ordre skulle samles: " + ex.getMessage());
        }

        return orders;
    }

    /**
     * Find and return a list of orders from one customer
     *
     * @param userID
     * @return
     * @throws OrderSampleException
     */
    public static List<Order> findOrders(int userID) throws OrderSampleException
    {
        List<Order> userOrderList = new ArrayList<>();
        for (Order order : findOrders())
        {
            if (userID == order.getUserID())
            {
                userOrderList.add(order);
            }
        }
        return userOrderList;
    }

    public static void changeShipping(int orderID) throws OrderSampleException
    {
        try
        {
            Connection con = Connector.connection();
            String SQL = "UPDATE `order` SET `shipped` = '1' WHERE (`orderid` = ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, orderID);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex)
        {
            throw new OrderSampleException("Der skete en fejl da Afsendelses-status skulle ændres i DB: " + ex.getMessage());
        }
    }

}
