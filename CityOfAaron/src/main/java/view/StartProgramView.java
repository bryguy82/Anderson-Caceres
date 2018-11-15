package view;

/**
 *
 * @author kanderson
 */
public class StartProgramView extends ViewStarter {

    public StartProgramView() {
        // empty constructor
    }

    @Override
    protected String getMessage() {
        return "Welcome to the city of Aaron. You have been summoned here by the High Priest to assume\n"
                + "your role as ruler of the city. Your responsibility is to buy and sell land, determine how much\n"
                + "wheat to plant each year and how much to set aside to feed your people. In addition, your odds\n"
                + "of winning will be affected by an annual tithe and on the wheat that is harvested. If you fail\n"
                + " to provide enough wheat for the people, people will starve, die, and your workforce will be\n"
                + "diminished. Plan carefully. And one more thing, there is also the danger of losing wheat to\n"
                + "hungry little rats.";
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

        // false returns to calling view.
        startMainMenuView();

        return false;
    }

    // Other actions go after this-----
    private void startMainMenuView() {
        pause(2000);
        View mainMenu = new MainMenuView();
        mainMenu.displayView();
    }
}
