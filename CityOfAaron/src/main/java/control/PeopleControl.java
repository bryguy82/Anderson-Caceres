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
public class PeopleControl {

    public PeopleControl() {
        //Empty constructor
    }

    public static int calculateMortality(int bushelsForFood, int currentPopulation) {

        if (bushelsForFood < 0) {
            return -1;
        }
        if (currentPopulation < 0) {
            return -1;
        }
        int numberOfPeopleFed = bushelsForFood / 20;

        if (numberOfPeopleFed >= currentPopulation) {
            return 0;
        } else {
            //System.out.println("Amount of people who died: " + (currentPopulation - numberOfPeopleFed));
            return currentPopulation - numberOfPeopleFed;
        }
    }

    public static int calculateNewMoveIns(int currentPopulation) {
        // Calculate how much the population grew that year.
        // Based on a random percent between 1% and 5% growth.

        if (currentPopulation < 0) {
            return -1;
        }

        double randomPercent = GameControl.getRandomNumber(1, 5) * .01;

        double moveIns = currentPopulation * randomPercent;
        //remove decimals.
        return (int) moveIns;
    }
}
