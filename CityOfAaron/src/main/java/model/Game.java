
package model;
import java.io.Serializable;

public class Game implements Serializable{
    private Player thePlayer;
    private Map theMap;
    private Storehouse theStorehouse;
    private int currentPopulation;
    private int acresOwned;
    private int wheatInStorage;
    
    private Author theAuthor;
    private Animal theAnimal;
    private Condition theCondition;
    private InventoryItem theInventoryItem;
    private ItemType theItemType;
    private Location theLocation;
    private Point thePoint;
    private Provision theProvision;   
    private Tool theTool;  
    
    public Game(){
        //Empty Constructor for Javabeans
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
    
    public Author getTheAuthor() {
        return theAuthor;
    }

    public void setTheAuthor(Author theAuthor) {
        this.theAuthor = theAuthor;
    }

    public Animal getTheAnimal() {
        return theAnimal;
    }

    public void setTheAnimal(Animal theAnimal) {
        this.theAnimal = theAnimal;
    }

    public Condition getTheCondition() {
        return theCondition;
    }

    public void setTheCondition(Condition theCondition) {
        this.theCondition = theCondition;
    }

    public InventoryItem getTheInventoryItem() {
        return theInventoryItem;
    }

    public void setTheInventoryItem(InventoryItem theInventoryItem) {
        this.theInventoryItem = theInventoryItem;
    }

    public ItemType getTheItemType() {
        return theItemType;
    }

    public void setTheItemType(ItemType theItemType) {
        this.theItemType = theItemType;
    }

    public Location getTheLocation() {
        return theLocation;
    }

    public void setTheLocation(Location theLocation) {
        this.theLocation = theLocation;
    }

    public Point getThePoint() {
        return thePoint;
    }

    public void setThePoint(Point thePoint) {
        this.thePoint = thePoint;
    }

    public Provision getTheProvision() {
        return theProvision;
    }

    public void setTheProvision(Provision theProvision) {
        this.theProvision = theProvision;
    }

    public Tool getTheTool() {
        return theTool;
    }

    public void setTheTool(Tool theTool) {
        this.theTool = theTool;
    }    
    
    @Override
    public String toString() {
        return "Game{" + "thePlayer=" + thePlayer 
                + ", theMap=" + theMap 
                + ", theStorehouse=" + theStorehouse 
                + ", currentPopulation=" + currentPopulation 
                + ", acresOwned=" + acresOwned 
                + ", wheatInStorage=" + wheatInStorage 
                + ", theAuthor=" + theAuthor 
                + ", theAnimal=" + theAnimal 
                + ", theCondition=" + theCondition 
                + ", theInventoryItem=" + theInventoryItem 
                + ", theItemType=" + theItemType 
                + ", theLocation=" + theLocation 
                + ", thePoint=" + thePoint 
                + ", theTool=" + theTool
                + ", theProvision=" + theProvision + "}";
    }
    
    
    
}
