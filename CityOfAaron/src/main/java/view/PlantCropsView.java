package view;

import app.CityOfAaron;
import control.LandControl;
import control.WheatControl;
import exception.WheatControlException;

import java.io.IOException;

/**
 *
 * @author tonyc
 */
public class PlantCropsView extends ViewStarter {

    public PlantCropsView() {
        // empty constructor
    }

    @Override
    protected String getMessage() {
        return "Now we are going to plant crops for the year.\n"
                + "P - Plant Crops\n";
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
            case "P":
                try {
                    plantCrops();
                } catch (WheatControlException gce) {
                    ErrorView.display(this.getClass().getName(), gce.getMessage());
                    return true;
                }
                return false;
            default:
                this.console.println("Invaild selection.  Please try again");
                break;
        }
        // return false if you want this view to exit and return
        // to the view that called it.
        return true;
    }

    //Other actions go after this----- 
    private boolean plantCrops() throws WheatControlException, IOException {

        int totalAcres = CityOfAaron.getCurrentGame().getAcresOwned();
        int wheatInStorage = CityOfAaron.getCurrentGame().getWheatInStorage();

        this.console.println("How many acres would you like to plant for next year's harvest?");
        String[] amountOfAcres = getInputs();
        int[] numericalAcres = new int[amountOfAcres.length];

        LandControl.stringToInt(amountOfAcres, numericalAcres);

        if (numericalAcres[0] < 0) {
            throw new WheatControlException("Please enter a positive value.");
        }

        if (numericalAcres[0] > totalAcres) {
            throw new WheatControlException("Sorry, you don't have enough land to plant that much.\n"
                    + "You have " + totalAcres + " to work with.");
        }

        if (numericalAcres[0] > (wheatInStorage * 2)) {
            throw new WheatControlException("Sorry, you don't have enough wheat to plant that much.\n"
                    + "You have " + wheatInStorage + " to use.\n"
                    + "Remember that you need 1 bushel for every 2 acres.\n");
        }

        //Calculate the number of bushels required to plant the crops.
        int bushelsNeededToPlant = numericalAcres[0] * 2;

        //Subtract this amount from the wheat in storage and display it.
        wheatInStorage -= bushelsNeededToPlant;
        this.console.println("The amount of wheat in storage after planting \n"
                + "is " + wheatInStorage);

        //Update game status to save how many acres have been planted.
        CityOfAaron.getCurrentGame().setAcresPlanted(numericalAcres[0]);
        CityOfAaron.getCurrentGame().setWheatInStorage(wheatInStorage);

        pause(2000);
        return false;
    }
}
