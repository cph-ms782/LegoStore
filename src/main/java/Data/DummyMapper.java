package Data;

import Logic.DTO.User;

/**
 *
 * @author martin
 */
public interface DummyMapper
{
    void createUser( User user );
    User login( String email, String password );
}
