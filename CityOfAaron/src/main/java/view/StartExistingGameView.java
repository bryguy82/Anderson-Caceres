
package view;

/**
 *
 * @author kanderson
 */
public class StartExistingGameView extends ViewStarter {
    
    public StartExistingGameView(){
        // empty constructor
    }
    
    @Override
    protected String getMessage() {
        return "This is the message that is printed to the user by this view.\n"
                + "You have three tasks:\n"
                + "1 - Replace this message text with the text that is specific to your view.\n"
                + "2 - Replace this list with menu options that are specific to your view.\n"
                + "3 - Prompt the user for what they are expected to enter.\n";
    }
    
    /**
     * Get the set of inputs from the user.
     * @return 
     */
    @Override
    public String[] getInputs() {
        
        // Declare the array to have the number of elements you intend to get 
        // from the user.
        String[] inputs = new String[1];
        
        inputs[0] = getUserInput("Change this text to prompt the user for the input.");
        
        // Repeat for each input you need, putting it into its proper slot in the array.
        
        return inputs;
    }
    
    /**
     * Perform the action indicated by the user's input.
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    @Override
    public boolean doAction(String[] inputs){

        // return false if you want this view to exit and return
        // to the view that called it.
        
        return true;
    }
    
    //Other actions go after this----- 
    
}
