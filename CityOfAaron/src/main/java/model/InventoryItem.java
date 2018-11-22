/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Bryan
 */
public class InventoryItem implements Serializable {

    private String name;
    private ItemType itemType;
    private int quantity;
    private Condition condition;

    public InventoryItem() {
        //Empty Constructor    
    }
    
    // TODO make a contructor with all of the variables above

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "This is a " + itemType
                + ".  You have " + quantity + name
                + "'s in a " + condition
                + " condition.";
    }
}
