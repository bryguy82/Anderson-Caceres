package app;

import model.Game;

import view.StartProgramView;
import view.View;

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
     *
     * @param args Any parameters passed on the command line will be contained
     * in this array.
     */
    public static void main(String[] args) {

        try {
            View startProgramView = new StartProgramView();
            startProgramView.displayView();
        } catch (Throwable err) {
            System.out.println(err.getMessage());
            err.printStackTrace();// this prints out the calling chain
        }
    }
}
