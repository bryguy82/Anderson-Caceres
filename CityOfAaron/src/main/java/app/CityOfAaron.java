

package app;


import model.Game;
import model.Map;
import model.Player;
import model.Storehouse;

import model.Author;
import model.Animal;
import model.InventoryItem;
import model.Location;
import model.Point;
import model.Provision;
import model.ItemType;
import model.Condition;
/*import model.Tool;*/


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
        
        //initate play and set a value
        Player thePlayer = new Player();
        thePlayer.setName("Charlot");
        
        //initate map and call functions
        Map theMap = new Map();
        theMap.getCurrentLocation();
        theMap.getLocations();
        
        //initiate location and set values
        Location yourLocation = new Location();
        yourLocation.setName("undeveloped land");
        yourLocation.setDescription("a good spot!");
        yourLocation.setMapSymbol("&");
        yourLocation.setGameTips(new String[] {"try harder", "you can do it"});
        
        //initate point and set values
        Point yourPoint = new Point();
        yourPoint.setColumn(2);
        yourPoint.setRow(1);
        
        //initate animal and set values
        Animal animalOne = new Animal();
        animalOne.setName("Horse");
        animalOne.setAge(15);
        animalOne.setCondition(Condition.FAIR);
        animalOne.setItemType(ItemType.ANIMAL);
        animalOne.setQuantity(5);
        
        //initiate author and set values
        Author authorOne = new Author();
        authorOne.setTitle("Mr.");
        authorOne.setName("Mormon");
        
        //initate inventory and set values
        InventoryItem itemOne = new InventoryItem();
        itemOne.setName("shovel");
        itemOne.setCondition(Condition.GOOD);
        itemOne.setItemType(ItemType.TOOL);
        itemOne.setQuantity(8);
        
        //initate provision and set values
        Provision provisionOne = new Provision();
        provisionOne.setName("water");
        provisionOne.setPerishable(true);
        provisionOne.setCondition(Condition.POOR);
        provisionOne.setItemType(ItemType.PROVISIONS);
        provisionOne.setQuantity(5);
        
        //initate storehouse and set values
        Storehouse theStorehouse = new Storehouse();
        theStorehouse.setAnimals(new Animal[] {animalOne});
        theStorehouse.setAuthors(new Author[] {authorOne});
        theStorehouse.setProvisions(new Provision[] {provisionOne});
        theStorehouse.setTools(new InventoryItem[] {itemOne});
        
        /*
        Tool toolOne = new Tool();
        toolOne.setName("shovel");
        */
        
        System.out.println(theGame.toString());
        System.out.println(thePlayer.toString());
        System.out.println(theMap.toString());
        System.out.println(yourLocation.toString());
        System.out.println(yourPoint.toString());
        System.out.println(animalOne.toString());
        System.out.println(authorOne.toString());
        System.out.println(itemOne.toString());
        System.out.println(provisionOne.toString());
        System.out.println(theStorehouse.toString());
        
        //System.out.println(toolOne.toString());
    }
}
