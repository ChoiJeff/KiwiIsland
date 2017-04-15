/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gameModel;

/**
 *
 * @author OEM-PC
 */
public class Bat extends Fauna{
    private boolean counted;
    private String representation;
    /**
     * Constructor for objects of class Bat
     * @param pos the position of the bat object
     * @param name the name of the bat object
     * @param description a longer description of the bat
     */
    public Bat(Position pos, String name, String description) 
    {
        super(pos, name, description);
        counted = false;
        representation  = "B"; 
    } 
    
    /**
    * Count this bat
    */
    public void count() {
        counted = true;
    }
 
   /**
    * Has this bat been counted
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
