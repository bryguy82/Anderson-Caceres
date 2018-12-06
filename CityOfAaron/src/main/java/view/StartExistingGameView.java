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
        return "Let's load that game you've worked so hard on.\n"
                + "L - Load game.\n"
                + "B - Back to the main menu.\n";
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

            case "L":
                loadGameFromFile();
                return false;
            case "B":
                return false;
            default:
                this.console.println("Invaild selection.  Please try again");
                break;
        }
        return true;
    }

    //Other actions go after this-----
    public boolean loadGameFromFile() throws IOException {

        Game game = null;
        this.console.println("Enter your file's name: ");
        String[] file = getInputs();
        String filename = file[0] + ".txt";

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            game = (Game) in.readObject();

            CityOfAaron.setCurrentGame(game);
            this.console.println("Your game is now loaded.");
            GameMenuView gameMenu = new GameMenuView();
            gameMenu.displayView();

        } catch (IOException ioe) {
            ErrorView.display(this.getClass().getName(), ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            ErrorView.display(this.getClass().getName(), cnfe.getMessage());
        }
        return false;
    }
}
