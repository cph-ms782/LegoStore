package Presentation;

import Presentation.Command;
import Logic.UnknownCommandException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 The purpose of UnknownCommand is to...

 @author kasper
 */
public class UnknownCommand extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws UnknownCommandException {
        throw new UnknownCommandException();
    }

}
