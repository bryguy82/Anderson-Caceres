/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author bryguy82
 */
import java.io.Serializable;
import java.util.Arrays;

public class Storehouse implements Serializable {

    private Author[] authors = new Author[5];
    private Animal[] animals = new Animal[5];
    private InventoryItem[] tools = new InventoryItem[5];
    private Provision[] provisions = new Provision[5];

    public Storehouse() {
        //Empty constructor
    }

    public Author[] getAuthors() {
        return authors;
    }

    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public void setAnimals(Animal[] animals) {
        this.animals = animals;
    }

    public InventoryItem[] getTools() {
        return tools;
    }

    public void setTools(InventoryItem[] tools) {
        this.tools = tools;
    }

    public Provision[] getProvisions() {
        return provisions;
    }

    public void setProvisions(Provision[] provisions) {
        this.provisions = provisions;
    }

    @Override
    public String toString() {
        return "Currently in the Storehouse you have: {"
                + " these authors: " + Arrays.toString(authors)
                + ", these animals: " + Arrays.toString(animals)
                + ", these tools: " + Arrays.toString(tools)
                + ", and these provisions: " + Arrays.toString(provisions)
                + "}";
    }
}
