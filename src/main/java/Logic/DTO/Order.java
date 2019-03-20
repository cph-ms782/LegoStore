package Logic.DTO;

/**
 *
 * @author martin
 */
public class Order
{
    private int orderID;
    private int userID;
    private int length;
    private int width;
    private int height;
    private boolean Shipped;

    public Order(int userID, int length, int width, int height, boolean Shipped)
    {
        this.orderID = orderID;
        this.userID = userID;
        this.length = length;
        this.width = width;
        this.height = height;
        this.Shipped = Shipped;
    }

    public int getOrderID()
    {
        return orderID;
    }

    public void setOrderID(int orderID)
    {
        this.orderID = orderID;
    }

    public int getUserID()
    {
        return userID;
    }

    public void setUserID(int userID)
    {
        this.userID = userID;
    }

    public int getLength()
    {
        return length;
    }

    public void setLength(int length)
    {
        this.length = length;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public boolean isShipped()
    {
        return Shipped;
    }

    public void setShipped(boolean Shipped)
    {
        this.Shipped = Shipped;
    }

    @Override
    public String toString()
    {
        return "Order{" + "orderID=" + orderID + ", userID=" + userID + ", length=" + length + ", width=" + width + ", height=" + height + ", Shipped=" + Shipped + '}';
    }

    
    
}
