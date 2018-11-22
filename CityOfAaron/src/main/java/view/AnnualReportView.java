/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import app.CityOfAaron;
import control.GameControl;
import static view.ViewStarter.pause;

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
            default:
                System.out.println("Invaild selection.  Please try again.");
                break;
        }
        return true;
    }

    private void showAnnualReport(){
        
        System.out.println("This is the Annual Report");
        /* DIVIDE and CONQUER.  Call each function responsible.
        • The year number
        • How many people starved
        • How many people came to the city
        • The current population
        • The number of acres of crop land owned by the city
        • The number of bushels per acre in this year’s harvest
        • The number of bushels of wheat paid in offerings
        • The number of bushels of wheat eaten by rats
        • The number of bushels of wheat in store */
    }
}
