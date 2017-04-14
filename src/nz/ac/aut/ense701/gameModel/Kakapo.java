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
public class Kakapo extends Fauna{
    
    private boolean counted;
    private String representation;
    /**
     * Constructor for objects of class Kakapo
     * @param pos the position of the kakapo object
     * @param name the name of the kakapo object
     * @param description a longer description of the kakapo
     */
    public Kakapo(Position pos, String name, String description) 
    {
        super(pos, name, description);
        counted = false;
        representation  = "k"; 
    } 
    
    /**
    * Count this kakapo
    */
    public void count() {
        counted = true;
    }
 
   /**
    * Has this kakapo been counted
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
