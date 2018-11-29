package view;

import app.CityOfAaron;
import control.GameControl;
import model.Game;
import model.Location;
import model.Point;

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
        pause(2000);
        showCurrentLocation();
        View newLocation = new NewLocationView();
        newLocation.displayView();
    }

    private void cropFunction() {
        pause(2000);
        View manageCrops = new ManageCropsView();
        manageCrops.displayView();
    }

    private void yearFunction() {
        Game game = CityOfAaron.getCurrentGame();
        int previousPopulation = game.getCurrentPopulation();

        GameControl.liveTheYear(game);

        System.out.println("You made it to year " + game.getYearNumber() + ".  Congrats!");
        System.out.println("Unfortunately, " + game.getPeopleStarved() + " people starved.");
        System.out.println("You're city is famous.  " + game.getPeopleMovedIn() + " people moved in.");
        System.out.println("Now your city now has " + game.getCurrentPopulation() + " people.");
        System.out.println("You have " + game.getAcresOwned() + " total acres.");
        System.out.println("This year's harvest yielded " + game.getBushelsHavestedPerAcre() + " per acre.");
        System.out.println("The total harvest produced " + game.getTotalBushelsHarvested() + " bushels.");////
        System.out.println("You paid " + game.getBushelsPaidInTithing() + " bushels in tithing.");
        System.out.println("You lost " + game.getBushelsEatenByRats() + " bushels due to hungry rats.");
        System.out.println("Your updated wheat total is " + game.getWheatInStorage() + ".\n");

        pause(2000);

        if (previousPopulation / 2 >= game.getCurrentPopulation()) {
            // end the game.
        }
    }

    private void reportFunction() {
        pause(2000);
        View reportView = new ReportsMenuView();
        reportView.displayView();
    }

    private void saveFunction() {
        pause(2000);
        View saveGame = new SaveGameView();
        saveGame.displayView();
    }

    private void showCurrentLocation() {
        pause(2000);
        Point point = CityOfAaron.getCurrentGame().getTheMap().getCurrentLocation();

        Location[][] location = CityOfAaron.getCurrentGame().getTheMap().getLocations();
        String name = location[point.getRow()][point.getColumn()].getName();

        System.out.println("You are currently located at " + name + " ["
                + point.getRow() + "] [" + point.getColumn() + "]\n");
    }
}
