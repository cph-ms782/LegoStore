package Logic.Exceptions;

/**
 * The purpose of LoginSampleException is to handle exception circling about
 * user login IO with DB
 * 
 * @author kasper & martin bøgh
 */
public class LoginSampleException extends Exception {

    public LoginSampleException(String msg) {
        super(msg);
    }
}
