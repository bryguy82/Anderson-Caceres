/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable{
    
    private String name;
    private ArrayList<Game> Games = new ArrayList<>();
    
    public Player(){
        //Empty Constructor  
        name = " Tony ";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Game> getGames() {
        return Games;
    }

    public void setGames(ArrayList<Game> Games) {
        this.Games = Games;
    }

    
    @Override
    public String toString(){
        return "Player name is " + name;
    }
    
}
