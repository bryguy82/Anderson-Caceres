package view;

/**
 *
 * @author kanderson
 */
import java.io.IOException;

public class MainMenuView extends ViewStarter {

    public MainMenuView() {
        // empty constructor
    }

    @Override
    protected String getMessage() {
        return "Here we are at the Main Menu.\n\n"
                + "N - Start a New Game.\n"
                + "L - Load a Saved Game.\n"
                + "H - Get Help.\n"
                + "Q - Quit Game.\n";
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

        inputs[0] = getUserInput("So, what are you going to choose?").trim().toUpperCase();

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

        switch (inputs[0]) {
            case "N":
                startNewGame();
                break;
            case "L":
                loadSavedGame();
                break;
            case "H":
                helpMenu();
                break;
            case "Q":
                System.out.println("Thank you for playing. Come back soon!");
                return false;
            default:
                ErrorView.display(this.getClass().getName(), "Invaild selection.  Please try again.");
        }
        return true;
    }

    //Other actions go after this----- 
    private void startNewGame() throws IOException {
        pause(2000);
        View newGame = new NewGameView();
        newGame.displayView();
    }

    private void loadSavedGame() throws IOException {
        pause(2000);
        View savedGame = new StartExistingGameView();
        savedGame.displayView();
    }

    private void helpMenu() throws IOException {
        pause(2000);
        View helpMenu = new HelpMenuView();
        helpMenu.displayView();
    }
}
