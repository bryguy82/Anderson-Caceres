/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Bryan
 */
public class ManageCropsView extends ViewStarter {

    public ManageCropsView() {
        // empty contructor      
    }

    @Override
    protected String getMessage() {
        return "Let's manage those crops.  What would you like to do?\n"
                + "B - Buy Land\n"
                + "S - Sell Land\n"
                + "F - Feed the People\n"
                + "P - Plant Crops\n"
                + "T - Pay Tithes and Offerings\n"
                + "R - Return to the Game Menu\n";
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
            case ("B"):
                buyLand();
                break;
            case ("S"):
                sellLand();
                break;
            case ("F"):
                feedThePeople();
                break;
            case ("P"):
                plantCrops();
                break;
            case ("T"):
                tithesAndOfferings();
                break;
            case ("R"):
                return false;
            default:
                System.out.println("Invaild selection.  Please try again.");
                break;
        }
        return true;
    }

    //Other actions go after this----- 
    private void buyLand() {
        pause(2000);
        View buyLand = new BuyLandView();
        buyLand.displayView();
    }

    private void sellLand() {
        pause(2000);
        View sellLand = new SellLandView();
        sellLand.displayView();
    }

    private void feedThePeople() {
        pause(2000);
        View feedPeople = new FeedPeopleView();
        feedPeople.displayView();
    }

    private void plantCrops() {
        pause(2000);
        View plantCrops = new PlantCropsView();
        plantCrops.displayView();
    }

    private void tithesAndOfferings() {
        pause(2000);
        View payTithing = new PayTithingView();
        payTithing.displayView();
    }
}
