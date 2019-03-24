package Presentation;

import Logic.Exceptions.LoginSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 The purpose of LogoutCommand is to show you're logged out

 @author martin bøgh
 */
public class LogoutCommand extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        HttpSession session = request.getSession();
        session.setAttribute( "user", null);
        session.setAttribute( "role", null);
        throw new LoginSampleException(("Du er nu logget ud!"));
    }
}
