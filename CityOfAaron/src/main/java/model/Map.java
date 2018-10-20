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
public class Map implements Serializable {
    
    private Location[][] locations = new Location[4][4];
    private Point currentLocation;
    
    public Map(){
        //Empty Constructor
    }

    public Location[][] getLocations() {
        return locations;
    }

    public void setLocations(Location[][] locations) {
        this.locations = locations;
    }

    public Point getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Point currentLocation) {
        this.currentLocation = currentLocation;
    }
    
    @Override
    public String toString(){
        return "Map location is: "
                + Arrays.toString(locations);
    }
}
