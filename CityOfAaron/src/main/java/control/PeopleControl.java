/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import exception.GameControlException;
import exception.PeopleControlException;

/**
 *
 * @author Bryan
 */
public class PeopleControl {

    public PeopleControl() {
        //Empty constructor
    }

    public static int calculateMortality(int bushelsForFood, int currentPopulation) throws PeopleControlException {
        // TODO Change the returns to the appropriate messages like getRandomNumber in GameControl
        // All new "returns" will be just for PeopleControlExceptions.        

        if (bushelsForFood < 0) {
            throw new PeopleControlException("Value below zero");
        }
        if (currentPopulation < 0) {
            throw new PeopleControlException("Current Population cannot be a negative.");
        }
        int numberOfPeopleFed = bushelsForFood / 20;

        if (numberOfPeopleFed >= currentPopulation) {
            throw new PeopleControlException("Exceeded Population Fed.");
            //return 0;
        } else {
            //System.out.println("Amount of people who died: " + (currentPopulation - numberOfPeopleFed));
            return currentPopulation - numberOfPeopleFed;
        }
    }

    public static int calculateNewMoveIns(int currentPopulation) throws PeopleControlException, GameControlException {

        // Calculate how much the population grew that year.
        // Based on a random percent between 1% and 5% growth.
        if (currentPopulation < 0) {
            throw new PeopleControlException("All of the people just died.");
        }

        double randomPercent = GameControl.getRandomNumber(1, 5) * .01;

        double moveIns = currentPopulation * randomPercent;
        //remove decimals.
        return (int) moveIns;
    }
}
