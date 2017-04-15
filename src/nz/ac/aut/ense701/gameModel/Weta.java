/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gameModel;

import nz.ac.aut.ense701.gameModel.Fauna;
import nz.ac.aut.ense701.gameModel.Position;

/**
 *
 * @author OEM-PC
 */
public class Weta extends Fauna{
    
    private boolean counted;
    private String representation;
    /**
     * Constructor for objects of class Weta
     * @param pos the position of the weta object
     * @param name the name of the weta object
     * @param description a longer description of the weta
     */
    public Weta(Position pos, String name, String description) 
    {
        super(pos, name, description);
        counted = false;
        representation  = "W"; 
    } 
    
    /**
    * Count this weta
    */
    public void count() {
        counted = true;
    }
 
   /**
    * Has this weta been counted
    * @return true if counted.
    */
    public boolean counted() {
        return counted;
    }


    @Override
    public String getStringRepresentation() 
    {
        return representation;
    }
    
    public void setStringRepresentation(String representation)
    {
        this.representation = representation;
    }
}
