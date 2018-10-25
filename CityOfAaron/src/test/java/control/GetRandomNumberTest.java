/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tonyc
 */
public class GetRandomNumberTest {

    @Test
    public void InputsNotNegatives() {
        int random = GameControl.getRandomNumber(-1, 10);
        assertEquals(-1, random);

        random = GameControl.getRandomNumber(10, -1);
        assertEquals(-1, random);

    }

    @Test
    public void InputOrderTest() {
        int random = GameControl.getRandomNumber(100, 10);
        assertEquals(-2, random);

        random = GameControl.getRandomNumber(5, 5);
        assertEquals(-2, random);

    }

    @Test
    public void MaxIntegerTest() {
        int random = GameControl.getRandomNumber(0, Integer.MAX_VALUE);
        assertEquals(-3, random);
    }

    @Test
    public void ValidRangeTest() {
        int[][] testRanges = new int[][]{
            {2, 20},
            {20, 40},
            {10, 11},
            {0, Integer.MAX_VALUE - 1}
        };
        for (int i = 0; i < testRanges.length; i++) {
            int low = testRanges[i][0];
            int high = testRanges[i][1];

            int random = GameControl.getRandomNumber(low, high);
            assertTrue(
                    String.format("%d is between %d and %d", random, low, high),
                    random >= low && random <= high
            );
        }
    }
}
