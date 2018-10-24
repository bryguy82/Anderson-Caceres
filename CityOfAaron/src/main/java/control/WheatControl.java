/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.util.Random;

/**
 *
 * @author Bryan
 */
public class WheatControl {
    
 
    /**
     * Calculate the total amount of bushels remaining after the rats.
     * @param remainingBushels is the amount of bushels
     * @param tithesAndOfferingsPercentage the percentage paid in offerings
     * @return 
     */

    public static int calculateLossToRats(int remainingBushels, int tithesAndOfferingsPercentage) {
        
//        if (getRandomNumber(int lowValue, int highValue) > 30) {
//		return -2;


//        if random number is < 30


//        if tithing = 10%;
//              return -3;   
        if (tithesAndOfferingsPercentage == 10){
            return -3;
        }

//        if (tithesAndOfferingsPercentage < 0 OR remainingBushels > 3000) {
//            return -1;
        if (tithesAndOfferingsPercentage < 0){
            return -1;
        }

//        If (tithesAndOfferingsPercentage > .12) {
//                return -3;
        if (tithesAndOfferingsPercentage > 12){
            return -3;
        }

//        } elseif (tithesAndOfferingsPercentage > .08) {
//                return -3;
        if (tithesAndOfferingsPercentage > 8){
            return -3;
        }

//        } else {
//                return -3;

                
        System.out.println("hi");
        
        return -1;
        
    }
    
}
