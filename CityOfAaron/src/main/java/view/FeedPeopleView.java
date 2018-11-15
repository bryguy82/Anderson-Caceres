package view;

/**
 *
 * @author tonyc
 */
public class FeedPeopleView extends ViewStarter {

    public FeedPeopleView() {
        // empty constructor
    }

    @Override
    protected String getMessage() {
        return "You will have to decide how much food you'll give to the people.\n"
                + "F - Feed the people\n";
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
    @Override
    public boolean doAction(String[] inputs) {

        switch (inputs[0].trim().toUpperCase()) {
            case "F":
                feedThePeople();
                return false;
            default:
                System.out.println("Invaild selection.  Please try again.");
                break;
        }
        // return false if you want this view to exit and return
        // to the view that called it.

        return true;
    }

    //Other actions go after this----- 
    private boolean feedThePeople() {

        int wheatInStorage = 2000;// a value for testing.

        System.out.println("How many many bushels of wheat will you give to the people\n"
                + "so they can eat?");

        String[] bushelsForThePeople = getInputs();
        int[] numericalBushels = new int[bushelsForThePeople.length];

        for (int i = 0; i < numericalBushels.length; i++) {
            numericalBushels[i] = Integer.parseInt(bushelsForThePeople[i]);
        }

        if (numericalBushels[0] < 0) {
            System.out.println("Please enter a positive value.");
            return true;
        }

        if (numericalBushels[0] > wheatInStorage) {
            System.out.println("You don't have that many bushels.");
            return true;
        }

        // Subtract the entered amount from the wheat in storage. Display what's left.
        wheatInStorage -= numericalBushels[0];
        System.out.println("After setting aside these bushels, you have \n"
                + wheatInStorage + " left.");

        //Update the game state to save how many bushels of wheat you have set aside to feed the people.
        //CityOfAaron.getCurrentGame().setWheatInStorage(wheatInStorage);
        pause(2000);

        return false;
    }

}
