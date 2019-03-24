package Presentation;

import Logic.LogicFacade;
import Logic.Exceptions.LoginSampleException;
import Logic.DTO.User;
import Logic.Exceptions.OrderSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * handling a new user command from request (when pressing "Registration" in login menu)
 *
 * @author martin bøgh
 */
public class RegisterCommand extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException, OrderSampleException {
        String email = request.getParameter( "email" );
        String password1 = request.getParameter( "password1" );
        String password2 = request.getParameter( "password2" );
        if ( password1.equals( password2 ) ) {
            User user = LogicFacade.createUser( email, password1 );
            HttpSession session = request.getSession();
            session.setAttribute( "user", user );
            session.setAttribute( "role", user.getRole() );
            return user.getRole() + "page";
        } else {
            throw new LoginSampleException("De to kodeord passer ikke sammen");
        }
    }

}
