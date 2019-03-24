package Presentation;

import Presentation.Command;
import Logic.Exceptions.UnknownCommandException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The purpose of UnknownCommand is to pass on exception error "tell user that IT needs to be called"
 *
 *  @author kasper & martin bøgh
 */
public class UnknownCommand extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws UnknownCommandException {
        throw new UnknownCommandException();
    }
}
