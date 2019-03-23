package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The purpose of Connector is to...
 *
 * @author kasper
 */
public class Connector
{

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://128.199.46.149:3306/legostore";
    private static final String USERNAME = "testuser";
    private static final String PASSWORD = "password123";

    public static Connection connection(Connection con) throws ClassNotFoundException, SQLException
    {
        if (con != null && !con.isClosed())
        {
            return con;
        }

        if (con == null || con.isClosed())
        {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        return con;
    }

    public static void CloseConnection(ResultSet rs, PreparedStatement ps, Connection con)
    {
        try
        {
            rs.close();
        } catch (Exception e)
        {
            /* ignored */ }
        try
        {
            ps.close();
        } catch (Exception e)
        {
            /* ignored */ }
        try
        {
            con.close();
        } catch (Exception e)
        {
            /* ignored */ }
    }
}
