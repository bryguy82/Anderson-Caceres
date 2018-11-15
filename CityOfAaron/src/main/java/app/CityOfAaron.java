

package app;

import model.Game;

import view.StartProgramView;
import view.View;
//import view.BuyLandView;
import view.SellLandView;


/*import model.Tool;*/
public class CityOfAaron {
    
    public static Game currentGame = null;

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        CityOfAaron.currentGame = currentGame;
    }
  
    

    /**
     * The starting point for our application.
     * @param args Any parameters passed on the command line will be contained
     * in this array.
     */
    
    public static void main(String[] args) {
        
      //View startProgramView = new StartProgramView();
       // startProgramView.displayView();
        
        //View buyLand = new BuyLandView();
        //buyLand.displayView();
        
        View sellLand = new SellLandView();
        sellLand.displayView();
    }
}
