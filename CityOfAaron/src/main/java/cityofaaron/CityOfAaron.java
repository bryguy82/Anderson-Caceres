package cityofaaron;

import model.Game;

import view.StartProgramView;

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
    
    public static Game currentGame = null;    

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        CityOfAaron.currentGame = currentGame;
    }
    
    private static Player player = null;
    

    /**
     * The starting point for our application.
     * @param args Any parameters passed on the command line will be contained
     * in this array.
     */
    
    public static void main(String[] args) {
        
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.displayView();
        
    }
}
