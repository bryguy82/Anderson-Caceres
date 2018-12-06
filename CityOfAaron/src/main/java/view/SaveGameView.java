package view;

import app.CityOfAaron;
import control.GameControl;
import java.io.FileOutputStream;

/**
 *
 * @author tonyc
 */
import java.io.IOException;
import java.io.ObjectOutputStream;
import model.Game;

public class SaveGameView extends ViewStarter {

    public SaveGameView() {
        // empty constructor
    }

    @Override
    protected String getMessage() {
        return "Ready to Save your Game?.\n"
                + "S - Save Game.\n"
                + "B - Back to Main Menu.\n";
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

        inputs[0] = getUserInput("Please select an option.");

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

            case "S":
                saveGameToFile();
                return false;
            default:
                this.console.println("Invaild selection.  Please try again");
                break;
        }
        return true;
    }

    public boolean saveGameToFile() throws IOException {

        Game game = CityOfAaron.getCurrentGame();
        this.console.println("Enter the filename: ");
        String[] file = getInputs();
        String filename = file[0] + ".txt";
        
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(game);

        } catch (IOException ioe) {
            ErrorView.display(this.getClass().getName(), ioe.getMessage());
        }
        return false;
    }

}
