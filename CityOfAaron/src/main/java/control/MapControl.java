/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Map;
import model.Location;
import model.Point;

/**
 *
 * @author Bryan
 */
public class MapControl {

    public MapControl() {
    }

    public static Map createMap() {

        Map map = new Map();
        Location[][] location = new Location[5][5];
        Point point = new Point();
        
        location[0][0] = new Location("V", "Valley", "later", new String[]{});
        location[0][1] = new Location("V", "Valley", "later", new String[]{});
        location[0][2] = new Location("W", "Wheat Field", "later", new String[]{});
        location[0][3] = new Location("R", "River", "later", new String[]{});
        location[0][4] = new Location("U", "Undeveloped Land", "later", new String[]{});
        
        location[1][0] = new Location("S", "The City's Granary and Storehouse", "later", new String[]{});
        location[1][1] = new Location("U", "Undeveloped Land", "later", new String[]{});
        location[1][2] = new Location("V", "Valley", "later", new String[]{});
        location[1][3] = new Location("R", "River", "later", new String[]{});
        location[1][4] = new Location("W", "Wheat Field", "later", new String[]{});
        
        location[2][0] = new Location("U", "Undeveloped Land", "later", new String[]{});
        location[2][1] = new Location("C", "The Ruler's Court", "later", new String[]{});
        location[2][2] = new Location("T", "The Temple", "later", new String[]{});
        location[2][3] = new Location("V", "Valley", "later", new String[]{});
        location[2][4] = new Location("R", "River", "later", new String[]{});
        
        location[3][0] = new Location("W", "Wheat Field", "later", new String[]{});
        location[3][1] = new Location("U", "Undeveloped Land", "later", new String[]{});
        location[3][2] = new Location("V", "Valley", "later", new String[]{});
        location[3][3] = new Location("R", "River", "later", new String[]{});
        location[3][4] = new Location("L", "The border of the Lamanite land", "later", new String[]{});
        
        location[4][0] = new Location("W", "Wheat Field", "later", new String[]{});
        location[4][1] = new Location("U", "Undeveloped Land", "later", new String[]{});
        location[4][2] = new Location("R", "River", "later", new String[]{});
        location[4][3] = new Location("L", "The border of the Lamanite land", "later", new String[]{});
        location[4][4] = new Location("W", "Wheat Field", "later", new String[]{});
        
        point = new Point(2, 2);
        map.setCurrentLocation(point);
        
        return map;
    }
}
