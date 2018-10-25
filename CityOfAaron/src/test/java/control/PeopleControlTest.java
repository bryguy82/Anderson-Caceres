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
    public void testCalculateMortality() {
        System.out.println("calculateMortality");
        int bushelsForFood = 0;
        int currentPopulation = 0;
        PeopleControl instance = new PeopleControl();
        int expResult = 0;
        int result = instance.calculateMortality(bushelsForFood, currentPopulation);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testCase1(){
        PeopleControl instance = new PeopleControl();
        int testing = instance.calculateMortality(2700, 105);
        int expResult = 0;
        assertEquals(expResult, testing, 0.01);
    }
    @Test
    public void testCase2(){
        PeopleControl instance = new PeopleControl();
        int testing = instance.calculateMortality(-1, 75);
        double expResult = -1;
        assertEquals(expResult, testing, 0.001);
    }
    @Test
    public void testCase3(){
        PeopleControl instance = new PeopleControl();
        int testing = instance.calculateMortality(75,-1);
        int expResult = -1;
        assertEquals(expResult, testing, 0.001);
    }
    @Test
    public void testCase4(){
        PeopleControl instance = new PeopleControl();
        int testing = instance.calculateMortality(2701, 75);
        int expResult = 0;
        assertEquals(expResult, testing, 0.01);
    }
    @Test
    public void testCase5(){
        PeopleControl instance = new PeopleControl();
        int testing = instance.calculateMortality(20, 1);
        int expResult = 0;
        assertEquals(expResult, testing, 0.01);
    }
    @Test
    public void testCase6(){
        PeopleControl instance = new PeopleControl();
        int testing = instance.calculateMortality(2100, 105);
        int expResult = 0;
        assertEquals(expResult, testing, 0.01);
    }
    @Test
    public void testCase7(){
        PeopleControl instance = new PeopleControl();
        int testing = instance.calculateMortality(2000, 105);
        int expResult = 5;
        assertEquals(expResult, testing, 0.01);
    }
}
