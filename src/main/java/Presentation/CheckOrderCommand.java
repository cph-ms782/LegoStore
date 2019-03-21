package Presentation;

import Logic.DTO.Order;
import Logic.LogicFacade;
import Logic.DTO.User;
import Logic.OrderSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckOrderCommand extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException
    {
        try
        {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");

            try
            {
                //Save and fill order with orderID
                session.setAttribute("orders",
                        LogicFacade.fillOrderList(LogicFacade.fetchOrders()));
                session.setAttribute("order", null);
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
