

package app;

import java.util.ArrayList;

import model.Game;
import model.Map;
import model.Player;
import model.Storehouse;

import model.Author;
import model.Animal;
//import model.Condition;
import model.InventoryItem;
import model.Location;
//import model.ItemType;
import model.Point;
import model.Provision;
import model.Tool;

public class CityOfAaron {

    /**
     * The starting point for our application. 
     * 
     * @param args Any parameters passed on the command line will be 
     * contained in this array.
     */
    public static void main(String[] args) {
        
        //This block starts a fresh game.
        Game theGame = new Game();
        theGame.setThePlayer(new Player());
        theGame.setTheMap(new Map());
        theGame.setTheStorehouse(new Storehouse());
        theGame.setCurrentPopulation(105);
        theGame.setAcresOwned(2000);
        theGame.setWheatInStorage(15000);
        
        Player thePlayer = new Player();
        Map theMap = new Map();
        Location yourLocation = new Location();
        Point yourPoint = new Point();
        Author author1 = new Author();
        Storehouse theStorehouse = new Storehouse();
        Animal animalOne = new Animal();
        Provision provisionOne = new Provision();
        Tool toolOne = new Tool();

        thePlayer.setName("Charlot");
        //playerOne.setGames([one; two; three;]);
        
        theMap.setCurrentLocation(yourPoint);
        //theMap.setLocations([3][5]);
        
        yourLocation.setName("Nephi");
        yourLocation.setDescription("You picked a good spot!");
        yourLocation.setMapSymbol("&");
        yourLocation.setGameTips(args);
        
        yourPoint.setColumn(2);
        yourPoint.setRow(1);
        
        author1.setName("Mormon");
        author1.setTitle("Mr.");
        
        //theStorehouse.setAnimalNames(ARRAYLIST[9]);
        //theStorehouse.setAnimals(ARRAy);
        //theStorehouse.setAnimalNames(animalNames);
        
        
        
        /*
        theGame.setTheAuthor(new Author())
        theGame.setTheAnimal(new Animal());
        theGame.setTheCondition(new Condition());
        theGame.setTheInventoryItem(new InventoryItem());        
        theGame.getTheLocation(new Location());
        theGame.setThePoint(new Point());
        theGame.setTheProvision(new Provision());
        theGame.setTheTool(new Tool());
        */
        System.out.println(theGame.toString());
        System.out.println(thePlayer.toString());
        System.out.println(theMap.toString());
        System.out.println(yourLocation.toString());

    }
}
