/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import app.CityOfAaron;
import control.GameControl;
import control.LandControl;
import exception.GameControlException;
import exception.LandControlException;
import exception.WheatControlException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tonyc
 */
public class BuyLandView extends ViewStarter {

    /**
     * Constructor
     */
    public BuyLandView() {

    }

    @Override
    protected String getMessage() {
        return "Please press B to buy land.\n"
                + "B - Buy Land\n";
    }

    @Override
    public String[] getInputs() throws IOException {

        // Declare the array to have the number of elements you intend to get 
        // from the user.
        String[] inputs = new String[1];

        inputs[0] = getUserInput("Please make a selection.");

        // Repeat for each input you need, putting it into its proper slot in the array.
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) throws IOException {

        switch (inputs[0].trim().toUpperCase()) {

            case "B":
                try {
                    buyLand();
                } catch (WheatControlException gce) {
                    ErrorView.display(this.getClass().getName(), gce.getMessage());
                    return true;
                }
                return false;
            default:
                ErrorView.display(this.getClass().getName(), "Invaild selection.  Please try again");
                break;
        }
        return true;
    }

    private void buyLand() throws WheatControlException, IOException {

        int totalAcres = CityOfAaron.getCurrentGame().getAcresOwned();
        int wheatInStorage = CityOfAaron.getCurrentGame().getWheatInStorage();
        int population = CityOfAaron.getCurrentGame().getCurrentPopulation();

        int raNum = 0;
        try {
            raNum = GameControl.getRandomNumber(17, 27);
        } catch (GameControlException mce) {
            ErrorView.display(this.getClass().getName(), mce.getMessage());
        }

        this.console.println("Okay. An Acre is worth $ " + raNum + ". How many Acres will you buy?.\n");
        String[] amountOfAcresBought = getInputs();
        int[] numericalAcres = new int[amountOfAcresBought.length];

        LandControl.stringToInt(amountOfAcresBought, numericalAcres);

        if (numericalAcres[0] < 0) {
            throw new WheatControlException("Please enter a positive value.");
        }

        /* Make sure that the player has enough wheat to make the purchase. If not, show a message
        and ask the user to enter the value again*/
        if (wheatInStorage < (numericalAcres[0] * raNum)) {
            throw new WheatControlException("You don't own that much wheat.\n");
        }

        /* Make sure that the city has enough people to tend the land. One person can take care of
        10 acres. If there are not enough people, show a message and ask the user to enter a
        different value.*/
        if (numericalAcres[0] > (population * 10)) {
            this.console.println("You don't have  enough people to take care of that\n"
                    + "much land.  Please enter a new value");
            return;
        }

        //Add the number of acres purchased to the acres owned
        totalAcres += numericalAcres[0];
        this.console.println("Your updated acreage is: " + totalAcres);
        CityOfAaron.getCurrentGame().setAcresOwned(totalAcres);

        //Subtract the wheat used to purchase the land from the wheat in storage
        wheatInStorage -= numericalAcres[0] * raNum;
        this.console.println("Your updated wheat in storage is: " + wheatInStorage);
        CityOfAaron.getCurrentGame().setWheatInStorage(wheatInStorage);

        pause(2000);
    }
}
