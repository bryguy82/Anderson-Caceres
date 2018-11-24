/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import static java.lang.Integer.min;
import model.Storehouse;
import model.Animal;
import model.Author;
import model.Condition;
import model.ItemType;
import model.InventoryItem;

/**
 *
 * @author tonyc
 */
public class StorehouseControl {

    public StorehouseControl() {
        // empty constructor
    }

    public static Storehouse createAnimalItems() {

        Storehouse storehouse = new Storehouse();

        Animal[] animal = new Animal[5];

        animal[0] = new Animal("Horse", ItemType.ANIMAL, 10, 7, Condition.FAIR);
        animal[1] = new Animal("Wolf", ItemType.ANIMAL, 5, 10, Condition.GOOD);
        animal[2] = new Animal("Donkey", ItemType.ANIMAL, 3, 2, Condition.POOR);
        animal[3] = new Animal("Goat", ItemType.ANIMAL, 20, 8, Condition.FAIR);
        animal[4] = new Animal("Chicken", ItemType.ANIMAL, 6, 11, Condition.GOOD);

        StorehouseControl.sortName(animal);
        System.out.println();
        for (Animal animals : animal) {

            System.out.println(animals.getName() + " " + animals.getAge() + "years old.");
        }
        System.out.println();

        storehouse.setAnimals(animal);

        return storehouse;
    }
    
    public static Author[] defineAuthors() {
        //Storehouse storehouse = new Storehouse();
        Author[] author = {
            new Author("Anderson", "Executive Programmer"),
            new Author("Caceres", "Executive Programmer")};
        
        return author;
    }
    
    //Bryan's assignment
    public static Storehouse createToolItems() {

        Storehouse storehouse = new Storehouse();
        InventoryItem[] tool = new InventoryItem[6];

        tool[0] = new InventoryItem("shovel", ItemType.TOOL, 7, Condition.GOOD);
        tool[1] = new InventoryItem("hammer", ItemType.TOOL, 3, Condition.POOR);
        tool[2] = new InventoryItem("saw", ItemType.TOOL, 2, Condition.FAIR);
        tool[3] = new InventoryItem("sword", ItemType.TOOL, 10, Condition.FAIR);
        tool[4] = new InventoryItem("bow", ItemType.TOOL, 7, Condition.GOOD);
        tool[5] = new InventoryItem("arrow", ItemType.TOOL, 15, Condition.POOR);

        StorehouseControl.sortQuantity(tool);
        System.out.println();
        System.out.println("Here is what you have: ");
        // print out quantity and name in order from 
        for (InventoryItem quantityName : tool) {
            System.out.println(quantityName.getQuantity() + " " + quantityName.getName());
        }

        System.out.println("You only have " + tool[0].getQuantity() + " " + tool[0].getName() + "s.");

        int total = 0;
        for (int i = 0; i < tool.length; i++) {
            total += tool[i].getQuantity();
        }
        System.out.println("The total amount of tools in storage is " + total + ".");
        System.out.println();

        storehouse.setTools(tool);
        return storehouse;
    }

    private static InventoryItem[] sortName(InventoryItem[] inventory) {
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

    private static InventoryItem[] sortQuantity(InventoryItem[] inventory) {
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
