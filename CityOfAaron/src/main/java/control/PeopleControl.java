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
public class PeopleControl {
    
    public PeopleControl(){
        //Empty constructor
    }
    
    public int calculateMortality(int bushelsForFood, int currentPopulation){
                
        if(bushelsForFood < 0){
            return -1;
        }
        if (currentPopulation < 0) {
            return -1;
        }
        int numberOfPeopleFed = bushelsForFood / 20;        
        
        if (numberOfPeopleFed >= currentPopulation) {
            return 0;
        } else {
            System.out.println("People who Died: "+(currentPopulation-numberOfPeopleFed));
            return currentPopulation - numberOfPeopleFed;
            
        }
    }    
}
