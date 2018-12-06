package view;

import app.CityOfAaron;
import control.GameControl;
import exception.GameControlException;
import exception.PeopleControlException;
import exception.WheatControlException;
import model.Game;
import model.Location;
import model.Point;

import java.io.IOException;

/**
 *
 * @author tonyc
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
    public String[] getInputs() throws IOException {

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
    public boolean doAction(String[] inputs) throws IOException {

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
                try {
                    yearFunction();
                } catch (GameControlException | WheatControlException | PeopleControlException ce) {
                    ErrorView.display(this.getClass().getName(), ce.getMessage());
                }
                if (CityOfAaron.getCurrentGame().getBushelsPaidInTithing() == 10) {
                    return false;
                }
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
                this.console.println("Invaild selection.  Please try again");
                break;
        }
        return true;
    }

    // Other actions go after this-----
    private void mapFunction() throws IOException {
        pause(2000);
        View gameMap = new GameMapView();
        gameMap.displayView();
    }

    private void locationFunction() throws IOException {
        pause(2000);
        showCurrentLocation();
        View newLocation = new NewLocationView();
        newLocation.displayView();
    }

    private void cropFunction() throws IOException {
        pause(2000);
        View manageCrops = new ManageCropsView();
        manageCrops.displayView();
    }

    private void yearFunction() throws GameControlException, PeopleControlException, WheatControlException, IOException {
        // This method can have issues with these control classes

        Game game = CityOfAaron.getCurrentGame();
        int previousPopulation = game.getCurrentPopulation();

        GameControl.liveTheYear(game);

        AnnualReportView annualReport = new AnnualReportView();
        annualReport.displayView();

        pause(2000);

        if (previousPopulation / 2 >= game.getCurrentPopulation()) {
            this.console.println("Sorry, you haven't managed your wheat well.\n"
                    + "Too many villagers have died of starvation.");
            EndGameView endGame = new EndGameView();
            endGame.displayView();
            CityOfAaron.getCurrentGame().setBushelsPaidInTithing(10); // control variable
        }

        if (game.getYearNumber() == 10) {
            this.console.println("Congratulations.  You have made it to year 10.\n"
                    + "You have completed the game.  Please come back and play again soon.");
            EndGameView endGame = new EndGameView();
            endGame.displayView();
            CityOfAaron.getCurrentGame().setBushelsPaidInTithing(10); // control variable
        }
    }

    private void reportFunction() throws IOException {
        pause(2000);
        View reportView = new ReportsMenuView();
        reportView.displayView();
    }

    private void saveFunction() throws IOException {
        pause(2000);
        View saveGame = new SaveGameView();
        saveGame.displayView();
    }

    private void showCurrentLocation() {
        pause(2000);
        Point point = CityOfAaron.getCurrentGame().getTheMap().getCurrentLocation();

        Location[][] location = CityOfAaron.getCurrentGame().getTheMap().getLocations();
        String name = location[point.getRow()][point.getColumn()].getName();

        this.console.println("You are currently located at " + name + " ["
                + point.getRow() + "] [" + point.getColumn() + "]\n");
    }
}
