/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Game;
import app.CityOfAaron;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.MissingFormatArgumentException;

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
    public boolean doAction(String[] inputs) throws IOException {

        switch (inputs[0].trim().toUpperCase()) {

            case "S":
                showAnnualReport();
                break;
            case "R":
                saveAnnualReport();
                break;
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

        String reportFile = "";
        this.console.println("Where do you want to save your file?\n"
                + "Option A: include path and everything (C:/documents/report.txt)\n"
                + "Option B: file name with extention (report.txt)\n");
        String[] file = getInputs();
        if (file != null) {
            reportFile = file[0];
        }

        try (PrintWriter printReport = new PrintWriter(new FileWriter(reportFile))) {

            printReport.println("Here's your Annual Report!");
            printReport.println();

            String[] category = new String[]{"Year", "People Starved", "People Moved In", "Current Population", "Bushels Harvested",
                "Acres Owned", "Bushels Paid in Tithing", "Bushels Eaten by Rats", "Wheat in Storage"};
            int[] starting = new int[]{1, 0, 5, 100, 1000, 3, 300, 0, 2700};
            Object[] ending = new Object[]{game.getYearNumber(), game.getPeopleStarved(), game.getPeopleMovedIn(),
                game.getCurrentPopulation(), game.getBushelsHavestedPerAcre(),
                game.getAcresOwned(), game.getBushelsPaidInTithing(), game.getBushelsEatenByRats(),
                game.getWheatInStorage()};

            String title = "%-20s %15s %15s";
            printReport.println(String.format(title, "Category", "Starting Value", "Value Now"));
            printReport.println("------------------- -------------- -------------- ");

            String layout = "%-20s %15d %15d";
            for (int i = 0; i < category.length; i++) {
                printReport.println(String.format(layout, category[i] + starting[i] + ending[i]));
            }
            printReport.println();

        } catch (IOException | MissingFormatArgumentException ioe) {
            ErrorView.display(this.getClass().getName(), ioe.getMessage());
        }

        this.console.println("You saved the annual report.");
        return false;
    }
}
