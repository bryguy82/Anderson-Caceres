package view;

import java.util.Scanner;

/**
 *
 * @author kanderson
 */
public class MainMenuView {

    /**
     * The message that will be displayed by this view.
     */
    protected String message;

    /**
     * Constructor
     */
    public MainMenuView() {

        message = "Here we are at the Main Menu.\n\n"
                + "N - Start a New Game.\n"
                + "L - Load a Saved Game.\n"
                + "H - Get Help.\n"
                + "R - Reports\n"//ONLY FOR TESTING!----------------------------
                + "M - Maps\n"//ONLY FOR TESTING!----------------------------
                + "Q - Quit Game.\n";
    }

    /**
     * Get the user's input. Keep prompting them until they enter a value.
     *
     * @param prompt
     * @param allowEmpty - determine whether the user can enter no value (just a
     * return key)
     * @return
     */
    protected String getUserInput(String prompt, boolean allowEmpty) {

        Scanner keyboard = new Scanner(System.in);
        String input = "";
        boolean inputReceived = false;

        while (inputReceived == false) {

            System.out.println(prompt);
            input = keyboard.nextLine();

            // Make sure we avoid a null-pointer error.
            if (input == null) {
                input = "";
            }

            // Trim any trailing whitespace, including the carriage return.
            input = input.trim();

            if (input.equals("") == false || allowEmpty == true) {
                inputReceived = true;
            }
        }

        return input;
    }

    /**
     * An overloaded version of getUserInput that sets allowEmpty to false so we
     * don't have to type it ourselves.
     *
     * @param prompt
     * @return
     */
    protected String getUserInput(String prompt) {
        return getUserInput(prompt, false);
    }

    /**
     * Get the set of inputs from the user.
     *
     * @return
     */
    public String[] getInputs() {

        // Declare the array to have the number of elements you intend to get 
        // from the user.
        String[] inputs = new String[1];

        inputs[0] = getUserInput("So, what are you going to choose?");

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
    public boolean doAction(String[] inputs) {

        switch (inputs[0].trim().toUpperCase()) {
            case "N":
                startNewGame();
                break;
            case "L":
                loadSavedGame();
                break;
            case "H":
                helpMenu();
                break;
            case "R"://ONLY FOR TESTING PURPOSES-----------------------------
                showReports();
                break;
            case "M"://ONLY FOR TESTING PURPOSES-----------------------------
                showMapView();
                break;
            case "Q":
                System.out.println("Thank you for playing. Come back soon!");
                return false;
            default:
                System.out.println("Invaild selection.  Please try again.");
        }
        return true;
    }

    /**
     * Control this view's display/prompt/action loop until the user chooses and
     * action that causes this view to close.
     */
    public void displayView() {

        boolean keepGoing = true;

        while (keepGoing == true) {

            System.out.println(message);
            String[] inputs = getInputs();
            keepGoing = doAction(inputs);
        }
    }

    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    private void startNewGame() {
        NewGameView view = new NewGameView();
        view.displayView();
    }

    private void loadSavedGame() {
        StartExistingGameView savedGame = new StartExistingGameView();
        savedGame.displayView();
    }

    private void helpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.displayView();
    }

    //ONLY FOR TESTING PURPOSES!!!------------------------------------------
    private void showReports() {
        ReportsMenuView reportMenu = new ReportsMenuView();
        reportMenu.displayView();
    }

    private void showMapView() {
        GameMapView mapView = new GameMapView();
        mapView.displayView();

    }
}
