/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import exception.GameControlException;
import org.junit.Test;
import static org.junit.Assert.*;
import exception.WheatControlException;

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
    public void testingNeg1() throws WheatControlException, GameControlException {
        int testing = WheatControl.calculateLossToRats(-1, 15);
        assertEquals(-1, testing);
    }

    //TODO remove comment-out and "import" throws like the @test above.
    @Test
    public void testingTithingNeg() throws WheatControlException, GameControlException {
        int testing = WheatControl.calculateLossToRats(1500, -1);
        assertEquals(-2, testing);
    }

    @Test
    public void testingTithingMax() throws WheatControlException, GameControlException {
        int testing = WheatControl.calculateLossToRats(1500, 101);
        assertEquals(-2, testing);
    }

    @Test
    public void testingTithingValid1() throws WheatControlException, GameControlException {
        int testing = WheatControl.calculateLossToRats(3000, 7);
        assertEquals(180, testing);
    }

    @Test
    public void testingTithingValid2() throws WheatControlException, GameControlException {
        int testing = WheatControl.calculateLossToRats(3000, 10);
        assertEquals(120, testing);
    }

    @Test
    public void testingTithingValid3() throws WheatControlException, GameControlException {
        int testing = WheatControl.calculateLossToRats(3000, 13);
        assertEquals(90, testing);//random test is producing 16 so it's below 30 for rats.
    }

    /**
     * Test of calculateHarvest method, of class WheatControl.
     */
    @Test
    public void testingBushelsNeg1() throws WheatControlException, GameControlException {
        int testing = WheatControl.calculateHarvest(-1, 15);
        assertEquals(-1, testing);
    }

    @Test
    public void testingTithingLow() throws WheatControlException, GameControlException {
        int testing = WheatControl.calculateHarvest(15, -1);
        assertEquals(-2, testing);
    }

    @Test//tithing
    public void testingTithingHigh() throws WheatControlException, GameControlException {
        int testing = WheatControl.calculateHarvest(15, 101);
        assertEquals(-2, testing);
    }

    @Test
    public void testingTithing1() throws WheatControlException, GameControlException {
        int testing = WheatControl.calculateHarvest(300, 6);
        assertEquals(300, testing);
    }

    @Test
    public void testingTithing2() throws WheatControlException, GameControlException {
        int testing = WheatControl.calculateHarvest(300, 9);
        assertEquals(900, testing);
    }

    @Test
    public void testingTithing3() throws WheatControlException, GameControlException {
        int testing = WheatControl.calculateHarvest(300, 13);
        assertEquals(600, testing);
    }
}
