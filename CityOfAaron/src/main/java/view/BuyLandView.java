/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.GameControl;
import java.util.Random;
import java.util.Scanner;
import control.LandControl;
/**
 *
 * @author tonyc
 */
public class BuyLandView {
    
    /**
     * The message that will be displayed by this view.
     */
    protected String message;
    
    /**
     * Constructor
     */
    public BuyLandView(){
        
        message = "Please select an option.\n"
                +"N - Buy Land\n"
                +"B - Back to the Main Menu.";                
    }
    
    /**
     * Get the user's input. Keep prompting them until they enter a value.
     * @param prompt
     * @param allowEmpty - determine whether the user can enter no value (just a return key)
     * @return 
     */
    protected String getUserInput(String prompt, boolean allowEmpty){
        
        Scanner keyboard = new Scanner(System.in);
        String input = "";
        boolean inputReceived = false;
        
        while(inputReceived == false){
            
            System.out.println(prompt);
            input = keyboard.nextLine();
            
            // Make sure we avoid a null-pointer error.
            if (input == null){
                input = "";
            }
            
            // Trim any trailing whitespace, including the carriage return.
            input = input.trim();
            
            if (input.equals("") == false || allowEmpty == true){
                inputReceived = true;
            }
        }
        
        return input;
    }
    
    
    /**
     * An overloaded version of getUserInput that sets allowEmpty to false so we don't have 
     * to type it ourselves.
     * @param prompt
     * @return 
     */
    protected String getUserInput(String prompt){
        return getUserInput(prompt, false);
    }
    
    /**
     * Get the set of inputs from the user.
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
    
    
    private static final Random randomGenerator = new Random(0);

    // Generate a random number with some "random" seed. 
    // This is how you will do it in your actual game code.
    // Random randomGenerator = new Random(System.currentTimeMillis());
    /**
     * protected setter for testing
     *
     * @param random
     */
    protected static void setRandomGenerator(Random random) {
        System.out.println(GameControl.randomGenerator = random);
    }
    
    public static int getRandomNumber(int lowValue, int highValue) {

        //if low & high < 0 return -1
        if (lowValue < 0 || highValue < 0) {
            return -1;
        }

        //if high <= low return -2
        if (highValue <= lowValue) {
            return -2;
        }

        //if high is the MAX_VALUE, return -3
        if (highValue == Integer.MAX_VALUE) {
            return -3;
        }

        //calculate the range size; +1 to include high
        int range = (highValue - lowValue) + 1;

        //return low + range for the possible values
        return lowValue + randomGenerator.nextInt(range);

    }
    
    /**
     * Perform the action indicated by the user's input.
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
     public boolean doAction(String[] inputs){
        
        switch(inputs[0].trim().toUpperCase()){
                        
            case "N":
                getAmountOfAcres();
                break;
                
            case "B":
               //"false" takes us to the main menu
               return false;
        }
        return true;
    }
    
    
    /**
     * Control this view's display/prompt/action loop until the user
     * chooses and action that causes this view to close.
     */
    public void displayView(){
        
        boolean keepGoing = true;
        
        while(keepGoing == true){
            
            System.out.println(message);
            String[] inputs = getInputs();
            keepGoing = doAction(inputs);
        }
    }
    
    public void getAmountOfAcres(){
        
        int amountOfAcresOwned = 1000;
        //int amountOfAcresOwned;
        //LandControl acresOwned = new LandControl();
        //amountOfAcresOwned = Integer.parparseInt(acresOwned.getAmountOfAcres());
        
        int ranum = getRandomNumber(17,27);
        
        int totalAcres;
        
        Scanner keyboard = new Scanner(System.in);
        int amountOfAcresBought;
        System.out.println("Great! Time to make an investment. An Acre is worth $"+ ranum + ". How many Acres will you buy?.\n");
        
        amountOfAcresBought = keyboard.nextInt();
                
        totalAcres = amountOfAcresBought+amountOfAcresOwned;
        
        System.out.println(
                "Acres Owned:"+amountOfAcresOwned+"\n"
                +"Acres Bought:"+amountOfAcresBought+"\n"
                +"Total Acres:"+totalAcres+"\n");
    }
    
    // Define your action handlers here. These are the methods that your doAction()
    // method will ncall based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    
    
    //private boolean someActionHandler(){
        
        //No actions necessary.  Only a display menu.

    //    return true;
    //}
    
}
