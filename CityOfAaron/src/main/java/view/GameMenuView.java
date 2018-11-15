package view;

/**
 *
 * @author kanderson
 */
public class GameMenuView extends ViewStarter {

    public GameMenuView() {
        // empty constructor      
    }

    @Override
    protected String getMessage() {
        return "Welcome to the game menu!  What would you like to do?\n"
                + "V - View the map\n"
                + "L - Move to a new location\n"
                + "C - Manage the Crops\n"
                + "Y - Live the Year\n"
                + "R - Reports Menu \n"
                + "S - Save Game\n"
                + "Q - Return to the Main Menu\n";
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

        inputs[0] = getUserInput("Please make a selection.").trim().toUpperCase();

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

        switch (inputs[0]) {
            case ("V"):
                mapFunction();
                break;
            case ("L"):
                locationFunction();
                break;
            case ("C"):
                cropFunction();
                break;
            case ("Y"):
                yearFunction();
                break;
            case ("R"):
                reportFunction();
                break;
            case ("S"):
                saveFunction();
                break;
            case ("Q"):
                return false;
            default:
                System.out.println("Invaild selection.  Please try again.");
                break;
        }
        return true;
    }

    // Other actions go after this-----
    private void mapFunction() {
        pause(2000);
        View gameMap = new GameMapView();
        gameMap.displayView();
    }

    private void locationFunction() {
        // empty
    }

    private void cropFunction() {
        pause(2000);
        View manageCrops = new ManageCropsView();
        manageCrops.displayView();
    }

    private void yearFunction() {
        // empty
    }

    private void reportFunction() {
        View reportView = new ReportsMenuView();
        reportView.displayView();
    }

    private void saveFunction() {
        // empty
    }
}
