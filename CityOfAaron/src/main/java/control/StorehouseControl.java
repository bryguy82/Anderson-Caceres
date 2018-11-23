/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Storehouse;
import model.Animal;
import model.Condition;
import model.ItemType;

/**
 *
 * @author tonyc
 */
public class StorehouseControl {
    
    public StorehouseControl(){
        // empty constructor
    }
    
    public static Storehouse createStoreHouseItems(){
        
        Storehouse storeHouse = new Storehouse();
        Animal[] animal = new Animal[5];
        
        animal[0] = new Animal("Horse", ItemType.ANIMAL, 10, 7, Condition.FAIR);
        animal[1] = new Animal("Wolf", ItemType.ANIMAL, 5, 10, Condition.GOOD);
        animal[2] = new Animal("Donkey", ItemType.ANIMAL, 3, 2, Condition.POOR);
        animal[3] = new Animal("Goat", ItemType.ANIMAL, 20, 8, Condition.FAIR);
        animal[4] = new Animal("Chicken", ItemType.ANIMAL, 6, 11, Condition.GOOD);
        
        for (int i=0; i<animal.length-1; i++) {
            for (int j=i+1; j<animal.length; j++){
                if(animal[i].getName().compareTo(animal[j].getName())>0){
                    Animal swap = animal[i];
                    animal[i]=animal[j];
                    animal[j]=swap;
                }
            }
        }
        
        for (Animal animals: animal){
            System.out.println(animals.getName());
        }
        
        storeHouse.setAnimals(animal);
        
        return storeHouse;
    }
    
}
