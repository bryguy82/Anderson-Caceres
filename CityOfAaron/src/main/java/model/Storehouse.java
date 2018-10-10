/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author tonyc
 */
public class Storehouse {

    private Author[] authors;
    private Animal[] animals;
    private InventoryItem[] tools;
    private Provision[] provisions;
    
    public Storehouse(){
        //Empty constructor
    }
    
    public Author[] getAuthors(){
        return authors;
    }
    public void setAuthors(Author[] authors){
        this.authors = authors;
    }
    public Animal[] getAnimals(){
        return animals;
    }
    public void setAnimals(Animal[] animals){
        this.animals = animals;
    }
    public InventoryItem[] getTools(){
        return tools;
    }
    public void setTools(InventoryItem[] InventoryItem){
        this.tools = tools;
    }
    public Provision[] getProvisions(){
        return provisions;
    }
    public void setProvisions(Provision[] provisions){
        this.provisions = provisions;
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
