/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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
            case  "B":
                return false;
            default:
                System.out.println("Invaild selection.  Please try again.");
                break;
        }
        return true;
    }

    public void showAnnualReport(){
        
        int bushelsForFood;
        bushelsForFood = CityOfAaron.getCurrentGame().getWheatInStorage();
        
        int currentPopulation;
        currentPopulation = CityOfAaron.getCurrentGame().getCurrentPopulation();
        
        int starvedPeople;
        starvedPeople = PeopleControl.calculateMortality(bushelsForFood, currentPopulation);
                
        int moveIns;
        moveIns = PeopleControl.calculateNewMoveIns(currentPopulation);
        
        int acres;
        acres = CityOfAaron.getCurrentGame().getAcresOwned();
        
        int acresHarvested;
        acresHarvested = WheatControl.calculateHarvest(bushelsForFood, 10);
        
        int bushelsPaidInOfferings = 300;
        
        int bushelsLostToRats;
        bushelsLostToRats = WheatControl.calculateLossToRats(bushelsForFood, 10);
        
        int remainingBushels;        
        remainingBushels = bushelsForFood - bushelsLostToRats - bushelsPaidInOfferings;
        
        int yearNumber;
        yearNumber = CityOfAaron.getCurrentGame().getYearNumber();
        
        System.out.println("Year Number: "+yearNumber+"\n");
        System.out.println("How many people starved: "+starvedPeople+"\n");
        System.out.println("People that came to the City: "+moveIns+"\n");
        System.out.println("Current Population: "+currentPopulation+"\n");
        System.out.println("Acres of Crop land Owned by the City: "+acres+"\n");
        System.out.println("Bushels of Wheat paid in Offerings: "+bushelsPaidInOfferings+"\n");
        System.out.println("Bushels of Wheat Eaten by Rats: "+bushelsLostToRats+"\n");
        System.out.println("Wheaet in Storage: "+remainingBushels+"\n");
                       
        
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