/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.*;

/**
 *
 * @author tonyc
 */
public class StorehouseControl {

    public StorehouseControl() {
        // empty constructor
    }

    public static Animal[] createAnimalItems() {

        Animal[] animal = new Animal[5];

        animal[0] = new Animal("Horse", ItemType.ANIMAL, 10, 7, Condition.FAIR);
        animal[1] = new Animal("Wolf", ItemType.ANIMAL, 5, 10, Condition.GOOD);
        animal[2] = new Animal("Donkey", ItemType.ANIMAL, 3, 2, Condition.POOR);
        animal[3] = new Animal("Goat", ItemType.ANIMAL, 20, 8, Condition.FAIR);
        animal[4] = new Animal("Chicken", ItemType.ANIMAL, 6, 11, Condition.GOOD);

        return animal;
    }

    public static Author[] defineAuthors() {
        //Storehouse storehouse = new Storehouse();
        Author[] author = {
            new Author("Anderson", "Executive Programmer"),
            new Author("Caceres", "Executive Programmer")};

        return author;
    }

    //Angel's Assigment    
    public static Provision[] createProvisions() {

        Provision[] provisions = new Provision[4];

        provisions[0] = new Provision("Wood", ItemType.PROVISIONS, 15, Condition.GOOD, false);
        provisions[1] = new Provision("Water", ItemType.PROVISIONS, 30, Condition.GOOD, false);
        provisions[2] = new Provision("Clothing", ItemType.PROVISIONS, 20, Condition.GOOD, false);
        provisions[3] = new Provision("Meat", ItemType.PROVISIONS, 5, Condition.GOOD, true);

        return provisions;
    }

    //Bryan's assignment
    public static InventoryItem[] createToolItems() {

        InventoryItem[] tool = new InventoryItem[6];

        tool[0] = new InventoryItem("shovel", ItemType.TOOL, 7, Condition.GOOD);
        tool[1] = new InventoryItem("hammer", ItemType.TOOL, 3, Condition.POOR);
        tool[2] = new InventoryItem("saw", ItemType.TOOL, 2, Condition.FAIR);
        tool[3] = new InventoryItem("sword", ItemType.TOOL, 10, Condition.FAIR);
        tool[4] = new InventoryItem("bow", ItemType.TOOL, 7, Condition.GOOD);
        tool[5] = new InventoryItem("arrow", ItemType.TOOL, 15, Condition.POOR);

        return tool;
    }

    public static Provision[] createProvisionItems() {

        Provision[] provision = new Provision[6];

        provision[0] = new Provision("water", ItemType.PROVISIONS, 8, Condition.GOOD, true);
        provision[1] = new Provision("clothing", ItemType.PROVISIONS, 15, Condition.FAIR, false);
        provision[2] = new Provision("blanket", ItemType.PROVISIONS, 50, Condition.POOR, false);
        provision[3] = new Provision("bread", ItemType.PROVISIONS, 60, Condition.GOOD, true);
        provision[4] = new Provision("pan", ItemType.PROVISIONS, 7, Condition.POOR, false);
        provision[5] = new Provision("meat", ItemType.PROVISIONS, 21, Condition.GOOD, true);

        return provision;
    }

    public static InventoryItem[] sortName(InventoryItem[] inventory) {
        for (int i = 0; i < inventory.length - 1; i++) {
            for (int j = i + 1; j < inventory.length; j++) {
                if (inventory[i].getName().compareTo(inventory[j].getName()) > 0) {
                    InventoryItem swap = inventory[i];
                    inventory[i] = inventory[j];
                    inventory[j] = swap;
                }
            }
        }
        return inventory;
    }

    public static InventoryItem[] sortQuantity(InventoryItem[] inventory) {
        // sort by quantity.
        for (int i = 0; i < inventory.length - 1; i++) {
            for (int j = i + 1; j < inventory.length; j++) {
                if (inventory[i].getQuantity() > inventory[j].getQuantity()) {
                    InventoryItem swap = inventory[i];
                    inventory[i] = inventory[j];
                    inventory[j] = swap;
                }
            }
        }
        return inventory;
    }
}
