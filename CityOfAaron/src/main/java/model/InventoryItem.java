/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Bryan
 */
public class InventoryItem implements Serializable{
    
    private ItemType itemType;
    private int quantity;
    private boolean condition;
    
    private ArrayList<Animal> animalNames = new ArrayList<>();
    private ArrayList<Provision> food = new ArrayList<>();
    private ArrayList<Tool> toolName = new ArrayList<>();
    
    public InventoryItem(){
        //Empty Constructor    
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isCondition() {
        return condition;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }

    public ArrayList<Animal> getAnimalNames() {
        return animalNames;
    }

    public void setAnimalNames(ArrayList<Animal> animalNames) {
        this.animalNames = animalNames;
    }

    public ArrayList<Provision> getFood() {
        return food;
    }

    public void setFood(ArrayList<Provision> food) {
        this.food = food;
    }

    public ArrayList<Tool> getToolName() {
        return toolName;
    }

    public void setToolName(ArrayList<Tool> toolName) {
        this.toolName = toolName;
    }

    
    @Override
    public String toString(){
        return "work in progress";
    }
}
