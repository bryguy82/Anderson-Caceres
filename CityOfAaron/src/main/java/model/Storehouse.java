/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.ArrayList;
/**
 *
 * @author bryguy82
 */
public class Storehouse {

    private Author[] authors;
    private Animal[] animals;
    private InventoryItem[] tools;
    private Provision[] provisions;
    private Game Game;
    
    private ArrayList<Author> authorNames = new ArrayList<>();
    private ArrayList<Animal> animalNames = new ArrayList<>();
    private ArrayList<Provision> food = new ArrayList<>();
    private ArrayList<Tool> toolName = new ArrayList<>();
    private ArrayList<InventoryItem> inventory = new ArrayList<>();
    
    public Storehouse(){
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

    public ArrayList<Author> getAuthorNames() {
        return authorNames;
    }

    public void setAuthorNames(ArrayList<Author> authorNames) {
        this.authorNames = authorNames;
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

    public ArrayList<InventoryItem> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<InventoryItem> inventory) {
        this.inventory = inventory;
    }

    
    @Override
    public String toString(){
        return "Currently in the Storehouse you have: {"
                + " these authors: " + authors
                + ", these animals: " + animals
                + ", these tools: " + tools
                + ", and these provisions: " + provisions
                + "}";
    }
}
