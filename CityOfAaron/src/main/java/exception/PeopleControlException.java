/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Bryan
 */
public class PeopleControlException extends Exception {

    public PeopleControlException() {
        // empty constructor
    }

    public PeopleControlException(String message, Throwable cause, boolean enableSuppression, boolean writeableStackTrace) {
        super(message, cause, enableSuppression, writeableStackTrace);
    }

    public PeopleControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public PeopleControlException(String message) {
        super(message);
    }

    public PeopleControlException(Throwable cause) {
        super(cause);
    }
}
