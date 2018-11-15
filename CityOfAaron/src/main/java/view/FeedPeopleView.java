package view;

/**
 *
 * @author tonyc
 */
public class FeedPeopleView extends ViewStarter {

    public FeedPeopleView() {
        // empty constructor
    }

    @Override
    protected String getMessage() {
        return "How many bushels of wheat do you want to use to the people?\n"
                + "You have x amount of bushels.";
    }

    /**
     * Get the set of inputs from the user.
     *
     * @return
     */
    @Override
    public String[] getInputs() {

        // Declare the array to have the number of elements you intend to get 
        // from the user.
        String[] inputs = new String[1];

        inputs[0] = getUserInput("Enter the amount here.");

        // Repeat for each input you need, putting it into its proper slot in the array.
        return inputs;
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

        // return false if you want this view to exit and return
        // to the view that called it.
        
        feedThePeople();
        
        return true;
    }

    //Other actions go after this----- 
        
    private void feedThePeople() {
       /* 1. Ask the user “How many bushels of grain do you want to give to the people?”
        2. User enters a value.
        3. Check to make sure that the value is positive. If it is not, show a message and ask the user
        to enter the value again.
        4. Make sure that the city has this much wheat in storage. If not, show a message and ask the
        user to enter the value again.
        5. Subtract this amount from the wheat in storage. Display the amount of wheat you have left.
        6. Update the game state to save how many bushels of wheat you have set aside to feed the
        people. */
        
       
        
    }

}
