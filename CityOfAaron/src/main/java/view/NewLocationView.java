package view;

/**
 *
 * @author tonyc
 */
public class NewLocationView extends ViewStarter {

    public NewLocationView() {
        // empty constructor
    }

    @Override
    protected String getMessage() {
        return "You are about to move to a New Location.\n"
                + "M - Move.\n"
                + "B - Back to Main Menu.\n";
    }

    /**
     * Get the set of inputs from the user.
     *
     * @return
     */
    @Override
    public String[] getInputs() {

        // Declare the array to have the number of elements you intend to get 
        // from the user.
        String[] inputs = new String[1];

        inputs[0] = getUserInput("Please select an option.");

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
    @Override
    public boolean doAction(String[] inputs) {

       switch (inputs[0].trim().toUpperCase()) {

            case "M":
                moveToNewLocation();
                return false;
            case "B":
                mainMenu();
                return false;
            default:
                System.out.println("Invaild selection.  Please try again.");
                break;
        }
        return true;
    }

    //Other actions go after this----- 
    
    private void mainMenu(){
        
    }
    
    private void moveToNewLocation(){
        System.out.println("You have moved to a new location.");
        
        /* The user will be prompted to enter the coordinates of the location on the map that they want to
move to. Upon arriving at the new location, the program will display the name of the location and
the description of what can be seen at this location. If there are any game tips associated with the
location, one of the tips is chosen at random and displayed.*/
    }
}
