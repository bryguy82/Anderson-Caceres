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

        location[0][0] = new Location("V", "Valley", "What a great ruler you are.  You have come to visit your people.", new String[]{});
        location[0][1] = new Location("V", "Valley", "What a great ruler you are.  You have come to visit your people.", new String[]{});
        location[0][2] = new Location("W", "Wheat Field", "Great choice!  These wheat fields are so beautiful to gaze upon.", new String[]{});
        location[0][3] = new Location("R", "River", "You've landed near a river.  The water hereis fresh and clean.", new String[]{});
        location[0][4] = new Location("U", "Undeveloped Land", "I'm sorry, there isn't anthing located at this location.", new String[]{});

        location[1][0] = new Location("S", "The City's Granary and Storehouse", "Welcome to the city's Granary and Storehouse.", new String[]{});
        location[1][1] = new Location("U", "Undeveloped Land", "I'm sorry, there isn't anthing located at this location.", new String[]{});
        location[1][2] = new Location("V", "Valley", "What a great ruler you are.  You have come to visit your people.", new String[]{});
        location[1][3] = new Location("R", "River", "You've landed near a river.  The water hereis fresh and clean.", new String[]{});
        location[1][4] = new Location("W", "Wheat Field", "Great choice!  These wheat fields are so beautiful to gaze upon.", new String[]{});

        location[2][0] = new Location("U", "Undeveloped Land", "I'm sorry, there isn't anthing located at this location.", new String[]{});
        location[2][1] = new Location("C", "The Ruler's Court", "Welcome to the Ruler's court.  So far you have done a decent job of feeding the people.", new String[]{});
        location[2][2] = new Location("T", "The Temple", "Did you know the Nephites built temples?  That's right.  You can read more about it in the Book of Mormon in 2 Nephi 5:16.", new String[]{});
        location[2][3] = new Location("V", "Valley", "What a great ruler you are.  You have come to visit your people.", new String[]{});
        location[2][4] = new Location("R", "River", "You've landed near a river.  The water hereis fresh and clean.", new String[]{});

        location[3][0] = new Location("W", "Wheat Field", "Great choice!  These wheat fields are so beautiful to gaze upon.", new String[]{});
        location[3][1] = new Location("U", "Undeveloped Land", "I'm sorry, there isn't anthing located at this location.", new String[]{});
        location[3][2] = new Location("V", "Valley", "What a great ruler you are.  You have come to visit your people.", new String[]{});
        location[3][3] = new Location("R", "River", "You've landed near a river.  The water hereis fresh and clean.", new String[]{});
        location[3][4] = new Location("L", "The border of the Lamanite land", "You are in the borders near the Lamanites.", new String[]{});

        location[4][0] = new Location("W", "Wheat Field", "Great choice!  These wheat fields are so beautiful to gaze upon.", new String[]{});
        location[4][1] = new Location("U", "Undeveloped Land", "I'm sorry, there isn't anthing located at this location.", new String[]{});
        location[4][2] = new Location("R", "River", "You've landed near a river.  The water hereis fresh and clean.", new String[]{});
        location[4][3] = new Location("L", "The border of the Lamanite land", "You are in the borders near the Lamanites.", new String[]{});
        location[4][4] = new Location("W", "Wheat Field", "Great choice!  These wheat fields are so beautiful to gaze upon.", new String[]{});

        map.setLocations(location);

        point = new Point(2, 2);
        map.setCurrentLocation(point);

        return map;
    }
}
/*Tips
            "Remember that winning the game relies on keeping this filled enough to feed your people."
            "Did you remember to pay your tithing?  You get a bonus."
            "Remember that you need 20 bushels to feed 1 person in a year."*/
