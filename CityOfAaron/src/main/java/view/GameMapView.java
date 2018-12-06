package view;

import app.CityOfAaron;
import model.Location;
import model.Map;

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
        return "Here's the map around the City of Aaron\n" /*                + "    0  1  2  3  4 \n"
                + " 0 [V][V][W][R][U]\n"
                + " 1 [S][U][V][R][W]\n"
                + " 2 [U][C][T][V][R]\n"
                + " 3 [W][U][V][R][L]\n"
                + " 4 [W][U][R][L][W]\n"*/;
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

        getMapSymbols();
        pause(3000);
        return false;
    }

// Other actions go after this-----
    private void getMapSymbols() {
        Location[][] locations = CityOfAaron.getCurrentGame().getTheMap().getLocations();
        this.console.println("    0   1   2   3   4 ");
        for (int i = 0; i < locations.length; i++) {
            int j = 0;
            this.console.println(" " + i
                    + " [" + locations[i][j].getMapSymbol() + "]"
                    + " [" + locations[i][j + 1].getMapSymbol() + "]"
                    + " [" + locations[i][j + 2].getMapSymbol() + "]"
                    + " [" + locations[i][j + 3].getMapSymbol() + "]"
                    + " [" + locations[i][j + 4].getMapSymbol() + "]");
        }
    }
}
