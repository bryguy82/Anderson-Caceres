package view;

/**
 *
 * @author kanderson
 */
public class GameMapView extends ViewStarter {

    public GameMapView() {
        // empty constructor
    }

    @Override
    protected String getMessage() {
        return "Here's the map around the City of Aaron\n"
                + "[V][V][W][R][U]\n"
                + "[S][U][V][R][W]\n"
                + "[U][C][T][V][R]\n"
                + "[W][U][V][R][L]\n"
                + "[W][U][R][L][W]\n";
    }

    /**
     * Get the set of inputs from the user.
     *
     * @return
     */
    @Override
    public String[] getInputs() {


        return null;
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

        while (true) {
            switch (inputs[0]) {
                case "C":
                    System.out.println("Welcome to the Ruler's court.  So far\n"
                            + "you have done a decent job of feeding the people.\n");
                    pause(2000);
                    break;
                case "L":
                    System.out.println("You are in the borders near the Lamanites.\n"
                            + "Let's hope they're the righteous kind!\n");
                    pause(2000);
                    break;
                case "R":
                    System.out.println("You've landed near a river.  The water here\n"
                            + "is fresh and clean.  Have you been drinking enough\n"
                            + "water to stay hidrated?\n");
                    pause(2000);
                    break;
                case "S":
                    System.out.println("Welcome to the city's Granary and Storehouse.\n"
                            + "Remember that winning the game relies on keeping this\n"
                            + "filled enough to feed your people.\n"
                            + "Wait.  What was that?\n"
                            + "Was that a rat??\n");
                    pause(2000);
                    break;
                case "T":
                    System.out.println("Did you know the Nephites built temples?\n"
                            + "That's right.  You can read more about it in the \n"
                            + "Book of Mormon in 2 Nephi 5:16.\n"
                            + "Did you remember to pay your tithing?\n");
                    pause(2000);
                    break;
                case "U":
                    System.out.println("I'm sorry, there isn't anthing located at\n"
                            + "this location.  You've selected Undeveloped Land.\n");
                    pause(2000);
                    break;
                case "V":
                    System.out.println("What a great ruler you are.  You have come\n"
                            + "to visit your people.  Let's just hope they aren't\n"
                            + "mad about you starving people to death.\n");
                    pause(2000);
                    break;
                case "W":
                    System.out.println("Great choice!  These wheat fields are so\n"
                            + "beautiful to gaze upon.  Remember that you need 20\n"
                            + "bushels to feed 1 person in a year.");
                    pause(2000);
                    break;
                case "X":
                    return false;
                default:
                    System.out.println("Invaild selection.  Please try again.");
                    pause(2000);
            }
            return true;
        }
    }

    // Other actions go after this-----
    // No other functions needed here
}
