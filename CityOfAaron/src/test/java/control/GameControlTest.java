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
 * @author Bryan
 */
public class GameControlTest {
    
    public GameControlTest() {
    }

    /**
     * Test of getRandomNumber method, of class GameControl.
     */
    
    @Test //for positivie values
    public void TestPositiveValues(){
        int random = GameControl.getRandomNumber(-1, 10);
        assertEquals(-1, random);
        
        random = GameControl.getRandomNumber(10, -1);
        assertEquals(-1, random);
    }
    
    @Test //for low < high and low != high
    public void TestCompareHighLow(){
        int random = GameControl.getRandomNumber(90, 10);
        assertEquals(-2, random);
        
        random = GameControl.getRandomNumber(8, 8);
        assertEquals(-2, random);
    }
    
    @Test //for high < MAX_VALUE
    public void TestMaxHigh(){
        int random = GameControl.getRandomNumber(0, Integer.MAX_VALUE);
        assertEquals(-3, random);
    }
    
    @Test //valid ranges for the function
    public void TestValidValues(){
        int random1 = GameControl.getRandomNumber(4, 15);
        int random2 = GameControl.getRandomNumber(60, 70);
        int random3 = GameControl.getRandomNumber(30, 31);
        int random4 = GameControl.getRandomNumber(10, Integer.MAX_VALUE-1);

        System.out.println(random1 + " is between 4 and 15");
        System.out.println(random2 + " is between 60 and 70");
        System.out.println(random3 + " is between 30 and 31");
        System.out.println(random4 + " is between 10 and " + Integer.MAX_VALUE);
    }
}
