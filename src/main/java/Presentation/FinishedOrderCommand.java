package Presentation;

import Logic.DTO.Order;
import Logic.LogicFacade;
import Logic.DTO.User;
import Logic.OrderSampleException;
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
                if ("employee".equals(user.getRole()))
                {
                    session.setAttribute("orders",
                            LogicFacade.fillOrderList(LogicFacade.fetchOrders()));
                    session.setAttribute("order", null);
                } else if ("customer".equals(user.getRole()))
                {
                    session.setAttribute("orders",
                            LogicFacade.fillOrderList(LogicFacade.fetchOrders(user.getID())));
                    session.setAttribute("order", order);
                }
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
