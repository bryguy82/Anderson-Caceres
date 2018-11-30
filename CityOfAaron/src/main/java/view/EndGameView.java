package view;

import app.CityOfAaron;

/**
 *
 * @author tonyc
 */
public class EndGameView extends ViewStarter {

    public EndGameView() {
        // empty constructor
    }

    @Override
    protected String getMessage() {
        return "You have reached the end of the road.\n"
                + "E - End Game.\n";
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

            case "E":
                endGame();
                return false;
            default:
                System.out.println("Invaild selection.  Please try again.");
                break;
        }
        return true;
    }

    //Other actions go after this----- 
    private void endGame() {
//        if (true) {
//            throw new RuntimeException("Game Over");
//        }
    }
}
