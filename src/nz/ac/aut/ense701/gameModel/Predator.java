package nz.ac.aut.ense701.gameModel;

/**
 * Predator represents a predator on the island.
 * If more specific behaviour is required for particular predators, descendants 
 * for this class should be created
 * @author AS
 * @version July 2011
 */
public class Predator extends Occupant
{

    /**
     * Constructor for objects of class Predator
     * @param position the position of the predator object
     * @param name the name of the predator object
     * @param description a longer description of the predator object
     */
    
    // Add variables in order to access to each predator's position.
    private Position position;  
//    private Position previousPredatorPos;
    private String name;
    private String description;
    public Predator(Position position, String name, String description) 
    {
        super(position, name, description);
        this.position = position;
        this.name = name;
        this.description = description;
//        this.previousPredatorPos = null;
    } 
 
    public Position getPosition()       // to access to each predator's position
    {
        return position;
    }
    
//    public Position getPreviousPredatorPos(){
//        return previousPredatorPos;
//    }
    
//    public void setPreviousPredatorPos(Position previousPredatorPos){
//        this.previousPredatorPos = previousPredatorPos;
//    }
    
    @Override
    public String getStringRepresentation() 
    {
        return "P";
    }    
    
    public void moveToPosition(Position newPosition)    // to change the current predator's position to new position.
    {
        if( (position == null))
        {
            throw new IllegalArgumentException("Null parameters");
        }else{
            this.position = newPosition;
        }  
    }
}
