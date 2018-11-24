package view;

import app.CityOfAaron;
import control.GameControl;
import model.Storehouse;
import control.StorehouseControl;
import model.Author;

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
            case "A":
                getAnimalReport();
                break;
            case "P":
                getProvisionReport();
                break;
            case "T":
                getToolReport();
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
    private void getAnimalReport() {
        Storehouse animalReport = StorehouseControl.createAnimalItems();
        //System.out.println(animalReport);
    }

    private void getToolReport() {
        Storehouse toolReport = StorehouseControl.createToolItems();
        //System.out.println(toolReport);
    }

    private void getProvisionReport() {
        Storehouse provisionReport = StorehouseControl.createProvisions();
        //System.out.println(provisionReport);
    }

    private void getAuthorReport() {
        Author[] authorReport = StorehouseControl.defineAuthors();
        System.out.println();
        for (Author report : authorReport) {
            System.out.println(report.getName() + " " + report.getTitle());
        }
        System.out.println();
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
                Storehouse storehouse = new Storehouse();
                Storehouse animal = StorehouseControl.createAnimalItems();
                Storehouse tool = StorehouseControl.createToolItems();
                Author[] authors = StorehouseControl.defineAuthors();

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
