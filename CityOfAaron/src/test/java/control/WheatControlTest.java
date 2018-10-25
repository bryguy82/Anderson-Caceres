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
public class WheatControlTest {
    
    public WheatControlTest() {
        //empty constructor
    }

    /**
     * Test of calculateLossToRats method, of class WheatControl.
     */
    
    @Test
    public void testingNeg1(){
        int testing = WheatControl.calculateLossToRats(-1, 15);
        assertEquals(-1, testing);
    }
    @Test
    public void testingTithingNeg(){
        int testing = WheatControl.calculateLossToRats(1500, -1);
        assertEquals(-2, testing);
    }
    @Test
    public void testingTithingMax(){
        int testing = WheatControl.calculateLossToRats(1500, 101);
        assertEquals(-2, testing);
    }
    @Test
    public void testingTithingValid1(){
        int testing = WheatControl.calculateLossToRats(3000, 7);
        assertEquals(-3, testing);
    }
    @Test
    public void testingTithingValid2(){
        int testing = WheatControl.calculateLossToRats(3000, 10);
        assertEquals(-3, testing);
    }
    @Test
    public void testingTithingValid3(){
        int testing = WheatControl.calculateLossToRats(3000, 13);
        assertEquals(-3, testing);
    }
}
