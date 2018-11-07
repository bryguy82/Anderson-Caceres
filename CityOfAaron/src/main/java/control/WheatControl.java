/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author Bryan
 */
public class WheatControl {

    public WheatControl() {
        //empty contructor
    }

    /**
     * Calculate the amount of wheat in storage lost to rats, based on the
     * percentage of tithing paid. Assume that GameControl.getRandomNumber(low,
     * high) is available to be called.
     *
     * @param wheatInStorage is the amount of bushels
     * @param tithingPercent the percentage paid in offerings
     * @return
     */
    public static int calculateLossToRats(int wheatInStorage, int tithingPercent) {
        // if wheatInStorage < 0 then return -1    
        if (wheatInStorage < 0) {
            return -1;
        }
        // if tithingPercent < 0 OR tithingPercent > 100 then return -2
        if (tithingPercent < 0 || tithingPercent > 100) {
            return -2;
        }
        // create random rats amount, check if it's greater than or equal to 30
        int chanceOfRats = GameControl.getRandomNumber(1, 100);

        // if the random generated number
        if (chanceOfRats < 30) {
            //System.out.println("\nNo rats for you!");
            return 0;
        }

        // if tithingPercent < 8 then low = 6, high = 10
        int low = 0, high = 0;
        if (tithingPercent < 8) {
            low = 6;
            high = 10;
        }
        // if tithingPercent >= 8 AND tithingPercent <= 12 then low = 3, high = 7
        if (tithingPercent >= 8 && tithingPercent <= 12) {
            low = 3;
            high = 7;
        }
        // if tithingPercent > 12 then low = 3, high = 5
        if (tithingPercent > 12) {
            low = 3;
            high = 5;
        }
        // percentLost = getRandomNumber(low, high) * 0.01 // turn into a decimal
        double percentLost = GameControl.getRandomNumber(low, high) * .01;

        // return wheatInStorage * percentLost // will need to be cast back to int
        int updatedWheatInStorage = (int) (wheatInStorage * percentLost);
        
        return updatedWheatInStorage;

    }
    //Adding in calculateHarvest
    public static int calculateHarvest(int bushelsPerAcre, int tithingPercent) {
        // Calculate the amount of wheat harvested, based on the percentage 
        // of tithing paid. Assume that GameControl.getRandomNumber(low,high) 
        // is available to be called.

        //if acresPlanted < 0 then return -1
        if (bushelsPerAcre < 0) {
            return -1;
        }
        //if tithingPercent < 0 OR tithingPercent > 100 then return -2
        if (tithingPercent < 0 || tithingPercent > 100) {
            return -2;
        }
        
        //if tithingPercent < 8 then low = 1, high = 3
        int low = 0, high = 0;
        if (tithingPercent < 8) {
            low = 1;
            high = 3;
        }
        // if tithingPercent >= 8 AND tithingPercent <= 12 then low = 2, high = 4
        if (tithingPercent >= 8 && tithingPercent <= 12) {
            low = 2;
            high = 4;
        }
        // if tithingPercent > 12 then low = 2, high = 5
        if (tithingPercent > 12) {
            low = 2;
            high = 5;
        }

        //yield = GameControl.getRandomNumber(low, high)        
        double yield = GameControl.getRandomNumber(low, high);// * .01;

        //return yield * acresPlanted
        return (int) yield * bushelsPerAcre;
    }
}
