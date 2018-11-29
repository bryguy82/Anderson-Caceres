package model;

import java.io.Serializable;

public class Game implements Serializable {

    private Player thePlayer;
    private Map theMap;
    private Storehouse theStorehouse;
    private int yearNumber;
    private int peopleStarved;
    private int peopleMovedIn;
    private int currentPopulation;
    private int acresOwned;
    private int acresPlanted;
    private int bushelsHavestedPerAcre;
    private int totalBushelsHarvested;
    private int bushelsPaidInTithing;
    private int bushelsEatenByRats;
    private int wheatInStorage;
    private int bushelsToFeedThePeople;

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

    public int getYearNumber() {
        return yearNumber;
    }

    public void setYearNumber(int yearNumber) {
        this.yearNumber = yearNumber;
    }

    public int getPeopleStarved() {
        return peopleStarved;
    }

    public void setPeopleStarved(int peopleStarved) {
        this.peopleStarved = peopleStarved;
    }

    public int getPeopleMovedIn() {
        return peopleMovedIn;
    }

    public void setPeopleMovedIn(int peopleMovedIn) {
        this.peopleMovedIn = peopleMovedIn;
    }

    public int getAcresPlanted() {
        return acresPlanted;
    }

    public void setAcresPlanted(int acresPlanted) {
        this.acresPlanted = acresPlanted;
    }

    public int getBushelsHavestedPerAcre() {
        return bushelsHavestedPerAcre;
    }

    public void setBushelsHavestedPerAcre(int bushelsHavestedPerAcre) {
        this.bushelsHavestedPerAcre = bushelsHavestedPerAcre;
    }

    public int getTotalBushelsHarvested() {
        return totalBushelsHarvested;
    }

    public void setTotalBushelsHarvested(int totalBushelsHarvested) {
        this.totalBushelsHarvested = totalBushelsHarvested;
    }

    public int getBushelsPaidInTithing() {
        return bushelsPaidInTithing;
    }

    public void setBushelsPaidInTithing(int bushelsPaidInTithing) {
        this.bushelsPaidInTithing = bushelsPaidInTithing;
    }

    public int getBushelsEatenByRats() {
        return bushelsEatenByRats;
    }

    public void setBushelsEatenByRats(int bushelsEatenByRats) {
        this.bushelsEatenByRats = bushelsEatenByRats;
    }

    public int getBushelsToFeedThePeople() {
        return bushelsToFeedThePeople;
    }

    public void setBushelsToFeedThePeople(int bushelsToFeedThePeople) {
        this.bushelsToFeedThePeople = bushelsToFeedThePeople;
    }

    @Override
    public String toString() {
        return "Game { " + "thePlayer=" + thePlayer
                + ", theMap=" + theMap
                + ", theStorehouse=" + theStorehouse
                + " }";
    }

}
