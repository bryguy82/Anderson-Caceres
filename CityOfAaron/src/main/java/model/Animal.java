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
public class Animal extends InventoryItem implements Serializable {

    private int age;

    public Animal() {
        //Empty constructor for animal
    }

    public Animal(String name, ItemType type, int age, int quantity, Condition condition) {
        setName(name);
        setItemType(type);
        setAge(age);
        setQuantity(quantity);
        setCondition(condition);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Age: " + age;
    }
}
