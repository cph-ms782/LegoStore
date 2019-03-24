package Presentation;

import Logic.DTO.Bricks;
import Logic.DTO.Order;
import Logic.LogicFacade;
import Logic.DTO.User;
import Logic.Exceptions.LoginSampleException;
import Logic.Exceptions.OrderSampleException;
import Logic.calcHouse;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * handling a new order command from request
 *
 * @author martin bøgh
 */
public class CheckOrderCommand extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderSampleException
    {
        boolean isShipped = false;
        boolean isEmployee = false;
        boolean isOrder = false;
        int orderID = 0;

        String changeShipped = (String) request.getParameter("orderSent");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String role = (String) session.getAttribute("role");

//          check if the user is logged ind
        if (user != null)
        {
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

            if (role != null && role.equals("employee"))
            {
                isEmployee = true;
            }

            try
            {
//                  setup the orderInfo box. Calculate lineitems.
                if (isOrder && orderID > 0)
                {
                    Order o = LogicFacade.fetchOrder(orderID);
                    
//                  calculate house lineitems
                    Bricks bricks = calcHouse.calc(o.getLength(),
                            o.getWidth(), o.getHeight());

//                      set status as shipped.
                    if (isShipped)
                    {
                        o = LogicFacade.setOrderAsShipped(o);
                    }
                    session.setAttribute("bricks", bricks);
                    session.setAttribute("order", o);
                    session.setAttribute("orderUser", LogicFacade.fetchUser(o.getUserID()));
                } else
                { // set all used attributes to null if there is no order
                    session.setAttribute("bricks", null);
                    session.setAttribute("order", null);
                    session.setAttribute("orderUser", null);
                }

//                  check for employee. Then either show all the orders or only the users orders
                if (isEmployee)
                {
                    session.setAttribute("orders",
                            LogicFacade.fillOrderList(LogicFacade.fetchOrders()));

                } else
                { // user's orders
                    List<Order> list = LogicFacade.fetchOrders(user.getID());
                    if (list.size() > 0)
                    {
                        session.setAttribute("orders",
                                LogicFacade.fillOrderList(list));

                    } else
                    { // throw message if there's no order yet
                        throw new OrderSampleException("Der er ingen ordrer endnu");
                    }
                }
            } catch (OrderSampleException ex)
            {// if something goes wrong with all the checking and pulling out data from storage this message will appear
                throw new OrderSampleException("Der skete en fejl mens liste af ordre blev samlet: "
                        + ex.getMessage());
            }
        } else
        {// if you're logged out (aka there's no User in session) then this message
            throw new LoginSampleException("Du er logget ud. Log ind for at fortsætte");
        }

//      if there were no exceptions sprung show the orderpage
        return "orderpage";
    }

}
