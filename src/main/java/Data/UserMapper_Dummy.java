package Data;

import Logic.DTO.User;
import Logic.Exceptions.LoginSampleException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author martin
 */
public class UserMapper_Dummy
{

    private static List<User> users = new ArrayList<>();
    private static int userID = 0;

    public UserMapper_Dummy()
    {
        User u = new User("hans@jensen.dk", "1234", "employee");
        u.setID(++userID);
        users.add(u);
        u = new User("jens@hansen.dk", "1234", "customer");
        u.setID(++userID);
        users.add(u);
        u = new User("morten@jensen.dk", "1234", "customer");
        u.setID(++userID);
        users.add(u);
        u = new User("heine@jensen.dk", "1234", "customer");
        u.setID(++userID);
        users.add(u);
        u = new User("jens@somewhere.com", "jensen", "customer");
        u.setID(++userID);
        users.add(u);
    }

    public static void createUser(User user) throws LoginSampleException
    {
        user.setID(userID++);
        users.add(user);
    }

    public static User login(String email, String password) throws LoginSampleException
    {
        for (User user : users)
        {
            if (user.getEmail().equals(email) && user.getPassword().equals(password))
            {
                return user;
            }
        }
        return null;
    }

    public static User getUser(int userID) throws LoginSampleException
    {
        for (User user : users)
        {
            if (user.getID() == (userID))
            {
                return user;
            }
        }
        return null;
    }
}
