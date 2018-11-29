/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import app.CityOfAaron;
import control.GameControl;

import static view.ViewStarter.pause;
import control.GameControl;
import model.Game;
import control.PeopleControl;
import app.CityOfAaron;
import control.WheatControl;

/**
 *
 * @author tonyc
 */
public class AnnualReportView extends ViewStarter {

    /**
     * Constructor
     */
    public AnnualReportView() {

    }

    @Override
    protected String getMessage() {
        return "A year has passed. Choose an option\n"
                + "S - Show Annual Report\n"
                + "B - Back to Game\n";
    }

    @Override
    public String[] getInputs() {

        // Declare the array to have the number of elements you intend to get 
        // from the user.
        String[] inputs = new String[1];

        inputs[0] = getUserInput("Please make a selection.\n");

        // Repeat for each input you need, putting it into its proper slot in the array.
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {

        switch (inputs[0].trim().toUpperCase()) {

            case "S":
                showAnnualReport();
                return false;
            case "B":
                return false;
            default:
                System.out.println("Invaild selection.  Please try again.");
                break;
        }
        return true;
    }

    public void showAnnualReport() {
        
        Game game = CityOfAaron.getCurrentGame();
        
        System.out.println("You made it to year " + game.getYearNumber() + ".  Congrats!");
        System.out.println("Unfortunately, " + game.getPeopleStarved() + " people starved.");
        System.out.println("You're city is famous.  " + game.getPeopleMovedIn() + " people moved in.");
        System.out.println("Now your city now has " + game.getCurrentPopulation() + " people.");
        System.out.println("You have " + game.getAcresOwned() + " total acres.");
        System.out.println("This year's harvest yielded " + game.getBushelsHavestedPerAcre() + " per acre.");
        System.out.println("The total harvest produced " + game.getTotalBushelsHarvested() + " bushels.");////
        System.out.println("You paid " + game.getBushelsPaidInTithing() + " bushels in tithing.");
        System.out.println("You lost " + game.getBushelsEatenByRats() + " bushels due to hungry rats.");
        System.out.println("Your updated wheat total is " + game.getWheatInStorage() + ".\n");

    }
}
