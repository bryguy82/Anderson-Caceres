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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import model.Storehouse;
import view.ErrorView;
import view.ReportsMenuView;

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
                + "R - Save Annual Report\n"
                + "B - Back to Game\n";
    }

    @Override
    public String[] getInputs() throws IOException {

        // Declare the array to have the number of elements you intend to get 
        // from the user.
        String[] inputs = new String[1];

        inputs[0] = getUserInput("Please make a selection.\n");

        // Repeat for each input you need, putting it into its proper slot in the array.
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) throws IOException{

        switch (inputs[0].trim().toUpperCase()) {

            case "S":
                showAnnualReport();
                return false;
            case "R":
                saveAnnualReport();
                return false;
            case "B":
                return false;
            default:
                this.console.println("Invaild selection.  Please try again");
                break;
        }
        return true;
    }

    public void showAnnualReport() {

        Game game = CityOfAaron.getCurrentGame();

        this.console.println("You made it to year " + game.getYearNumber() + ".  Congrats!");
        this.console.println("Unfortunately, " + game.getPeopleStarved() + " people starved.");
        this.console.println("You're city is famous.  " + game.getPeopleMovedIn() + " people moved in.");
        this.console.println("Now your city now has " + game.getCurrentPopulation() + " people.");
        this.console.println("You have " + game.getAcresOwned() + " total acres.");
        this.console.println("This year's harvest yielded " + game.getBushelsHavestedPerAcre() + " per acre.");
        this.console.println("The total harvest produced " + game.getTotalBushelsHarvested() + " bushels.");////
        this.console.println("You paid " + game.getBushelsPaidInTithing() + " bushels in tithing.");
        this.console.println("You lost " + game.getBushelsEatenByRats() + " bushels due to hungry rats.");
        this.console.println("Your updated wheat total is " + game.getWheatInStorage() + ".\n");

    }
    
    public boolean saveAnnualReport() throws IOException {
        Game game = CityOfAaron.getCurrentGame();
        this.console.println("Enter the filename: ");
        String[] file = getInputs();
        String reportFile = file[0] + ".txt";
        
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(reportFile))) {
            out.writeObject(game);

        } catch (IOException ioe) {
            ErrorView.display(this.getClass().getName(), ioe.getMessage());
        }
        this.console.println("You saved the Annual Report");
        return false;
    }
}
