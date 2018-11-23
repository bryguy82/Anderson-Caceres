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
public class Provision extends InventoryItem implements Serializable {

    private boolean perishable;

    public Provision() {
        // Constructor
    }
    
    public Provision(String name, ItemType type, int quantity, Condition condition){
        setName(name);
        setItemType(type);
        setQuantity(quantity);
        setCondition(condition);
    }

    public boolean isPerishable() {
        return perishable;
    }

    public void setPerishable(boolean perishable) {
        this.perishable = perishable;
    }

    @Override
    public String toString() {
        return "this provision is " + perishable;
    }
}
