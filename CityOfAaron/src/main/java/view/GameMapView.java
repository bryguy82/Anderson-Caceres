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

        return false;
    }

// Other actions go after this-----
// No other functions needed here
}
