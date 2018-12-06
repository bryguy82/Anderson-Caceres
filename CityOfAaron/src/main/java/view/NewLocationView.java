package view;

import app.CityOfAaron;
import model.Location;
import model.Point;
import model.Map;

import java.io.IOException;

/**
 *
 * @author tonyc
 */
public class NewLocationView extends ViewStarter {

    public NewLocationView() {
        // empty constructor
    }

    @Override
    protected String getMessage() {
        return "You are about to move to a New Location.\n"
                + "M - Move.\n"
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
        String[] inputs = new String[3];

        inputs[0] = getUserInput("Please select an option.");
        if (inputs[0].equals("m")) {
            inputs[1] = getUserInput("Now, enter a row number. (0-4)");
            inputs[2] = getUserInput("Next, enter a column number. (0-4)");
        }

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

        switch (inputs[0].trim().toUpperCase()) {

            case "M":
                moveToNewLocation(inputs);
                return false;
            case "B":
                mainMenu();
                return false;
            default:
                this.console.println("Invaild selection.  Please try again");
                break;
        }
        return true;
    }

    //Other actions go after this----- 
    private void mainMenu() {

    }

    private void moveToNewLocation(String[] inputs) throws NumberFormatException {

        Location[][] locations = CityOfAaron.getCurrentGame().getTheMap().getLocations();

        int row = Integer.parseInt(inputs[1]);
        int column = Integer.parseInt(inputs[2]);
        if (row > locations.length || column > locations[0].length) {
            throw new NumberFormatException("The number you chose was too large.");
        } else if (row < 0 || column < 0) {
            throw new NumberFormatException("Please select a positive value.");
        }
        Map map = CityOfAaron.getCurrentGame().getTheMap();
        Point point = new Point(row, column);
        map.setCurrentLocation(point);
//        Location[][] locations = CityOfAaron.getCurrentGame().getTheMap().getLocations();

        this.console.println("You have selected the numbers "
                + row + " " + column + " \n"
                + locations[row][column].getMapSymbol() + " "
                + locations[row][column].getName() + " "
                + locations[row][column].getDescription()
        );

        this.console.println("");
        pause(2000);
    }
}
