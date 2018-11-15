/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import app.CityOfAaron;
import control.GameControl;

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

            case "B":
                buyLand();
                return false;
            default:
                System.out.println("Invaild selection.  Please try again.");
                break;
        }
        return true;
    }

    private void buyLand() {

        int totalAcres = 1000;//a starting value for testing.
        //int totalAcres = CityOfAaron.getCurrentGame().getAcresOwned();
        int wheatInStorage = 2000;//a starting value for testing.
        //int wheatInStorage = CityOfAaron.getCurrentGame().getWheatInStorage();
        //int population = CityOfAaron.getCurrentGame().getCurrentPopulation();
        int population = 100; //a starting value for testing.
        int raNum = GameControl.getRandomNumber(17, 27);
        //int updatedWheatInStorage = 1000;

        System.out.println("Okay. An Acre is worth $" + raNum + ". How many Acres will you buy?.\n");
        String[] amountOfAcresBought = getInputs();
        int[] numericalAcres = new int[amountOfAcresBought.length];

        for (int i = 0; i < numericalAcres.length; i++) {
            numericalAcres[i] = Integer.parseInt(amountOfAcresBought[i]);
        }

        if (numericalAcres[0] < 0) {
            System.out.println("Please enter a positive number.\n");
            return;
        }

        /* Make sure that the player has enough wheat to make the purchase. If not, show a message
        and ask the user to enter the value again*/
        if (wheatInStorage < (numericalAcres[0] * raNum)) {
            System.out.println("You don't own that much wheat.\n");
            return;
        }

        /* Make sure that the city has enough people to tend the land. One person can take care of
        10 acres. If there are not enough people, show a message and ask the user to enter a
        different value.*/
        if (numericalAcres[0] > (population * 10)) {
            System.out.println("You don't have enough people to take care of that\n"
                    + "much land.  Please enter a new value");
            return;
        }

        //Add the number of acres purchased to the acres owned
        totalAcres += numericalAcres[0];
        System.out.println("Your updated acreage is: " + totalAcres);
        //CityOfAaron.getCurrentGame().setAcresOwned(totalAcres);

        //Subtract the wheat used to purchase the land from the wheat in storage
        wheatInStorage -= numericalAcres[0] * raNum;
        System.out.println("Your updated wheat in storage is: " + wheatInStorage);
        //CityOfAaron.getCurrentGame().setWheatInStorage(wheatInStorage);

        pause(2000);
    }
}
