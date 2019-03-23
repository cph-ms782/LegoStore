package Logic.Exceptions;

/**
 * The purpose of DBException is to handle exceptions in the DB connector
 * 
 * @author martin bøgh
 */
public class DBException extends Exception {

    public DBException(String msg) {
        super(msg);
    }
}
