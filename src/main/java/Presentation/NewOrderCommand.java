package Presentation;

import Logic.DTO.User;
import Logic.Exceptions.LoginSampleException;
import Logic.Exceptions.OrderSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NewOrderCommand extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws OrderSampleException, LoginSampleException
    {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

//      check if the user is logged ind
        if (user != null && "customer".equals(user.getRole()))
        {
            return "neworderpage";
        }
        throw new LoginSampleException("Man skal være en logget ind kunde for kunne ordre hus");
    }
}
