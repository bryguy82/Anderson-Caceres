/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.Serializable;
/**
 *
 * @author tonyc
 */
public class Tools implements Serializable {
    
    private String name;
    
    public Tools(){
        //constructor
        name = " Thor's Hammer";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tools{" + "name=" + name + "}";
    }
    
    
    
}
