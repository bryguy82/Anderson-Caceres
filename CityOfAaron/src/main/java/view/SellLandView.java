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
import exception.WheatControlException;

import java.io.IOException;

/**
 *
 * @author tonyc
 */
public class SellLandView extends ViewStarter {

    /**
     * Constructor
     */
    public SellLandView() {

    }

    @Override
    protected String getMessage() {
        return "Please press S to sell land.\n"
                + "S - Sell Land\n";
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

            case "S":
                try {
                    sellLand();
                } catch (WheatControlException gce) {
                    ErrorView.display(this.getClass().getName(),gce.getMessage());
                    return true;
                }
                return false;
            default:
                ErrorView.display(this.getClass().getName(),"Invaild selection.  Please try again.");
                break;
        }
        return true;
    }

    private void sellLand() throws WheatControlException, IOException {

        int totalAcres = CityOfAaron.getCurrentGame().getAcresOwned();
        int wheatInStorage = CityOfAaron.getCurrentGame().getWheatInStorage();

        int raNum = 0;
        try {
            raNum = GameControl.getRandomNumber(17, 27);
        } catch (GameControlException gce) {
            ErrorView.display(this.getClass().getName(),gce.getMessage());
        }

        System.out.println("Okay. An Acre is worth $" + raNum + ". How many Acres will you sell?.\n");
        String[] amountOfAcresSold = getInputs();
        int[] numericalAcres = new int[amountOfAcresSold.length];

        LandControl.stringToInt(amountOfAcresSold, numericalAcres);

        if (numericalAcres[0] < 0) {
            throw new WheatControlException("Please enter a positive value.");
        }

        if (numericalAcres[0] > totalAcres) {
            throw new WheatControlException("You can't sell more than you own.\n");
        }

        totalAcres -= numericalAcres[0];
        System.out.println("Your updated acreage is: " + totalAcres);
        CityOfAaron.getCurrentGame().setAcresOwned(totalAcres);

        wheatInStorage += numericalAcres[0] * raNum;
        System.out.println("Your updated wheat in storage is: " + wheatInStorage);
        CityOfAaron.getCurrentGame().setWheatInStorage(wheatInStorage);

        pause(2000);
    }
}
