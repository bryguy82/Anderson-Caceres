package view;

import control.StorehouseControl;
import exception.StorehouseControlException;
import model.Animal;
import model.Author;
import model.InventoryItem;
import model.Provision;

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

        // return false if you want this view to exit and return
        // to the view that called it.
        switch (inputs[0]) {
            case "R":
                getAnnualReport();
                break;
            case "A":
                try {
                    getAnimalReport();
                } catch(StorehouseControlException sce){
                    System.out.println(sce.getMessage());
                }
                break;
            case "P":
                try {
                    getProvisionReport();
                } catch(StorehouseControlException sce){
                    System.out.println(sce.getMessage());
                }                
                break;
            case "T":
                try {
                    getToolReport();
                } catch(StorehouseControlException sce){
                    System.out.println(sce.getMessage());
                }                
                break;
            case "U":
                getAuthorReport();
                break;
            case "C": //to break out of the menu, prompt to save, and continue playing.
                saveReportToFile();
                return false;
            default:
                System.out.println("Invaild selection.  Please try again.");
                break;
        }
        return true;
    }

    //Other actions go after this----- 
    private void getAnnualReport() {
        AnnualReportView annualReport = new AnnualReportView();
        annualReport.displayView();
    }
    
    private void getAnimalReport() throws StorehouseControlException {
        Animal[] animalReport = StorehouseControl.createAnimalItems();
        pause(2000);
        StorehouseControl.sortName(animalReport);

        for (Animal animals : animalReport) {
            System.out.println(animals.getName() + " " + animals.getAge() + "years old.");
        }
        pause(2000);
    }

    private void getToolReport() throws StorehouseControlException {
        InventoryItem[] toolReport = StorehouseControl.createToolItems();
        StorehouseControl.sortQuantity(toolReport);

        System.out.println("\nHere is what you have: ");
        // print out quantity and name in order from 
        for (InventoryItem quantityName : toolReport) {
            System.out.println(quantityName.getQuantity() + " " + quantityName.getName());
        }

        System.out.println("You only have " + toolReport[0].getQuantity() + " " + toolReport[0].getName() + "s.");

        int total = 0;
        for (int i = 0; i < toolReport.length; i++) {
            total += toolReport[i].getQuantity();
        }
        System.out.println("The total amount of tools in storage is " + total + ".\n");
        pause(2000);
    }

    private void getProvisionReport() throws StorehouseControlException {
        Provision[] provisions = StorehouseControl.createProvisionItems();
        StorehouseControl.sortQuantity(provisions);

        System.out.println("You're running a little low on supplies.");
        System.out.println("Here is what you have.\n");
        for (Provision supply : provisions) {
            System.out.println(supply.getQuantity() + " " + supply.getName() + " " + supply.isPerishable());
        }

        int total = 0;
        for (int i = 0; i < provisions.length; i++) {
            total += provisions[i].getQuantity();
        }
        System.out.println("The total amount of provisions you have in storage is " + total + ".");
        System.out.println();
        pause(2000);
    }

    private void getAuthorReport() {
        Author[] authorReport = StorehouseControl.defineAuthors();

        System.out.println();
        for (Author report : authorReport) {
            System.out.println(report.getName() + " " + report.getTitle());
        }
        System.out.println();
        pause(2000);
    }

    private boolean saveReportToFile() {
        pause(2000);
        System.out.println("Would you like to save this report to a file?\n"
                + "Y - yes\n"
                + "N - no\n");
        //call an input to check for validity
        String[] saveReport = getInputs();
        switch (saveReport[0]) {
            case "Y":
//                Storehouse storehouse = new Storehouse();
//                Animal[] animal = StorehouseControl.createAnimalItems();
//                InventoryItem[] tool = StorehouseControl.createToolItems();
//                Author[] authors = StorehouseControl.defineAuthors();
//                Provision[] supply = StorehouseControl.createProvisionItems();
//                
//                storehouse.setAnimals(animal);
//                storehouse.setAuthors(authors);
//                storehouse.setProvisions(supply);
//                storehouse.setTools(tool);

                String filename = "";

                //GameControl.saveGameToFile(storehouse, filename);
                if (false) {
                    System.out.println("Sorry, we couldn't save your report.");
                }
                break;
            case "N":
                return false;
        }
        return true;
    }
}
