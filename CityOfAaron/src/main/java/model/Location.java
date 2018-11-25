/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author tonyc
 */
public class Location implements Serializable {

    private String mapSymbol;
    private String name;
    private String description;
    private String[] gameTips = new String[10];

    public Location() {
        // Constructor
    }

    public Location(String mapSymbol, String name, String description, String[] gameTips) {
        setMapSymbol(mapSymbol);
        setName(name);
        setDescription(description);
        setGameTips(gameTips);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMapSymbol() {
        return mapSymbol;
    }

    public void setMapSymbol(String mapSymbol) {
        this.mapSymbol = mapSymbol;
    }

    public String[] getGameTips() {
        return gameTips;
    }

    public void setGameTips(String[] gameTips) {
        this.gameTips = gameTips;
    }

    @Override
    public String toString() {
        return "Location{"
                + "You have selected " + name
                + " which is " + description
                + ".  It's represented by a " + mapSymbol
                + ".  One bushel can feed 20 people" + Arrays.toString(gameTips) + "}";
    }

}
