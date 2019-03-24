package Presentation;

import Logic.LogicFacade;
import Logic.DTO.Order;
import Logic.DTO.User;
import Logic.Exceptions.LoginSampleException;
import Logic.Exceptions.OrderSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * handling a finished order command coming from the neworderpage.jsp
 *
 * @author martin bøgh
 */
public class FinishedOrderCommand extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws OrderSampleException, LoginSampleException
    {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

//      check if the user is logged ind
        if (user != null && "customer".equals(user.getRole()))
        {
            try
            {
                int length = Integer.parseInt(request.getParameter("length"));
                int width = Integer.parseInt(request.getParameter("width"));
                int height = Integer.parseInt(request.getParameter("height"));

                Order order = new Order(user.getID(), length, width, height, false);

                try
                {
                    //Save and fill order with orderID
                    order = LogicFacade.createOrder(order);
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
                {// if there's been an error in the fetching of data from storage
                    throw new OrderSampleException("Der er sket en fejl i håndteringen af den nye ordre" + ex.getMessage());
                }
            } catch (NumberFormatException ex)
            {// if something not a number was entered
                throw new OrderSampleException("Ikke alle indtastede værdier var hele tal: " + ex.getMessage());
            }
//          if there's been no exception pass on to the next page
            return "orderpage";
        }
//      if you're not logged in an a customer this message
        throw new LoginSampleException("Man skal være en logget ind kunde for kunne ordre hus");
    }

}
