package Presentation;

import Logic.Exceptions.LoginSampleException;
import Logic.Exceptions.OrderSampleException;
import Logic.Exceptions.UnknownCommandException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("LoginCommand", new LoginCommand());
        commands.put("LogoutCommand", new LogoutCommand());
        commands.put("RegisterCommand", new RegisterCommand());
        commands.put("NewOrderCommand", new NewOrderCommand());
        commands.put("FinishedOrderCommand", new FinishedOrderCommand());
        commands.put("CheckOrderCommand", new CheckOrderCommand());
    }

    static Command from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws LoginSampleException, OrderSampleException, UnknownCommandException;

}
