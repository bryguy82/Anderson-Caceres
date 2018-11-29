package view;

import app.CityOfAaron;
import control.WheatControl;

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
    public String[] getInputs() {

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
    public boolean doAction(String[] inputs) {

        switch (inputs[0].trim().toUpperCase()) {
            case "P":
                plantCrops();
                return false;
            default:
                System.out.println("Invaild selection.  Please try again.");
                break;
        }
        // return false if you want this view to exit and return
        // to the view that called it.
        return true;
    }

    //Other actions go after this----- 
    private boolean plantCrops() {

        int totalAcres = CityOfAaron.getCurrentGame().getAcresOwned();
        int wheatInStorage = CityOfAaron.getCurrentGame().getWheatInStorage();

        System.out.println("How many acres would you like to plant for next year's harvest?");
        String[] amountOfAcres = getInputs();
        int[] numericalAcres = new int[amountOfAcres.length];

        for (int i = 0; i < numericalAcres.length; i++) {
            numericalAcres[i] = Integer.parseInt(amountOfAcres[i]);
        }

        if (numericalAcres[0] < 0) {
            System.out.println("Please enter a positive value.");
            return true;
        }

        if (numericalAcres[0] > totalAcres) {
            System.out.println("Sorry, you don't have enough land to plant that much.\n"
                    + "You have " + totalAcres + " to work with.");
            return true;
        }

        if (numericalAcres[0] > (wheatInStorage * 2)) {
            System.out.println("Sorry, you don't have enough wheat to plant that much.\n"
                    + "You have " + wheatInStorage + " to use.\n"
                    + "Remember that you need 1 bushel for every 2 acres.");
            return true;
        }

        //Calculate the number of bushels required to plant the crops.
        int bushelsNeededToPlant = numericalAcres[0] * 2;

        //Subtract this amount from the wheat in storage and display it.
        wheatInStorage -= bushelsNeededToPlant;
        System.out.println("The amount of wheat in storage after planting \n"
                + "is " + wheatInStorage);

        //Update game status to save how many acres have been planted.
        CityOfAaron.getCurrentGame().setAcresPlanted(numericalAcres[0]);
        CityOfAaron.getCurrentGame().setWheatInStorage(wheatInStorage);

        pause(2000);
        return false;
    }
}
