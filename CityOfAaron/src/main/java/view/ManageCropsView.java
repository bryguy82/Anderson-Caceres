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
import java.io.IOException;

public class ManageCropsView extends ViewStarter {

    public ManageCropsView() {
        // empty contructor      
    }

    @Override
    protected String getMessage() {
        return "Now we will manage those crops.";

    }

    /**
     * Get the set of inputs from the user.
     *
     * @return
     */
    @Override
    public String[] getInputs() {

        // No inputs, each function will be called after the other.
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
    public boolean doAction(String[] inputs) throws IOException {

        try {
            buyLand();
            sellLand();
            feedThePeople();
            plantCrops();
            tithesAndOfferings();
        } catch (NumberFormatException nfe) {
            ErrorView.display(this.getClass().getName(), "NUMBER " + nfe.getMessage());
        }

        return false;
    }

    //Other actions go after this----- 
    private void buyLand() throws IOException {
        pause(2000);
        View buyLand = new BuyLandView();
        buyLand.displayView();
    }

    private void sellLand() throws IOException {
        pause(2000);
        View sellLand = new SellLandView();
        sellLand.displayView();
    }

    private void feedThePeople() throws IOException {
        pause(2000);
        View feedPeople = new FeedPeopleView();
        feedPeople.displayView();
    }

    private void plantCrops() throws IOException {
        pause(2000);
        View plantCrops = new PlantCropsView();
        plantCrops.displayView();
    }

    private void tithesAndOfferings() throws IOException {
        pause(2000);
        View payTithing = new PayTithingView();
        payTithing.displayView();
    }
}
