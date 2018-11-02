
package view;

import java.util.Scanner;


/**
 *
 * @author kanderson
 */
public class StartProgramView {
    
    
    /**
     * The message that will be displayed by this view.
     */
    protected String message;
    
    /** 
     * STUFF TO MODIFY
     * displayStartProgramView()
     * getInputs()
     * doAction()
     */
    
    /**
     * Constructor
     */
    public StartProgramView(){
        
        message = "Welcome to the city of Aaron. You have been summoned here by the High Priest to assume\n" 
                +"your role as ruler of the city. Your responsibility is to buy and sell land, determine how much\n" 
                +"wheat to plant each year and how much to set aside to feed your people. In addition, it will be\n" 
                +"your job to pay an annual tithe on the wheat that is harvested. If you fail to provide enough\n" 
                +"wheat for the people, people will starve, some people will die, and your workforce will be\n" 
                +"diminished. Plan carefully. And Oh, there is always a danger of rats eating your wheat.";
                
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
        
        return null;
    }
    
    
    /**
     * Perform the action indicated by the user's input.
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    public boolean doAction(String[] inputs){
        // Act on the user's input.
        // This is a "dispatch" function that decides what
        // other functions to call. You can use an if-, if-else,
        // or switch statement.
        
        // return false if you want this view to exit and return
        // to the view that called it.
        startMainMenuView();
        
        return false;
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
    
    
    private void startMainMenuView(){
        
        MainMenuView mainMenu = new MainMenuView();
        mainMenu.displayView();
        
        // Define wsomeActionHandlerhatever code you need here to accomplish the action.
        // You can make this a void method if you want. Whatever you need 
        // here, you are free to do.
        //
        // Generally, though, this is where you will call into your Control
        // classes to do the work of the application.
    }
}
