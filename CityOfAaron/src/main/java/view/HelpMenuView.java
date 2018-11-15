package view;

/**
 *
 * @author kanderson
 */
public class HelpMenuView extends ViewStarter {

    public HelpMenuView() {
        // empty constructor
    }

    @Override
    protected String getMessage() {
        return "Welcome to the help menu, which includes a guideline to help you play the game.\n"
                + "W - What are the goals of the game?\n"
                + "H - Where is the city of Aaron?\n"
                + "M - How do I view the map?\n"
                + "L - How do I move to another location?\n"
                + "D - How do I display a list of animals, provisions and tools in the city storehouse?\n"
                + "B - Back to the Main Menu.";
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

        inputs[0] = getUserInput("Please make a selection.").trim().toUpperCase();

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

        switch (inputs[0]) {
            case "W":
                System.out.println("The goal of the game is to always have\n"
                        + "enough wheat to feed your people.  Remember to pay\n"
                        + "your tithing and to keep your people fed.  You'll\n"
                        + "need 20 bushels to feed 1 person.\n");
                pause(2000);
                break;
            case "H":
                System.out.println("If you'll look in Alma 8, Alma is teaching \n"
                        + "the people after giving up the judgement-seat unto \n"
                        + "Nephihah.  He was rejected in the city of Melek and\n"
                        + "was on his way to a city named Aaron (verse 13).\n"
                        + "Although an angel appeared and made him return, we\n"
                        + "play out what could have happened there.\n");
                pause(2000);
                break;
            case "M":
                System.out.println("To view the map, simply go to the Game Menu\n"
                        + "while you're playing to see it.\n");
                pause(2000);
                break;
            case "L":
                System.out.println("To change locations you'll first have to \n"
                        + "go to the Map View.  There you'll be able to select\n"
                        + "a row and a column number to travel to a new location.\n");
                pause(2000);
                break;
            case "D":
                System.out.println("A list of provisions can be viewed from the \n"
                        + "Reports Menu which appears after every game-year.\n");
                pause(2000);
                break;
            case "B":
                //"false" takes us to the main menu
                return false;
            default:
                System.out.println("Invaild selection.  Please try again.");
                pause(2000);
        }
        return true;
    }

    // Other actions go after this-----
    // No other actions here, just displaying information
}
