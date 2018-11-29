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
public class GameControlException extends Exception {

    public GameControlException() {
        // empty constructor
    }

    public GameControlException(String message, Throwable cause, boolean enableSuppression, boolean writeableStackTrace) {
        super(message, cause, enableSuppression, writeableStackTrace);
    }

    public GameControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public GameControlException(String message) {
        super(message);
    }

    public GameControlException(Throwable cause) {
        super(cause);
    }
}
