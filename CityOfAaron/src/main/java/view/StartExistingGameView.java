package view;

import app.CityOfAaron;
import model.Game;
import control.GameControl;
//import model.Player;

import java.io.IOException;

/**
 *
 * @author banderson
 */
public class StartExistingGameView extends ViewStarter {

    public StartExistingGameView() {
        // empty constructor
    }

    @Override
    protected String getMessage() {
        return "Let's load that game you've worked so hard on.\n";
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

        inputs[0] = getUserInput("Where is the game you would like to load?");

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

        // return false if you want this view to exit and return
        // to the view that called it.
        //TODO No errors, but does this work???  Filename info to come
        String[] filename = getInputs();
        String file = filename[0] + ".txt";
        loadGameFromFile(CityOfAaron.currentGame, file);

        if (true) {
            ErrorView.display(this.getClass().getName(), "Sorry your file couldn't be loaded.");
        }

        return false;
    }

    //Other actions go after this-----
    public static boolean loadGameFromFile(Game game, String filename) {

        //Load Game method
        //Need a boolean to check if it didn't load
        //False means it was successful.
        // Try & Catch when we know how to load a file...!
        System.out.println("The load game option will be implemented later.");
        return false;
    }
}
