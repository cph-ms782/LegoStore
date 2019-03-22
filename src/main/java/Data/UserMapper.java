package Data;

import Logic.DTO.User;
import Logic.Exceptions.LoginSampleException;

/**
 *
 * @author martin
 */
public interface UserMapper
{
    void createUser(User user) throws LoginSampleException;
    User login(String email, String password) throws LoginSampleException;
}
