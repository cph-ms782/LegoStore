package Data;

import Logic.Exceptions.LoginSampleException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Database connector. Will open up closed connection Is not a singelton at the
 * moment
 *
 * @author martin
 */
public class Connector
{

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://128.199.46.149:3306/legostore";
    private static final String USERNAME = "testuser";
    private static final String PASSWORD = "password123";

    /**
     * open connection if there is none or reopen if its closed
     * 
     * @param con
     * @return
     * @throws LoginSampleException (SQL exceptions and classnotfoundException
     */
    public static Connection connection(Connection con) throws LoginSampleException
    {
        try
        {
            if (con != null && !con.isClosed())//sqlexception
            {
                return con;
            }

            if (con == null || con.isClosed())//sqlexception
            {
                Class.forName(DRIVER); //class not found exception
                con = DriverManager.getConnection(URL, USERNAME, PASSWORD); //sqlexception
            }
            return con;
        } catch (SQLException ex)
        {
            throw new LoginSampleException("Der er sket en fejl i forbindelsen med databasen (Connector.connection): "
                    + ex.getMessage());
        } catch (ClassNotFoundException ex)
        {
            throw new LoginSampleException("Der er ikke fundet en driver til forbindelsen til databasen (Connector.connection): "
                    + ex.getMessage());
        }
    }

    /**
     * Closing connections to database, so user will be able to use database after some time has gone
     * 
     * @param rs
     * @param ps
     * @param con 
     */
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
