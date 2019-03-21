package Presentation;

import Logic.DTO.Order;
import Logic.LogicFacade;
import Logic.DTO.User;
import Logic.LoginSampleException;
import Logic.OrderSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckOrderCommand extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, LoginSampleException
    {
        try
        {
            String seeOrder = (String) request.getParameter("seeOrder");
            boolean isOrder = false;
            int orderID = 0;
            if ("true".equals(seeOrder))
            {
                isOrder = true;
            }
            Object oID = request.getParameter("orderID");
            if (oID != null)
            {
                orderID = Integer.parseInt(request.getParameter("orderID"));
            }
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");

            try
            {
                //Save and fill order with orderID
                session.setAttribute("orders",
                        LogicFacade.fillOrderList(LogicFacade.fetchOrders()));
                if (isOrder && orderID > 0)
                {
                    Order o = LogicFacade.fetchOrder(orderID);
                    session.setAttribute("order", o);
                    session.setAttribute("orderUser", LogicFacade.fetchUser(o.getUserID()));
                } else
                {
                    session.setAttribute("order", null);
                    session.setAttribute("orderUser", null);
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
