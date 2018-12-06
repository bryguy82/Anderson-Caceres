package view;

import app.CityOfAaron;
import control.GameControl;
import control.StorehouseControl;
import exception.StorehouseControlException;
import model.Animal;
import model.Author;
import model.InventoryItem;
import model.Provision;
import model.Storehouse;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

/**
 *
 * @author kanderson
 */
public class ReportsMenuView extends ViewStarter {

    public ReportsMenuView() {
        // empty constructor
    }

    @Override
    protected String getMessage() {
        return "Welcome to the reports.  Choose a letter to see the report.\n"
                + "R - View the annual report again\n"
                + "A - View the animals in the storehouse\n"
                + "P - View the provisions in the storehouse\n"
                + "T - View the tools in the storehouse\n"
                + "U - View the authors of this game\n"
                + "C - Continue playing\n";
    }

    /**
     * Get the set of inputs from the user.
     *
     * @return
     */
    @Override
    public String[] getInputs() throws IOException {

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
    public boolean doAction(String[] inputs) throws IOException {

        // return false if you want this view to exit and return
        // to the view that called it.
        switch (inputs[0]) {
            case "R":
                getAnnualReport();
                break;
            case "A":
                try {
                    getAnimalReport();
                } catch (StorehouseControlException sce) {
                    ErrorView.display(this.getClass().getName(), sce.getMessage());
                }
                break;
            case "P":
                try {
                    getProvisionReport();
                } catch (StorehouseControlException sce) {
                    ErrorView.display(this.getClass().getName(), sce.getMessage());
                }
                break;
            case "T":
                try {
                    getToolReport();
                } catch (StorehouseControlException sce) {
                    ErrorView.display(this.getClass().getName(), sce.getMessage());
                }
                break;
            case "U":
                getAuthorReport();
                break;
            case "C": //to break out of the menu, prompt to save, and continue playing.
                saveReport();
                return false;
            default:
                this.console.println("Invaild selection.  Please try again");
                break;
        }
        return true;
    }

    //Other actions go after this----- 
    private void getAnnualReport() throws IOException {
        AnnualReportView annualReport = new AnnualReportView();
        annualReport.displayView();
    }

    private void getAnimalReport() throws StorehouseControlException {
        Animal[] animalReport = CityOfAaron.getCurrentGame().getTheStorehouse().getAnimals();
        pause(2000);
        StorehouseControl.sortName(animalReport);

        for (Animal animals : animalReport) {
            this.console.println(animals.getName() + " " + animals.getAge() + "years old.");
        }
        pause(2000);
    }

    private void getToolReport() throws StorehouseControlException {
        InventoryItem[] toolReport = CityOfAaron.getCurrentGame().getTheStorehouse().getTools();
        StorehouseControl.sortQuantity(toolReport);

        this.console.println("\nHere is what you have: ");
        // print out quantity and name in order from 
        for (InventoryItem quantityName : toolReport) {
            this.console.println(quantityName.getQuantity() + " " + quantityName.getName());
        }

        this.console.println("You only have " + toolReport[0].getQuantity() + " " + toolReport[0].getName() + "s.");

        int total = 0;
        for (int i = 0; i < toolReport.length; i++) {
            total += toolReport[i].getQuantity();
        }
        this.console.println("The total amount of tools in storage is " + total + ".\n");
        pause(2000);
    }

    private void getProvisionReport() throws StorehouseControlException {
        Provision[] provisions = CityOfAaron.getCurrentGame().getTheStorehouse().getProvisions();
        StorehouseControl.sortQuantity(provisions);

        this.console.println("You're running a little low on supplies.");
        this.console.println("Here is what you have.\n");
        for (Provision supply : provisions) {
            this.console.println(supply.getQuantity() + " " + supply.getName() + " " + supply.isPerishable());
        }

        int total = 0;
        for (int i = 0; i < provisions.length; i++) {
            total += provisions[i].getQuantity();
        }
        this.console.println("The total amount of provisions you have in storage is " + total + ".");
        this.console.println();
        pause(2000);
    }

    private void getAuthorReport() {
        Author[] authorReport = CityOfAaron.getCurrentGame().getTheStorehouse().getAuthors();

        this.console.println();
        for (Author report : authorReport) {
            this.console.println(report.getName() + " " + report.getTitle());
        }
        this.console.println();
        pause(2000);
    }

    private boolean saveReport() throws IOException {
        pause(2000);
        this.console.println("Would you like to save this report to a file?\n"
                + "Y - yes\n"
                + "N - no\n");
        //call an input to check for validity
        String[] saveReport = getInputs();
        switch (saveReport[0]) {
            case "Y":
                saveReportToFile();
                if (false) {
                    ErrorView.display(this.getClass().getName(), "Sorry, we couldn't save your report.");
                }
                break;
            case "N":
                return false;
        }
        return true;
    }

    public boolean saveReportToFile() throws IOException {

        Storehouse storehouse = CityOfAaron.getCurrentGame().getTheStorehouse();
        this.console.println("Enter the filename: ");
        String[] file = getInputs();
        String reportFile = file[0] + ".txt";

        try (PrintWriter printReport = new PrintWriter(new FileWriter(reportFile))) {

            printReport.println("Here are your Tool and Animal Reports!");
            printReport.println();

            String layout = "%-10s %-10s %10s %10s %-10s";
            printReport.println(String.format(layout, "Type", "Name", "Quantity", "Age", "Condition"));
            printReport.println("---------- ---------- ---------- ---------- ---------- ");

            String toolLayout = "%-10s %-10s %9d %10s %10s";
            InventoryItem[] tools = storehouse.getTools();
            StorehouseControl.sortName(tools);

            for (int i = 0; i < tools.length; i++) {
                printReport.println(String.format(toolLayout,
                        tools[i].getItemType(),
                        tools[i].getName(),
                        tools[i].getQuantity(),
                        "          ",
                        tools[i].getCondition()));
            }
            printReport.println();

            String animalLayout = "%-10s %-10s %9d %10d %10s";
            Animal[] animals = storehouse.getAnimals();
            StorehouseControl.sortName(animals);

            for (int i = 0; i < animals.length; i++) {
                printReport.println(String.format(animalLayout,
                        animals[i].getItemType(),
                        animals[i].getName(),
                        animals[i].getQuantity(),
                        animals[i].getAge(),
                        animals[i].getCondition()));
            }
            printReport.println();

            // Need Provisions, and Authors.
        } catch (IOException ioe) {
            ErrorView.display(this.getClass().getName(), ioe.getMessage());
        } catch (StorehouseControlException sce) {
            ErrorView.display(this.getClass().getName(), sce.getMessage());
        }
        /*THIS WORKS FOR OBJECTS ONLY
        
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(reportFile))) {
            out.writeObject(storehouse);

        } catch (IOException ioe) {
            ErrorView.display(this.getClass().getName(), ioe.getMessage());
        }*/
        this.console.println("You saved the Report");
        return false;
    }
}
