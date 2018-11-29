/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import app.CityOfAaron;
import control.GameControl;
import exception.GameControlException;

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
    public String[] getInputs() {

        // Declare the array to have the number of elements you intend to get 
        // from the user.
        String[] inputs = new String[1];

        inputs[0] = getUserInput("Please make a selection.");

        // Repeat for each input you need, putting it into its proper slot in the array.
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {

        switch (inputs[0].trim().toUpperCase()) {

            case "S":
                sellLand();
                return false;
            default:
                System.out.println("Invaild selection.  Please try again.");
                break;
        }
        return true;
    }

    private void sellLand() {

        int totalAcres = CityOfAaron.getCurrentGame().getAcresOwned();
        int wheatInStorage = CityOfAaron.getCurrentGame().getWheatInStorage();

        int raNum = 0;
        try {
            raNum= GameControl.getRandomNumber(17, 27);
        } catch(GameControlException gce) {
            System.out.println(gce.getMessage());
        }

        System.out.println("Okay. An Acre is worth $" + raNum + ". How many Acres will you sell?.\n");
        String[] amountOfAcresSold = getInputs();
        int[] numericalAcres = new int[amountOfAcresSold.length];

        for (int i = 0; i < numericalAcres.length; i++) {
            numericalAcres[i] = Integer.parseInt(amountOfAcresSold[i]);
        }
        if (numericalAcres[0] < 0) {
            System.out.println("Please enter a positive number.\n");
            return;
        }
        if (numericalAcres[0] > totalAcres) {
            System.out.println("You can't sell more than you own.\n");
            return;
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
