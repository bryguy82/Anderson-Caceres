
package view;

import model.Storehouse;
import java.util.Scanner;

/**
 *
 * @author kanderson
 */
public class ReportsMenuView {
    
    
    /**
     * The message that will be displayed by this view.
     */
    protected String message;
    
    /**
     * Constructor
     */
    public ReportsMenuView(){
        
        message = "Welcome to the reports.  Choose a letter to see the report."
                + "A - View the animals in the storehouse\n"
                + "T - View the tools in the storehouse\n"
                + "P - View the provisions in the storehouse\n"
                + "U - View the authors of this game\n"
                + "C - Continue playing\n";

        /**
         *  The Reports menu consists of the following options.

            The user chooses the report view and the program displays the selected report. After
            displaying the report to the screen, the program asks the user if they want to save the report to
            a file. If the user answers Yes, the program prompts the user for the name of the file to save the
            report, then saves the report in the file. If the user answers No, the program returns to the
            Reports Menu.
            If the report cannot be saved to the file, the program displays and error message and returns to
            the Reports Menu.  
         */
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
        
        // return false if you want this view to exit and return
        // to the view that called it.
        
        switch(inputs[0].trim().toUpperCase()){
            case "A":
                getAnimalReport();
                break;
            case "T":
                getToolReport();
                break;
            case "P":
                getProvisionReport();
                break;
            case "U":
                getAuthorReport();
                break;
            case "C": //to break out of the menu and continue playing.
                return false;
        }
        saveReportToFile();
            
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
    //Worker functions
    
    private void getAnimalReport(){
        Storehouse animalReport = new Storehouse();
        animalReport.getAnimals();
        System.out.println("getAnimalReport() was called");
    }
    private void getToolReport(){
        Storehouse toolReport = new Storehouse();
        toolReport.getTools();
        System.out.println("getToolReport() was called");
    }
    private void getProvisionReport(){
        Storehouse provisionReport = new Storehouse();
        provisionReport.getProvisions();
        System.out.println("getProvisionReport() was called");
    }
    private void getAuthorReport(){
        Storehouse authorReport = new Storehouse();
        authorReport.getAuthors();
        System.out.println("getAuthorReport() was called");
    }
    private boolean saveReportToFile(){
        System.out.println("Would you like to save this report to a file?\n"
                + "Y - yes\n"
                + "N - no\n");
        //call an input to check for validity
        String[] saveReport = getInputs();
        switch(saveReport[0].trim().toUpperCase()){
            case "Y":
                /*saveGameToFile(Game, filename);
                 *Function in GameControl will respond with true/false
                 *if it's false, System.out.println("Sorry, we couldn't
                 *"save your file"); and returns to the question*/
                break;
            case "N":
                return false;
        }
        return true;
    }
}
