/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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
    protected String getMessage(){
        return "Please select an option.\n"
                + "B - Buy Land\n"
                + "C - Continue playing";
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
                break;
            case "C":
                //"false" takes us to the main menu
                return false;
        }
        return true;
    }

    private void buyLand() {
        
        int totalAcres = 1000;//a starting value for testing.
        int wheatInStorage = 2000;//a starting value for testing.
        int raNum = GameControl.getRandomNumber(17, 27);
        int updatedWheatInStorage=1000;
        
        System.out.println("Okay. An Acre is worth $" + raNum + ". How many Acres will you buy?.\n");
        String[] amountOfAcresBought = getInputs();
        int[] numericalAcres = new int[amountOfAcresBought.length];
        
        for (int i = 0; i < numericalAcres.length; i++){
            numericalAcres[i] = Integer.parseInt(amountOfAcresBought[i]);
        }
        
        if (numericalAcres[0] < 0) {
            System.out.println("Please enter a positive number.\n");
            return;
        }
        
        updatedWheatInStorage -= numericalAcres[0] * raNum;
        
        if (wheatInStorage < updatedWheatInStorage) {
            System.out.println("You don't own that much wheat.\n");
            return;
        }
        
        totalAcres += numericalAcres[0];
        System.out.println("Your updated acreage is: " + totalAcres);
        wheatInStorage -= numericalAcres[0] * raNum;
        System.out.println("Your updated wheat in storage is: " + wheatInStorage);
    }
}
