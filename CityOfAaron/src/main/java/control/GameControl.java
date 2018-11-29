/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Random;
import app.CityOfAaron;

import model.Game;
import model.Player;
import model.Map;
import model.Storehouse;
import model.Animal;
import model.Author;
import model.InventoryItem;
import model.Provision;

/**
 *
 * @author Bryan
 */
public class GameControl {

    public GameControl() {
        //empty constructor
    }

    //Use this one for testing
    private static Random randomGenerator = new Random(0);

    // Generate a random number with some "random" seed. 
    // This is how you will do it in your actual game code.
    // Random randomGenerator = new Random(System.currentTimeMillis());
    /**
     * protected setter for testing
     *
     * @param random
     */
    protected static void setRandomGenerator(Random random) {
        System.out.println(GameControl.randomGenerator = random);
    }

    /**
     * Generates a random number with lowNumber and highNumber requirements: the
     * highNumber and lowNumber must be greater than zero highNumber has to be
     * greater than the lowNumber highNumber can't be higher than the MAX_VALUE
     *
     * @param lowValue
     * @param highValue
     * @return a random number
     */
    public static int getRandomNumber(int lowValue, int highValue) {

        //if low & high < 0 return -1
        if (lowValue < 0 || highValue < 0) {
            return -1;
        }

        //if high <= low return -2
        if (highValue <= lowValue) {
            return -2;
        }

        //if high is the MAX_VALUE, return -3
        if (highValue == Integer.MAX_VALUE) {
            return -3;
        }

        //calculate the range size; +1 to include high
        int range = (highValue - lowValue) + 1;

        //return low + range for the possible values
        return lowValue + randomGenerator.nextInt(range);

    }

    public static boolean saveGameToFile(Game game, String filename) {
        //game = CityOfAaron.getCurrentGame();
        //Save Game method
        //Need a boolean to check if it didn't save
        //False means it was successful.
        System.out.println("The save game option will be implemented later.");
        return false;
    }

    public static boolean loadGameFromFile(Game game, String filename) {
        //Load Game method
        //Need a boolean to check if it didn't load
        //False means it was successful.
        System.out.println("The load game option will be implemented later.");
        return false;
    }

    public static boolean saveReportToFile(Game game, String filename) {

        Storehouse storehouse = game.getTheStorehouse();
        // save "storehouse" somehow.
        System.out.println("The save game option will be implemented later.");
        return false;
    }

    public static Game createNewGame(String playerName) {

        Player player = new Player();
        player.setName(playerName);

        Game game = new Game();

        game.setThePlayer(player);

        // Variables to start the game and needed to "live the year".
        game.setYearNumber(1);
        game.setPeopleStarved(0);
        game.setPeopleMovedIn(5);
        game.setCurrentPopulation(100);
        game.setAcresOwned(1000);
        game.setBushelsHavestedPerAcre(3);
        game.setTotalBushelsHarvested(3000);
        game.setBushelsPaidInTithing(300);
        game.setBushelsEatenByRats(0);
        game.setWheatInStorage(2700);

        Map theMap = MapControl.createMap();
        game.setTheMap(theMap);

        Storehouse storehouse = new Storehouse();

        Author[] authors = {
            new Author("Anderson", "Executive Programmer"),
            new Author("Caceres", "Executive Programmer")};
        InventoryItem[] tool = StorehouseControl.createToolItems();
        Animal[] animals = StorehouseControl.createAnimalItems();
        Provision[] provisions = StorehouseControl.createProvisionItems();

        storehouse.setAuthors(authors);
        storehouse.setTools(tool);
        storehouse.setAnimals(animals);
        storehouse.setProvisions(provisions);

        game.setTheStorehouse(storehouse);

        CityOfAaron.setCurrentGame(game);

        return game;
    }

    public static Game liveTheYear(Game newYear) {

        int year = newYear.getYearNumber();

        int bushelsPaidInTithing = newYear.getBushelsPaidInTithing();
        int totalBushelsHarvested = WheatControl.calculateHarvest(newYear.getAcresPlanted(), bushelsPaidInTithing);
        int bushelsEatenByRats = WheatControl.calculateLossToRats(newYear.getWheatInStorage(), bushelsPaidInTithing);
        int wheatInStorage = newYear.getWheatInStorage() + totalBushelsHarvested - bushelsPaidInTithing - bushelsEatenByRats;

        int currentPopulation = newYear.getCurrentPopulation();
        int peopleStarved = PeopleControl.calculateMortality(newYear.getBushelsToFeedThePeople(), currentPopulation);
        int peopleMovedIn = PeopleControl.calculateNewMoveIns(currentPopulation);
        currentPopulation += peopleMovedIn - peopleStarved;

        // set all of the altered values.
        newYear.setYearNumber(year + 1);
        newYear.setPeopleStarved(peopleStarved);
        newYear.setPeopleMovedIn(peopleMovedIn);
        newYear.setCurrentPopulation(currentPopulation);
        newYear.setTotalBushelsHarvested(totalBushelsHarvested);
        newYear.setBushelsPaidInTithing(bushelsPaidInTithing);
        newYear.setBushelsEatenByRats(bushelsEatenByRats);
        newYear.setWheatInStorage(wheatInStorage);

        return newYear;
    }
}
