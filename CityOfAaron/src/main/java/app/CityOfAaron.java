
package app;

import model.Game;
import model.Map;
import model.Player;
import model.Storehouse;

import model.Author;
import model.Animal;
import model.Condition;
import model.InventoryItem;
import model.ItemType;
import model.Location;
import model.Point;
import model.Provision;

public class CityOfAaron {

    /**
     * The starting point for our application. 
     * 
     * @param args Any parameters passed on the command line will be 
     * contained in this array.
     */
    public static void main(String[] args) {

        Game theGame = new Game();
        theGame.setThePlayer(new Player());
        theGame.setTheMap(new Map());
        theGame.setTheStorehouse(new Storehouse());
        theGame.setCurrentPopulation(105);
        theGame.setAcresOwned(2000);
        theGame.setWheatInStorage(15000);
        
        
        System.out.println(theGame.toString());

    }

}