

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
        InventoryItem itemOne = new InventoryItem();
        Point yourPoint = new Point();
        Author authorOne = new Author();
        Storehouse theStorehouse = new Storehouse();
        Animal animalOne = new Animal();
        Provision provisionOne = new Provision();
        Tool toolOne = new Tool();
        //Condition conditionOne = Condition.Good;

        thePlayer.setName("Charlot");
        
        yourLocation.setName("undeveloped land");
        yourLocation.setDescription("a good spot!");
        yourLocation.setMapSymbol("&");
        yourLocation.setGameTips(args);
        
        yourPoint.setColumn(2);
        yourPoint.setRow(1);
        
        authorOne.setName("Mormon");
        authorOne.setTitle("Mr.");
        
        ArrayList animals = new ArrayList(4);
        animals.add("cow");
        animals.add("horse");
        animals.add("dinosaur");
        animals.add("elephant");
        
        provisionOne.setName("water");
        toolOne.setName("shovel");
        
        /*
        ArrayList someGameTips = new ArrayList(4);
        someGameTips.add("plant more wheat on year 5");
        animals.add("use the tools you have");
        animals.add("learn to swim");
        animals.add("WHAT ARE YOU DOING??");
        */      

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
        System.out.println(yourPoint.toString());
        System.out.println(animalOne.toString());
        System.out.println(animals.toString());
        System.out.println(authorOne.toString());
        System.out.println(provisionOne.toString());
        System.out.println(toolOne.toString());
    }
}
