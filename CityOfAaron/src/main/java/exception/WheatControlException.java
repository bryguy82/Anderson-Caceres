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
public class WheatControlException extends Exception {
    
    public WheatControlException() {
        // empty contructor
    }
    
    public WheatControlException(String message, Throwable cause, boolean enableSuppression, boolean writeableStackTrace) {
        super(message, cause, enableSuppression, writeableStackTrace);
    }

    public WheatControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public WheatControlException(String message) {
        super(message);
    }

    public WheatControlException(Throwable cause) {
        super(cause);
    }
}
