package Presentation;

import Logic.LogicFacade;
import Logic.LoginSampleException;
import Logic.DTO.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
