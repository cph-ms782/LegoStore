package Data;

import Logic.LoginSampleException;
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

    public static void createUser(User user) throws LoginSampleException
    {
        try
        {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO user (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setID(id);
        } catch (SQLException | ClassNotFoundException ex)
        {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static User login(String email, String password) throws LoginSampleException
    {
        try
        {
            Connection con = Connector.connection();
            String SQL = "SELECT id, role FROM user "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                int id = rs.getInt("id");
                String role = rs.getString("role");
                User user = new User(email, password, role);
                user.setID(id);
                return user;
            } else
            {
                throw new LoginSampleException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex)
        {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static User getUser(int userID) throws LoginSampleException
    {
        try
        {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM user "
                    + "WHERE id=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
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
                throw new LoginSampleException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex)
        {
            throw new LoginSampleException(ex.getMessage());
        }
    }

}
