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
public class PeopleControlTest {

    public PeopleControlTest() {
    }

    /**
     * Test of calculateMortality method, of class PeopleControl.
     */

    @Test
    public void testCase1() {
        int testing = PeopleControl.calculateMortality(2700, 105);
        int expResult = 0;
        assertEquals(expResult, testing);
    }

    @Test
    public void testCase2() {
        int testing = PeopleControl.calculateMortality(-1, 75);
        double expResult = -1;
        assertEquals(expResult, testing, 0.01);
    }

    @Test
    public void testCase3() {
        int testing = PeopleControl.calculateMortality(75, -1);
        int expResult = -1;
        assertEquals(expResult, testing);
    }

    @Test
    public void testCase4() {
        int testing = PeopleControl.calculateMortality(2701, 75);
        int expResult = 0;
        assertEquals(expResult, testing);
    }

    @Test
    public void testCase5() {
        int testing = PeopleControl.calculateMortality(20, 1);
        int expResult = 0;
        assertEquals(expResult, testing);
    }

    @Test
    public void testCase6() {
        int testing = PeopleControl.calculateMortality(2100, 105);
        int expResult = 0;
        assertEquals(expResult, testing);
    }

    @Test
    public void testCase7() {
        int testing = PeopleControl.calculateMortality(2000, 105);
        int expResult = 5;
        assertEquals(expResult, testing);
    }
}
