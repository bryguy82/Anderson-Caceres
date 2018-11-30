package view;

import app.CityOfAaron;
import exception.WheatControlException;

/**
 *
 * @author tonyc
 */
public class PayTithingView extends ViewStarter {

    public PayTithingView() {
        // empty constructor
    }

    @Override
    protected String getMessage() {
        return "This is where you'll pay tithing using the fruits of your harvest.\n"
                + "T - Pay Tithing\n";
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
            case "T":
                try {
                    payTithing();
                } catch (WheatControlException gce) {
                    System.out.println(gce.getMessage());
                }
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
    public boolean payTithing() throws WheatControlException {

        CityOfAaron.getCurrentGame().setBushelsPaidInTithing(0);

        System.out.println("How much wheat will you give as tithing?\n"
                + "Enter that amount here in whole numbers.\n"
                + "(No decimals or % sign please)");
        String[] tithingPercent = getInputs();
        int[] numericalPercent = new int[tithingPercent.length];

        for (int i = 0; i < numericalPercent.length; i++) {
            numericalPercent[i] = Integer.parseInt(tithingPercent[i]);
        }

        if (numericalPercent[0] < 0) {
            throw new WheatControlException("Please enter a positive value");
        }

        if (numericalPercent[0] > 100) {
            throw new WheatControlException("The value has to be below 100.  Try again.");
        }

        //value for numericalPercent[0] is the amount of tithing.
        CityOfAaron.getCurrentGame().setBushelsPaidInTithing(numericalPercent[0]);

        pause(2000);

        return false;
    }
}
