package view;

import app.CityOfAaron;
import control.LandControl;
import exception.WheatControlException;

import java.io.IOException;

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
        return "You will have to decide how much food you'll give to the people.\n"
                + "F - Feed the people\n";
    }

    /**
     * Get the set of inputs from the user.
     *
     * @return
     */
    @Override
    public String[] getInputs() throws IOException {

        // Declare the array to have the number of elements you intend to get 
        // from the user.
        String[] inputs = new String[1];

        inputs[0] = getUserInput("Please make a selection.");

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
    public boolean doAction(String[] inputs) throws IOException {

        switch (inputs[0].trim().toUpperCase()) {
            case "F":
                try {
                    feedThePeople();
                } catch (WheatControlException gce) {
                    ErrorView.display(this.getClass().getName(), gce.getMessage());
                    return true;
                }
                return false;
            default:
                ErrorView.display(this.getClass().getName(), "Invaild selection.  Please try again.");
                break;
        }
        // return false if you want this view to exit and return
        // to the view that called it.

        return true;
    }

    //Other actions go after this----- 
    private boolean feedThePeople() throws WheatControlException, IOException {

        int wheatInStorage = CityOfAaron.getCurrentGame().getWheatInStorage();

        this.console.println("How many many bushels of wheat will you give to the people\n"
                + "so they can eat?");

        String[] bushelsForThePeople = getInputs();
        int[] numericalBushels = new int[bushelsForThePeople.length];

        LandControl.stringToInt(bushelsForThePeople, numericalBushels);

        if (numericalBushels[0] < 0) {
            throw new WheatControlException("Please enter a positive value.");
        }

        if (numericalBushels[0] > wheatInStorage) {
            throw new WheatControlException("You don't have that many bushels.\n");
        }

        // Subtract the entered amount from the wheat in storage. Display what's left.
        this.console.println("You have chosen to set aside " + numericalBushels[0] + " bushels.");

        CityOfAaron.getCurrentGame().setBushelsToFeedThePeople(numericalBushels[0]);
        pause(2000);

        return false;
    }

}
