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
import model.Author;

import view.GameMenuView;
import view.View;

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
    
    public static Game createNewGame(String playerName) {
        
        Player player = new Player();
        player.setName(playerName);

        Game game = new Game();
        
        game.setThePlayer(player);
        game.setAcresOwned(1000);
        game.setCurrentPopulation(100);
        game.setWheatInStorage(3000);

        game.setCurrentPopulation(100);
        game.setAcresOwned(1000);
        game.setWheatInStorage(3000);
        game.setYearNumber(0);
        
        Map theMap = MapControl.createMap();
        game.setTheMap(theMap);
        
        Storehouse storehouse = new Storehouse();
        Author[] authors = {
            new Author("Anderson", "Executive Programmer"),
            new Author("Caceres", "Executive Programmer")};
        
        storehouse.setAuthors(authors);
        
        /*
        int havestedWheat = WheatControl.calculateHarvest(1, 10);
        */
        

        game.setTheStorehouse(storehouse);      
        

        CityOfAaron.setCurrentGame(game);

        return game;
    }
}
