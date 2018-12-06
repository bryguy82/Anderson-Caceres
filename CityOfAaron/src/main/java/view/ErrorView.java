package view;

import app.CityOfAaron;

import model.Game;

import control.GameControl;
import java.io.PrintWriter;

/**
 *
 * @author kanderson
 */
public class ErrorView extends ViewStarter {
    
    public static PrintWriter console = CityOfAaron.getOutFile();
    public static PrintWriter log = CityOfAaron.getLogFile(); 

    public ErrorView() {
        // empty constructor        
    }
    
    
    public static void display(String className, String errorMessage){
        console.println("\n-----------------ERROR-------------"
                + "\n"+errorMessage
                +"\n-------------------");
        log.printf("%n%n%s",className+" - "+errorMessage);
    }

    @Override
    protected String getMessage() {
        return "";
    }

    /**
     * Get the set of inputs from the user.
     *
     * @return
     */
    @Override
    public String[] getInputs() {
        return null;
    }

    /**
     * Perform the action indicated by the user's input.
     *
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    @Override
    public boolean doAction(String[] inputs) {

        //Output errors here
        return false;
    }

}
