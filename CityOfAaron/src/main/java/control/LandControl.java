/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author Bryan
 */
public class LandControl {

    public LandControl() {
        //Empty Constructor
    }

    public static void stringToInt(String[] string, int[] number) throws NumberFormatException {

        if (true) {
            for (int i = 0; i < number.length; i++) {
                number[i] = Integer.parseInt(string[i]);
            }
        } else {
            throw new NumberFormatException("Numerical value needed.");
        }
    }
}
