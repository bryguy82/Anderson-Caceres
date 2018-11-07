
package view;

import java.util.Scanner;

/**
 *
 * @author kanderson
 */
public class HelpMenuView {
    
    
    /**
     * The message that will be displayed by this view.
     */
    protected String message;
    
    /**
     * Constructor
     */
    public HelpMenuView(){
        
        message = "Welcome to the help menu, which includes a guideline to help you play the game.\n"
                +"W - What are the goals of the game?\n"
                +"H - Where is the city of Aaron?\n"
                +"M - How do I view the map?\n"
                +"L - How do I move to another location?\n" 
                +"D - How do I display a list of animals, provisions and tools in the city storehouse?\n" 
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
    
    
    /**
     * Perform the action indicated by the user's input.
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
     public boolean doAction(String[] inputs){
        
        switch(inputs[0].trim().toUpperCase()){
                        
            case "W":
                System.out.println("The goal of the game is to always have\n"
                        + "enough wheat to feed your people.  Remember to pay\n"
                        + "your tithing and to keep your people fed.  You'll\n"
                        + "need 20 bushels to feed 1 person.\n");
                break;
            case "H":
                System.out.println("If you'll look in Alma 8, Alma is teaching \n"
                        + "the people after giving up the judgement-seat unto \n"
                        + "Nephihah.  He was rejected in the city of Melek and\n"
                        + "was on his way to a city named Aaron (verse 13).\n"
                        + "Although an angel appeared and made him return, we\n"
                        + "play out what could have happened there.\n");
                break;
            case "M":
                System.out.println("To view the map, simply go to the Game Menu\n"
                        + "while you're playing to see it.\n");
                break;
            case "L":
                System.out.println("To change locations you'll first have to \n"
                        + "go to the Map View.  There you'll be able to select\n"
                        + "a row and a column number to travel to a new location.\n");
                break;
            case "D":
                System.out.println("A list of provisions can be viewed from the \n"
                        + "Reports Menu which appears after every game-year.\n");
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
    
    
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    
    
    private boolean someActionHandler(){
        
        //No actions necessary.  Only a display menu.

        return true;
    }
}
