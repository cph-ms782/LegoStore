package Data;

import Logic.Exceptions.LoginSampleException;
import Logic.DTO.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The purpose of UserMapper_DB is to...
 *
 * @author kasper
 */
public class UserMapper_DB
{

    private static ResultSet rs;
    private static PreparedStatement ps;
    private static Connection con;

    public static User createUser(User user) throws LoginSampleException
    {
        try
        {
            con = Connector.connection(con);
            String SQL = "INSERT INTO user (email, password, role) VALUES (?, ?, ?)";
            ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            user.setID(id);
            return user;
        } catch (SQLException | ClassNotFoundException ex)
        {
            throw new LoginSampleException("Der skete en fejl. Forsøg evt. med en anden email"
                    + " adresse...." + ex.getMessage());
        } finally
        {
            Connector.CloseConnection(rs, ps, con);
        }
    }

    public static User login(String email, String password) throws LoginSampleException
    {
        try
        {
            con = Connector.connection(con);
            String SQL = "SELECT id, role FROM user "
                    + "WHERE email=? AND password=?";
            ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next())
            {
                int id = rs.getInt("id");
                String role = rs.getString("role");
                User user = new User(email, password, role);
                user.setID(id);
                return user;
            } else
            {
                throw new LoginSampleException("Kunne ikke finde bruger");
            }
        } catch (ClassNotFoundException | SQLException ex)
        {
            throw new LoginSampleException("Login problem: " + ex.getMessage());
        } finally
        {
            Connector.CloseConnection(rs, ps, con);
        }
    }

    public static User getUser(int userID) throws LoginSampleException
    {
        try
        {
            con = Connector.connection(con);
            String SQL = "SELECT * FROM user "
                    + "WHERE id=?";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            if (rs.next())
            {
                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");
                User user = new User(email, password, role);
                user.setID(userID);
                return user;
            } else
            {
                throw new LoginSampleException("Kunne ikke finde bruger");
            }
        } catch (ClassNotFoundException | SQLException ex)
        {
            throw new LoginSampleException("Kunne ikke finde bruger" + ex.getMessage());
        } finally
        {
            Connector.CloseConnection(rs, ps, con);
        }
    }
}
