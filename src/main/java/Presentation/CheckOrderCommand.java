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
            String changeShipped = (String) request.getParameter("orderSent");
            boolean isShipped = false;
            boolean isEmployee = false;
            boolean isOrder = false;
            int orderID = 0;

            if ("true".equals(changeShipped))
            {
                isShipped = true;
            }
            String seeOrder = (String) request.getParameter("seeOrder");
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
            String role = (String) session.getAttribute("role");
            if (role != null && role.equals("employee"))
            {
                isEmployee = true;
            }

            try
            {
                //Save and fill order with orderID
                if (isEmployee)
                {
                    session.setAttribute("orders",
                            LogicFacade.fillOrderList(LogicFacade.fetchOrders()));
                } else
                {
                    session.setAttribute("orders",
                            LogicFacade.fillOrderList(LogicFacade.fetchOrders(user.getID())));
                }
                if (isOrder && orderID > 0)
                {
                    Order o = LogicFacade.fetchOrder(orderID);
                    if (isShipped)
                    {
                        LogicFacade.setOrderAsShipped(o);
                    }
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
