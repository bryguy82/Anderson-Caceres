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
    public void testingNeg1() {
        int testing = WheatControl.calculateLossToRats(-1, 15);
        assertEquals(-1, testing);
    }

    @Test
    public void testingTithingNeg() {
        int testing = WheatControl.calculateLossToRats(1500, -1);
        assertEquals(-2, testing);
    }

    @Test
    public void testingTithingMax() {
        int testing = WheatControl.calculateLossToRats(1500, 101);
        assertEquals(-2, testing);
    }

    @Test
    public void testingTithingValid1() {
        int testing = WheatControl.calculateLossToRats(3000, 7);
        assertEquals(180, testing);
    }

    @Test
    public void testingTithingValid2() {
        int testing = WheatControl.calculateLossToRats(3000, 10);
        assertEquals(120, testing);
    }

    @Test
    public void testingTithingValid3() {
        int testing = WheatControl.calculateLossToRats(3000, 13);
        assertEquals(90, testing);//random test is producing 16 so it's below 30 for rats.
    }

    /**
     * Test of calculateHarvest method, of class WheatControl.
     */
    @Test
    public void testingBushelsNeg1() {
        int testing = WheatControl.calculateHarvest(-1, 15);
        assertEquals(-1, testing);
    }

    @Test
    public void testingTithingLow() {
        int testing = WheatControl.calculateHarvest(15, -1);
        assertEquals(-2, testing);
    }

    @Test//tithing
    public void testingTithingHigh() {
        int testing = WheatControl.calculateHarvest(15, 101);
        assertEquals(-2, testing);
    }

    @Test
    public void testingTithing1() {
        int testing = WheatControl.calculateHarvest(300, 6);
        assertEquals(300, testing);
    }

    @Test
    public void testingTithing2() {
        int testing = WheatControl.calculateHarvest(300, 9);
        assertEquals(900, testing);
    }

    @Test
    public void testingTithing3() {
        int testing = WheatControl.calculateHarvest(300, 13);
        assertEquals(600, testing);
    }

}
