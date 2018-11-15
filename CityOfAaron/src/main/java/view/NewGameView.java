package view;

import app.CityOfAaron;
import model.Player;
import model.Game;

/**
 *
 * @author kanderson
 */
public class NewGameView extends ViewStarter {

    public NewGameView() {
        // empty constructor        
    }

    @Override
    protected String getMessage() {
        return "Are your ready to take control of the City? Let's get to it!";
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

        inputs[0] = getUserInput("Please enter your name: ").trim().toUpperCase();

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

        if (inputs[0] == null || inputs[0].equals("")) {
            System.out.println("You forgot to enter your name. Going back to the main menu");
            return false;
        }

        String playerName = inputs[0];

        createAndStartGame(playerName);

        return false;
    }

    //Other actions go after this----- 
    private void createAndStartGame(String playerName) {

        Player player = new Player();
        player.setName(playerName);

        Game game = new Game();
        game.setThePlayer(player);

        CityOfAaron.setCurrentGame(game);

        System.out.println();
        System.out.println("Welcome to the Game, " + CityOfAaron.getCurrentGame().getThePlayer().getName() + "! \n");
    }
}
