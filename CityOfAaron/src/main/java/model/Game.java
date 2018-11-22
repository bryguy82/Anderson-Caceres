package model;

import java.io.Serializable;

public class Game implements Serializable {

    private Player thePlayer;
    private Map theMap;
    private Storehouse theStorehouse;
    private int currentPopulation = 100;//setting values to start
    private int acresOwned = 1000;//setting values to start
    private int wheatInStorage = 3000;//setting values to start
    private int yearNumber = 0;

    public int getYearNumber() {
        return yearNumber;
    }

    public void setYearNumber(int yearNumber) {
        this.yearNumber = yearNumber;
    }

    public Game() {
        //Empty Constructor
        
    }

    public Player getThePlayer() {
        return thePlayer;
    }

    public void setThePlayer(Player thePlayer) {
        this.thePlayer = thePlayer;
    }

    public Map getTheMap() {
        return theMap;
    }

    public void setTheMap(Map theMap) {
        this.theMap = theMap;
    }

    public Storehouse getTheStorehouse() {
        return theStorehouse;
    }

    public void setTheStorehouse(Storehouse theStorehouse) {
        this.theStorehouse = theStorehouse;
    }

    public int getCurrentPopulation() {
        return currentPopulation;
    }

    public void setCurrentPopulation(int currentPopulation) {
        this.currentPopulation = currentPopulation;
    }

    public int getAcresOwned() {
        return acresOwned;
    }

    public void setAcresOwned(int acresOwned) {
        this.acresOwned = acresOwned;
    }

    public int getWheatInStorage() {
        return wheatInStorage;
    }

    public void setWheatInStorage(int wheatInStorage) {
        this.wheatInStorage = wheatInStorage;
    }

    @Override
    public String toString() {
        return "Game { " + "thePlayer=" + thePlayer
                + ", theMap=" + theMap
                + ", theStorehouse=" + theStorehouse
                + " }";
    }

}
