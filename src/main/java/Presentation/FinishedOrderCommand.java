package Presentation;

import Logic.DTO.Order;
import Logic.LogicFacade;
import Logic.LoginSampleException;
import Logic.DTO.User;
import Logic.OrderSampleException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FinishedOrderCommand extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException
    {
        try
        {
            int length = Integer.parseInt(request.getParameter("length"));
            int width = Integer.parseInt(request.getParameter("width"));
            int height = Integer.parseInt(request.getParameter("height"));

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            Order order = new Order(user.getID(), length, width, height, false);
            try
            {
                //Save and fill order with orderID
                order = LogicFacade.CreateOrder(order);
                session.setAttribute("order", order);
            } catch (OrderSampleException ex)
            {
                ex.printStackTrace();
            }
        } catch (NumberFormatException ex)
        {
            throw new NumberFormatException("Ikke alle indtastede værdier var hele tal");
        }
        return "orderpage";
    }

}
