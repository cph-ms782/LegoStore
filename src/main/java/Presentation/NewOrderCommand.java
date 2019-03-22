package Presentation;

import Logic.OrderSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class NewOrderCommand extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws OrderSampleException {
        return "neworderpage";
    }
}
