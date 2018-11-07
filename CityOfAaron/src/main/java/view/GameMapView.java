
package view;

import java.util.Scanner;

/**
 *
 * @author kanderson
 */
public class GameMapView {
    
    /**
     * STUFF TO MODIFY
     * displayGameMenuView()
     */
    
    /**
     * The message that will be displayed by this view.
     */
    protected String message;
    
    /**
     * Constructor
     */
    public GameMapView(){
        
        message = "Here's the map around the City of Aaron\n"
                + "[V][V][W][R][U]\n"
                + "[S][U][V][R][W]\n"
                + "[U][C][T][V][R]\n"
                + "[W][U][V][R][L]\n"
                + "[W][U][R][L][W]\n\n"
                + "C - The Ruler's Court\n"
                + "L - The border of the Lamanites land\n"
                + "R - River\n"
                + "S - The City's Granary and Storehouse\n"
                + "T - The Temple\n"
                + "U - Undeveloped Land\n"
                + "V - The village\n"
                + "W - Wheat Field\n"
                + "X - Exit Map View";
                
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
        
        inputs[0] = getUserInput("Which item would you like to know more about?");
        
        // Repeat for each input you need, putting it into its proper slot in the array.
        
        return inputs;
    }
    
    
    /**
     * Perform the action indicated by the user's input.
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    public boolean doAction(String[] inputs){
        // Act on the user's input.
        
        switch(inputs[0].trim().toUpperCase()){ 
            case "C":
                System.out.println("Welcome to the Ruler's court.  So far\n"
                        + "you have done a decent job of feeding the people.\n");
                break;
            case "L":
                System.out.println("You are in the borders near the Lamanites.\n"
                        + "Let's hope they're the righteous kind!\n");
                break;
            case "R":
                System.out.println("You've landed near a river.  The water here\n"
                        + "is fresh and clean.  Have you been drinking enough\n"
                        + "water to stay hidrated?\n");
                break;
            case "S":
                System.out.println("Welcome to the city's Granary and Storehouse.\n"
                        + "Remember that winning the game relies on keeping this\n"
                        + "filled enough to feed your people.\n"
                        + "Wait.  What was that?\n"
                        + "Was that a rat??\n");
                break;
            case "T":
                System.out.println("Did you know the Nephites built temples?\n"
                        + "That's right.  You can read more about it in the \n"
                        + "Book of Mormon in 2 Nephi 5:16.\n"
                        + "Did you remember to pay your tithing?\n");
                break;
            case "U":
                System.out.println("I'm sorry, there isn't anthing located at\n"
                        + "this location.  You've selected Undeveloped Land.\n");
                break;
            case "V":
                System.out.println("What a great ruler you are.  You have come\n"
                        + "to visit your people.  Let's just hope they aren't\n"
                        + "mad about you starving people to death.\n");
                break;
            case "W":
                System.out.println("Great choice!  These wheat fields are so\n"
                        + "beautiful to gaze upon.  Remember that you need 20\n"
                        + "bushels to feed 1 person in a year.");
                break;    
            case "X":
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
    
    
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    
    
    /*private boolean someActionHandler(){
        // Define whatever code you need here to accomplish the action.
        // You can make this a void method if you want. Whatever you need 
        // here, you are free to do.
        //
        // Generally, though, this is where you will call into your Control
        // classes to do the work of the application.
        
        return true;
    }*/
}
