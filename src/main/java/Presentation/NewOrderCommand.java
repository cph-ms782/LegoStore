package Presentation;

import Logic.LoginSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 The purpose of LoginCommand is to...

 @author kasper
 */
public class NewOrderCommand extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        return "neworderpage";
    }
}
