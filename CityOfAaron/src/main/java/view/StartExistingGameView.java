package view;

import app.CityOfAaron;
import model.Game;
import control.GameControl;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

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

        loadGameFromFile();

        if (true) {
            ErrorView.display(this.getClass().getName(), "Sorry your file couldn't be loaded.");
        }

        return false;
    }

    //Other actions go after this-----
    public boolean loadGameFromFile() throws IOException {

        Game game = null;
        this.console.println("Enter your file's name: ");
        String[] file = getInputs();
        String filename = file[0] + ".txt";
        
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            //game = (Game)in.readObject();

        } catch (IOException ioe) {
            ErrorView.display(this.getClass().getName(), ioe.getMessage());
        }
        
        System.out.println("The load game option will be implemented later.");
        return false;
    }
}
