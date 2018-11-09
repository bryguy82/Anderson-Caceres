/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.GameControl;
import java.util.Scanner;

/**
 *
 * @author tonyc
 */
public class SellLandView {

    /**
     * The message that will be displayed by this view.
     */
    protected String message;

    /**
     * Constructor
     */
    public SellLandView() {

        message = "Please select an option.\n"
                + "S - Sell Land\n"
                + "C - Continue playing";
    }

    /**
     * Get the user's input. Keep prompting them until they enter a value.
     *
     * @param prompt
     * @param allowEmpty - determine whether the user can enter no value (just a
     * return key)
     * @return
     */
    protected String getUserInput(String prompt, boolean allowEmpty) {

        Scanner keyboard = new Scanner(System.in);
        String input = "";
        boolean inputReceived = false;

        while (inputReceived == false) {

            System.out.println(prompt);
            input = keyboard.nextLine();

            // Make sure we avoid a null-pointer error.
            if (input == null) {
                input = "";
            }

            // Trim any trailing whitespace, including the carriage return.
            input = input.trim();

            if (input.equals("") == false || allowEmpty == true) {
                inputReceived = true;
            }
        }

        return input;
    }

    /**
     * An overloaded version of getUserInput that sets allowEmpty to false so we
     * don't have to type it ourselves.
     *
     * @param prompt
     * @return
     */
    protected String getUserInput(String prompt) {
        return getUserInput(prompt, false);
    }

    /**
     * Get the set of inputs from the user.
     *
     * @return
     */
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
    public boolean doAction(String[] inputs) {

        switch (inputs[0].trim().toUpperCase()) {

            case "S":
                sellLand();
                break;
            case "B":
                //"false" takes us to the main menu
                return false;
        }
        return true;
    }

    /**
     * Control this view's display/prompt/action loop until the user chooses and
     * action that causes this view to close.
     */
    public void displayView() {

        boolean keepGoing = true;

        while (keepGoing == true) {

            System.out.println(message);
            String[] inputs = getInputs();
            keepGoing = doAction(inputs);
        }
    }


    private void sellLand() {                 
        int totalAcres = 1000;//a starting value for testing.
        int wheatInStorage = 2000;//a starting value for testing.
        int raNum = GameControl.getRandomNumber(17, 27);
        System.out.println("Okay. An Acre is worth $" + raNum + ". How many Acres will you sell?.\n");
        String[] amountOfAcresSold = getInputs();
        int[] numericalAcres = new int[amountOfAcresSold.length];
        
        for (int i = 0; i < numericalAcres.length; i++){
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
        wheatInStorage += numericalAcres[0] * raNum;
        System.out.println("Your updated wheat in storage is: " + wheatInStorage);
    }
}
