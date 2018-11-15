package view;

/**
 *
 * @author kanderson
 */
public class MainMenuView extends ViewStarter {

    public MainMenuView() {
        // empty constructor
    }

    @Override
    protected String getMessage() {
        return "Here we are at the Main Menu.\n\n"
                + "N - Start a New Game.\n"
                + "L - Load a Saved Game.\n"
                + "B - Buy Land\n"//Testing purposes only----------
                + "S - Sell Land\n"//Testing purposes only----------
                + "M - View Map\n"//Testing purposes only----------
                + "R - See Reports\n"//Testing purposes only----------
                + "G - Game Menu\n"//Testing purposes only----------
                + "H - Get Help.\n"
                + "Q - Quit Game.\n";
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

        inputs[0] = getUserInput("So, what are you going to choose?").trim().toUpperCase();

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
            case "N":
                startNewGame();
                break;
            case "L":
                loadSavedGame();
                break;
            case "H":
                helpMenu();
                break;
            //TEST CASES--------------------------------------------------    
            case "B":
                testBuyLand();
                break;
            case "S":
                testSellLand();
                break;
            case "M":
                testViewMap();
                break;
            case "R":
                testViewReports();
                break;
            case "G":
                testGameMenu();
                break;
                // End test cases-----------------------------------
            case "Q":
                System.out.println("Thank you for playing. Come back soon!");
                return false;
            default:
                System.out.println("Invaild selection.  Please try again.");
        }
        return true;
    }

    //Other actions go after this----- 
    
    private void startNewGame() {
        pause(2000);
        View newGame = new NewGameView();
        newGame.displayView();
    }

    private void loadSavedGame() {
        pause(2000);
        View savedGame = new StartExistingGameView();
        savedGame.displayView();
    }

    private void helpMenu() {
        pause(2000);
        View helpMenu = new HelpMenuView();
        helpMenu.displayView();
    }
    //TESTING PURPOSES ONLY------------------------------------------
    
    private void testBuyLand(){
        View buyLand = new BuyLandView();
        buyLand.displayView();
    }

    private void testSellLand(){
        View sellLand = new SellLandView();  
        sellLand.displayView();
    }

    private void testViewMap(){
        View gameMap = new GameMapView();
        gameMap.displayView();
    }

    private void testViewReports(){
        View viewReports = new ReportsMenuView();
        viewReports.displayView();
    }

    private void testGameMenu(){
        View gameMenu = new GameMenuView();
        gameMenu.displayView();
    }
}
