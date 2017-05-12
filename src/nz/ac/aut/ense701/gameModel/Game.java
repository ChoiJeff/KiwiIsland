package nz.ac.aut.ense701.gameModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

/**
 * This is the class that knows the Kiwi Island game rules and state
 * and enforces those rules.
 *
 * @author AS
 * @version 1.0 - created
 * Maintenance History
 * August 2011 Extended for stage 2. AS
 */

public class Game
{
    //Constants shared with UI to provide player data
    public static final int STAMINA_INDEX = 0;
    public static final int MAXSTAMINA_INDEX = 1;
    public static final int MAXWEIGHT_INDEX = 2;
    public static final int WEIGHT_INDEX = 3;
    public static final int MAXSIZE_INDEX = 4;
    public static final int SIZE_INDEX = 5;
    
    /**
     * A new instance of Kiwi island that reads data from "IslandData.txt".
     */
    public Game() 
    {   
        eventListeners = new HashSet<GameEventListener>();

        createNewGame();
    }
    
    
    /**
     * Starts a new game.
     * At this stage data is being read from a text file
     */
    public void createNewGame()
    {
        totalPredators = 0;
        predators = new ArrayList<Predator>();  // to keep the list of predators
        totalKiwis = 0;
        predatorsTrapped = 0;
        kiwiCount = 0;
        //initialiseIslandFromFile("IslandData.txt"); original
        initialiseIslandFromFile("IslandData2.txt"); // for testing with added fauna
        //initialiseIslandFromFile("IslandData3.txt"); // for testing with predator
        drawIsland();
        state = GameState.PLAYING;
        winMessage = "";
        loseMessage = "";
        playerMessage = "";
        notifyGameEventListeners();
        }

    /***********************************************************************************************************************
     * Accessor methods for game data
    ************************************************************************************************************************/
    
    /**
     * Get number of rows on island
     * @return number of rows.
     */
    public int getNumRows()
    {
        return island.getNumRows();
    }
    
    /**
     * Get number of columns on island
     * @return number of columns.
     */
    public int getNumColumns()
    {
        return island.getNumColumns();
    }
    
    /**
     * Gets the current state of the game.
     * 
     * @return the current state of the game
     */
    public GameState getState()
    {
        return state;
    }    
 
    /**
     * Provide a description of occupant
     * @param whichOccupant
     * @return description if whichOccuoant is an instance of occupant, empty string otherwise
     */
    public String getOccupantDescription(Object whichOccupant)
    {
       String description = "";
        if(whichOccupant !=null && whichOccupant instanceof Occupant)
        {
            Occupant occupant = (Occupant) whichOccupant;
            description = occupant.getDescription();
        }
        return description;
    }
 
        /**
     * Gets the player object.
     * @return the player object
     */
    public Player getPlayer()
    {
        return player;
    }
    
    /**
     * Checks if possible to move the player in the specified direction.
     * 
     * @param direction the direction to move
     * @return true if the move was successful, false if it was an invalid move
     */
    public boolean isPlayerMovePossible(MoveDirection direction)
    {
        boolean isMovePossible = false;
        // what position is the player moving to?
        Position newPosition = player.getPosition().getNewPosition(direction);
        // is that a valid position?
        if ( (newPosition != null) && newPosition.isOnIsland() )
        {
            // what is the terrain at that new position?
            Terrain newTerrain = island.getTerrain(newPosition);
            // can the playuer do it?
            isMovePossible = player.hasStaminaToMove(newTerrain) && 
                             player.isAlive();
        }
        return isMovePossible;
    }
    
    public boolean isPredatorMovePossible(MoveDirection direction, Occupant predator)
    {
        boolean isMovePossible = false;
        
        Position newPosition = predator.getPosition().getNewPosition(direction);
        if( (newPosition != null) && newPosition.isOnIsland() &&        // to check the condition whether or not predator's new position 
                island.getTerrain(newPosition) != Terrain.WATER // is on the Water to avoid predator go to water.
                && !island.getOccupantStringRepresentation(newPosition).contains("H")) // does not contain a Hazard /// check this    
        {
            //Terrain newTerrain = island.getTerrain(newPosition);
            
            isMovePossible = true;  // need to think of what should put
        }
        else{
            isMovePossible = false; // need to be changed
        }
        return isMovePossible;
    }        
    
      /**
     * Get terrain for position
     * @param row
     * @param column
     * @return Terrain at position row, column
     */
    public Terrain getTerrain(int row, int column) {
        return island.getTerrain(new Position(island, row, column));
    }

    /**
     * Is this position visible?
     * @param row
     * @param column
     * @return true if position row, column is visible
     */
    public boolean isVisible(int row, int column) {
        return island.isVisible(new Position(island, row, column));

    }
   
    /**
    * Is this position explored?
    * @param row
    * @param column
    * @return true if position row, column is explored.
    */
    public boolean isExplored(int row, int column) {
        return island.isExplored(new Position(island, row, column));
    }

    /**
     * Get occupants for player's position
     * @return occupants at player's position
     */
    public Occupant[] getOccupantsPlayerPosition()
    {
        return island.getOccupants(player.getPosition());
    }
    
    /**
     * Get string for occupants of this position
     * @param row
     * @param column
     * @return occupant string for this position row, column
     */
    public String getOccupantStringRepresentation(int row, int column) {
        return island.getOccupantStringRepresentation(new Position(island, row, column));
    }
    
    /**
     * Get values from player for GUI display
     * @return player values related to stamina and backpack.
     */
    public int[] getPlayerValues()
    {
        int[] playerValues = new int[6];
        playerValues[STAMINA_INDEX ]= (int) player.getStaminaLevel();
        playerValues[MAXSTAMINA_INDEX]= (int) player.getMaximumStaminaLevel();
        playerValues[MAXWEIGHT_INDEX ]= (int) player.getMaximumBackpackWeight();
        playerValues[WEIGHT_INDEX]= (int) player.getCurrentBackpackWeight();
        playerValues[MAXSIZE_INDEX ]= (int) player.getMaximumBackpackSize();
        playerValues[SIZE_INDEX]= (int) player.getCurrentBackpackSize();
            
        return playerValues;
        
    }
    
    /**
     * How many kiwis have been counted?
     * @return count
     */
    public int getKiwiCount()
    {
        return kiwiCount;
    }
    
    /**
     * How many endangered species counted
     * @return 
     */
    public int getEndangeredCount(){
        return endangeredCount;
    }
    
    /**
     * How many predators are left?
     * @return number remaining
     */
    public int getPredatorsRemaining()
    {
        return totalPredators - predatorsTrapped;
    }
    
    public int getPoints()
    {
        return points;
    }
    
    /**
     * Get contents of player backpack
     * @return objects in backpack
     */
    public Object[] getPlayerInventory()
            {
              return  player.getInventory().toArray();
            }
    
    /**
     * Get player name
     * @return player name
     */
    public String getPlayerName()
    {
        return player.getName();
    }

    /**
     * Is player in this position?
     * @param row
     * @param column
     * @return true if player is at row, column
     */
    public boolean hasPlayer(int row, int column) 
    {
        return island.hasPlayer(new Position(island, row, column));
    }
    
    /**
     * Only exists for use of unit tests
     * @return island
     */
    public Island getIsland()
    {
        return island;
    }
    
    /**
     * Draws the island grid to standard output.
     */
    public void drawIsland()
    {  
          island.draw();
    }
    
     /**
     * Is this object collectable
     * @param itemToCollect
     * @return true if is an item that can be collected.
     */
    public boolean canCollect(Object itemToCollect)
    {
        boolean result = (itemToCollect != null)&&(itemToCollect instanceof Item);
        if(result)
        {
            Item item = (Item) itemToCollect;
            result = item.isOkToCarry();
        }
        return result;
    }
    
    /**
     * Is this object a countable kiwi or endangered species
     * @param itemToCount
     * @return true if is an item is a kiwi or an endangered species.
     */
    public boolean canCount(Object itemToCount)
    {
        boolean result = (itemToCount != null)&&(itemToCount instanceof Kiwi
                || itemToCount instanceof Kakapo
                || itemToCount instanceof Bat
                || itemToCount instanceof Weta
                || itemToCount instanceof Tuatara); 
        if(result && itemToCount instanceof Kiwi)
        {
            Kiwi kiwi = (Kiwi) itemToCount;
            result = !kiwi.counted();
        }
        else if(result && itemToCount instanceof Kakapo){
            Kakapo kakapo = (Kakapo) itemToCount;
            result = !kakapo.counted();
        }
        else if(result && itemToCount instanceof Bat){
            Bat bat = (Bat) itemToCount;
            result = !bat.counted();
        }
        else if(result && itemToCount instanceof Weta){
            Weta weta = (Weta) itemToCount;
            result = !weta.counted();
        }
        else if(result && itemToCount instanceof Tuatara){
            Tuatara tuatara = (Tuatara) itemToCount;
            result = !tuatara.counted();
        }
        return result;
    }
    /**
     * Is this object usable
     * @param itemToUse
     * @return true if is an item that can be collected.
     */
    public boolean canUse(Object itemToUse)
    {
        boolean result = (itemToUse != null)&&(itemToUse instanceof Item);
        if(result)
        {
            //Food can always be used (though may be wasted)
            // so no need to change result

            if(itemToUse instanceof Tool)
            {
                Tool tool = (Tool)itemToUse;
                //Traps can only be used if there is a predator to catch
                if(tool.isTrap())
                {
                    result = island.hasPredator(player.getPosition());
                }
                //Screwdriver can only be used if player has a broken trap
                else if (tool.isScrewdriver() && player.hasTrap())
                {
                    result = player.getTrap().isBroken();
                }
                else
                {
                    result = false;
                }
            }            
        }
        return result;
    }
    
        
    /**
     * Details of why player won
     * @return winMessage
     */
    public String getWinMessage()
    {
        return winMessage;
    }
    
    /**
     * Details of why player lost
     * @return loseMessage
     */
    public String getLoseMessage()
    {
        return loseMessage;
    }
    
    /**
     * Details of information for player
     * @return playerMessage
     */
    public String getPlayerMessage()
    {
        String message = playerMessage;
        playerMessage = ""; // Already told player.
        return message;
    }
    
    /**
     * Is there a message for player?
     * @return true if player message available
     */
    public boolean messageForPlayer() {
        return !("".equals(playerMessage));
    }
    
    /***************************************************************************************************************
     * Mutator Methods
    ****************************************************************************************************************/
    
   
    
    /**
     * Picks up an item at the current position of the player
     * Ignores any objects that are not items as they cannot be picked up
     * @param item the item to pick up
     * @return true if item was picked up, false if not
     */
    public boolean collectItem(Object item)
    {
        boolean success = (item instanceof Item) && (player.collect((Item)item));
        if(success)
        {
            // player has picked up an item: remove from grid square
            island.removeOccupant(player.getPosition(), (Item)item);
            
            
            // everybody has to know about the change
            notifyGameEventListeners();
        }      
        return success;
    } 

    
    /**
     * Drops what from the player's backpack.
     *
     * @param what  to drop
     * @return true if what was dropped, false if not
     */
    public boolean dropItem(Object what)
    {
        boolean success = player.drop((Item)what);
        if ( success )
        {
            // player has dropped an what: try to add to grid square
            Item item = (Item)what;
            success = island.addOccupant(player.getPosition(), item);
            if ( success )
            {
                // drop successful: everybody has to know that
                notifyGameEventListeners();
            }
            else
            {
                // grid square is full: player has to take what back
                player.collect(item);                     
            }
        }
        return success;
    } 
      
    
    /**
     * Uses an item in the player's inventory.
     * This can  be food or tool items.
     * @param item to use
     * @return true if the item has been used, false if not
     */
    public boolean useItem(Object item)
    {  
        boolean success = false;
        if ( item instanceof Food && player.hasItem((Food) item) )
        //Player east food to increase stamina
        {
            Food food = (Food) item;
            // player gets energy boost from food
            player.increaseStamina(food.getEnergy());
            // player has consumed the food: remove from inventory
            player.drop(food);
            // use successful: everybody has to know that
            notifyGameEventListeners();
        }
        else if (item instanceof Tool)
        {
            Tool tool = (Tool) item;
            if (tool.isTrap()&& !tool.isBroken())
            {
                 success = trapPredator(); 
            }
            else if(tool.isScrewdriver())// Use screwdriver (to fix trap)
            {
                if(player.hasTrap())
                    {
                        Tool trap = player.getTrap();
                        trap.fix();
                    }
            }
        }
        updateGameState();
        return success;
    }
    
    /**
     * Count any kiwis in this position
     * modified to use for count other endangered also
     */
    public void countKiwi() 
    {
        //check if there are any kiwis here
        for (Occupant occupant : island.getOccupants(player.getPosition())) {
            if (occupant instanceof Kiwi) {
                Kiwi kiwi = (Kiwi) occupant;
                if (!kiwi.counted()) {
                    kiwi.count();
                    kiwi.setStringRepresentation("KC"); // kiwi counted.
                    kiwiCount++;
                    points += 10;
                    
                }
            }
            else if(occupant instanceof Bat){
                Bat bat = (Bat) occupant;
                if(!bat.counted()){
                    bat.count();
                    bat.setStringRepresentation("BC");
                    endangeredCount++;
                    points += 5;
                    
                }
            }
            else if(occupant instanceof Kakapo){
                Kakapo kakapo = (Kakapo) occupant;
                if(!kakapo.counted()){
                    kakapo.count();
                    kakapo.setStringRepresentation("kC");
                    endangeredCount++;
                    points += 5;
                    
                }
            }
            else if(occupant instanceof Tuatara){
                Tuatara tuatara = (Tuatara) occupant; 
                if(!tuatara.counted()){
                    tuatara.count();
                    tuatara.setStringRepresentation("tC");
                    endangeredCount++;
                    points += 5;
                    
                }
            }
            else if(occupant instanceof Weta){
                Weta weta = (Weta) occupant;
                if(!weta.counted()){
                    weta.count();
                    weta.setStringRepresentation("WC");
                    endangeredCount++;
                    points += 5;
                    
                }
                
            }
        }
        updateGameState();
    }
       
    public void kiwiCounted()
    {
        
    }
       
    /**
     * Attempts to move the player in the specified direction.
     * 
     * @param direction the direction to move
     * @return true if the move was successful, false if it was an invalid move
     */
    public boolean playerMove(MoveDirection direction)
    {
        // what terrain is the player moving on currently
        boolean successfulMove = false;
        if ( isPlayerMovePossible(direction) )
        {
            Position newPosition = player.getPosition().getNewPosition(direction);
            Terrain  terrain     = island.getTerrain(newPosition);
            
            // move the player to new position
            player.moveToPosition(newPosition, terrain);
            island.updatePlayerPosition(player);
            successfulMove = true;
                    
            // Is there a hazard?
            checkForHazard();
            
            occupants = getOccupantsPlayerPosition();
            if(occupants != null){
                for (Occupant i : occupants) {
                    if("Kiwi".equals(i.getName())){         //All kiwi facts were sourced from http://www.doc.govt.nz/nature/native-animals/birds/birds-a-z/kiwi/facts/
                        if (numKiwi==0){
                            setPlayerMessage("There are about 68,000 kiwi left in all of New Zealand.");
                            numKiwi++;
                        }else if (numKiwi==1){
                            setPlayerMessage("We are losing 2% of our unmanaged kiwi every year –that's around 20 per week.");
                            numKiwi++;
                        } else if (numKiwi==2){
                            setPlayerMessage("Kiwi are mostly nocturnal.");
                            numKiwi++;
                        } else if (numKiwi==3){
                            setPlayerMessage("Kiwi nest in burrows, hollow logs or under dense vegetation.");
                            numKiwi++;
                        } else if (numKiwi==4){
                            setPlayerMessage("Kiwi are the only bird to have nostrils at the end of their very long bill. Their nostrils are used to probe in the ground, sniffing out invertebrates to eat, along with some fallen fruit.");
                            numKiwi++;
                        } else if (numKiwi==5){
                            setPlayerMessage("The egg averages 15% of the female's body weight (compared to 2% for the ostrich).");
                            numKiwi++;
                        } else if (numKiwi==6){
                            setPlayerMessage("Females are larger than males (up to 3.3 kg and 45 cm).");
                            numKiwi++;
                        } else if (numKiwi==7){
                            setPlayerMessage("Kiwi are long-lived, and depending on the species live for between 25 and 50 years.");
                            numKiwi++;
                        } 
                    } else if("Oystercatcher".equals(i.getName())){     // All oystercatcher facts were sourced from http://www.doc.govt.nz/nature/native-animals/birds/birds-a-z/variable-oystercatcher-torea/
                        setPlayerMessage("Qystercatchers eat a wide range of coastal invertebrates, including molluscs and crustaceans.");
                    } else if("Crab".equals(i.getName())){
                        setPlayerMessage("You found a Crab!!");
                    } else if("Fernbird".equals(i.getName())){          // All fernbird facts were sourced from http://www.doc.govt.nz/nature/native-animals/birds/birds-a-z/fernbird-matata/
                        setPlayerMessage("Fernbird are heard more often than seen. Calls are often the only evidence that they are present in a wetland.");
                    } else if("Heron".equals(i.getName())){             // All heron facts were sourced from http://www.doc.govt.nz/nature/native-animals/birds/birds-a-z/white-heron-kotuku/
                        setPlayerMessage("The white heron is specially adapted for wading in shallow, muddy waterways.");
                    } else if("Robin".equals(i.getName())){             // All robin facts were sourced from http://www.doc.govt.nz/nature/native-animals/birds/birds-a-z/nz-robin-toutouwai/
                        setPlayerMessage("Robin are friendly and trusting, often coming to within a couple of metres of people.");
                    } else if("Tui".equals(i.getName())){               // All tui facts were sourced from http://www.doc.govt.nz/nature/native-animals/birds/birds-a-z/tui/
                        setPlayerMessage("Tūī will live where there is a balance of ground cover, shrubs and trees.");
                    } else if("Rat".equals(i.getName())){               // All rat and kiore facts were sourced from http://www.doc.govt.nz/nature/pests-and-threats/animal-pests/rats/
                        setPlayerMessage("Rats eat native animals and their eggs.");
                    } else if("Cat".equals(i.getName())){
                        setPlayerMessage("Cats can do alot of damage to our native species by hunting vurnerable birds such as kiwi.");
                    } else if("Kiore".equals(i.getName())){
                        setPlayerMessage("Kiore eat a wide range of native fruit and plants, which puts them in competition with the native wildlife for food.");
                    } else if("Stoat".equals(i.getName())){             // All stoat facts were sourced from http://www.doc.govt.nz/nature/pests-and-threats/animal-pests/stoats/
                        setPlayerMessage("Stoats are known predators of many native birds and feed heavily on reptiles and invertebrates.");
                    } else if("Possum".equals(i.getName())){            // All possum facts were sourced from http://www.doc.govt.nz/nature/pests-and-threats/animal-pests/possums/
                        setPlayerMessage("Possums compete with native birds for habitat and for food such as insects and berries.");
                    } else if("Bat".equals(i.getName())){               // All bat facts were sourced from http://www.doc.govt.nz/nature/native-animals/bats-pekapeka/long-tailed-bat/
                        setPlayerMessage("New Zealand's bats are rapidly heading towards extinction caused by rat plagues.");
                    } else if("Weta".equals(i.getName())){              // All weta facts were sourced from http://www.doc.govt.nz/nature/native-animals/invertebrates/weta/
                        setPlayerMessage("Weta are nocturnal and live in a variety of habitats including grassland, shrub land, forests, and caves. ");
                    } else if("Tuatara".equals(i.getName())){           // All tuatara facts were sourced from http://www.doc.govt.nz/nature/native-animals/reptiles-and-frogs/tuatara/
                        setPlayerMessage("Tuatara are New Zealand’s largest reptile, with adult males measuring up to about a half metre in length and weighing up to 1.5 kg when fully grown.");
                    } else if("Kakapo".equals(i.getName())){           // All kakapo facts were sourced from http://www.doc.govt.nz/nature/native-animals/birds/birds-a-z/kakapo/
                        setPlayerMessage("The kākāpō (night parrot) is one of New Zealand’s unique treasures with fewer than 160 known surviving birds.");
                    }
                }
            }
            

            updateGameState();            
        }
        return successfulMove;
    }
    
    public boolean predatorsMove()
    {        
        boolean successfulMove = false;
        MoveDirection direction = null;
        for(Predator predator : predators){
            int random = (int) (Math.random() * 4);     // to move predator one step randomly.
            switch(random){
                case 0:
                    direction = MoveDirection.EAST;
                break;
                
                case 1:
                    direction = MoveDirection.WEST;
                break;
                
                case 2:
                    direction = MoveDirection.NORTH;
                break;
                
                case 3:
                    direction = MoveDirection.SOUTH;
                break;
            }   // end of switch
            
            if(isPredatorMovePossible(direction, predator)){
                Position newPostion = predator.getPosition().getNewPosition(direction);
                Position previous = predator.getPosition();
                predator.setPreviousPredatorPos(previous);
                //Terrain terrain = island.getTerrain(newPostion);
                // this is to test a change
                
                predator.moveToPosition(newPostion);
                island.updatePredatorPosition(predator);
                
                
                Occupant occupant = predator;
                
                island.removeOccupant(previous, occupant);
                island.addOccupant(newPostion, occupant);
                
                
                if(island.hasKiwi(newPostion)){ // if it is true then predator kill the kiwi
                    eatKiwi(predator);
                }
                successfulMove = true;
                
                //updateGameState();   
            }
        }
        updateGameState();
        island.draw();
        return successfulMove;
        //if()
    }
    
    /**
     * Adds a game event listener.
     * @param listener the listener to add
     */
    public void addGameEventListener(GameEventListener listener)
    {
        eventListeners.add(listener);
    }
    
    
    /**
     * Removes a game event listener.
     * @param listener the listener to remove
     */
    public void removeGameEventListener(GameEventListener listener)
    {
        eventListeners.remove(listener);
    }
   
    
    /*********************************************************************************************************************************
     *  Private methods
     *********************************************************************************************************************************/
    
    /**
     * Used after player actions to update game state.
     * Applies the Win/Lose rules.
     */
    private void updateGameState()
    {
         String message = "";
        if ( !player.isAlive() )
        {
            state = GameState.LOST;
            message = "Sorry, you have lost the game. " + this.getLoseMessage()+" You scored: "+points+" Points.";
            this.setLoseMessage(message);
        }
        else if (!playerCanMove() )
        {
            state = GameState.LOST;
            message = "Sorry, you have lost the game. You do not have sufficient stamina to move. You scored: "+points+" Points.";
            this.setLoseMessage(message);
        }
        else if(predatorsTrapped == totalPredators)
        {
            state = GameState.WON;
            message = "You win! You have done an excellent job and trapped all the predators. You scored: "+points+" Points.";
            this.setWinMessage(message);
        }
        else if(kiwiCount == totalKiwis)
        {
            if(predatorsTrapped >= totalPredators * MIN_REQUIRED_CATCH)
            {
                state = GameState.WON;
                message = "You win! You have counted all the kiwi and trapped at least 80% of the predators. You scored: "+points+" Points.";
                this.setWinMessage(message);
            }
        }
        ////////////////////////////////////////////////////// Additional Win conditions?
        // notify listeners about changes
            notifyGameEventListeners();
    }
    
       
    /**
     * Sets details about players win
     * @param message 
     */
    private void setWinMessage(String message)
    {
        winMessage = message;
    }
    
    /**
     * Sets details of why player lost
     * @param message 
     */
    private void setLoseMessage(String message)
    {
        loseMessage = message;
    }
    
    /**
     * Set a message for the player
     * @param message 
     */
    private void setPlayerMessage(String message) 
    {
        playerMessage = message;
        
    }
    /**
     * Check if player able to move
     * @return true if player can move
     */
    private boolean playerCanMove() 
    {
        return ( isPlayerMovePossible(MoveDirection.NORTH)|| isPlayerMovePossible(MoveDirection.SOUTH)
                || isPlayerMovePossible(MoveDirection.EAST) || isPlayerMovePossible(MoveDirection.WEST));

    }
        
    /**
     * Trap a predator in this position
     * @return true if predator trapped
     */
    private boolean trapPredator()
    {
        Position current= player.getPosition();
        boolean hadPredator = island.hasPredator(current);
        if(hadPredator) //can trap it
        {
            Occupant occupant = island.getPredator(current);
            //Predator has been trapped so remove
            island.removeOccupant(current, occupant); 
            predators.remove((Object)occupant);         // check which predator deleted from the list of predator.
            predatorsTrapped++;
            points  += 5;
        }
        
        return hadPredator;
    }
    
    // to kill kiwi by predator if predator and kiwi in the same positioin.
    // test
    private void eatKiwi(Predator predator) {
        Position predatorPos = predator.getPosition();

        Occupant occupant = island.getKiwi(predatorPos);
        //Kiwi has been catched so remove
        island.removeOccupant(predatorPos, occupant);
        setPlayerMessage("Opps! predator eats kiwi");   // It is a notification that let player knows that predator successfully eat the kiwi 
        points -= 10;
    }
    
    /**
     * Checks if the player has met a hazard and applies hazard impact.
     * Fatal hazards kill player and end game.
     */
    private void checkForHazard()
    {
        //check if there are hazards
        for ( Occupant occupant : island.getOccupants(player.getPosition())  )
        {
            if ( occupant instanceof Hazard )
            {
               handleHazard((Hazard)occupant) ;
            }
        }
    }
    
    /**
     * Apply impact of hazard
     * @param hazard to handle
     */
    private void handleHazard(Hazard hazard) {
        if (hazard.isFatal()) 
        {
            player.kill();
            this.setLoseMessage(hazard.getDescription() + " has killed you.");
        } 
        else if (hazard.isBreakTrap()) 
        {
            Tool trap = player.getTrap();
            if (trap != null) {
                trap.setBroken();
                this.setPlayerMessage("Sorry your predator trap is broken. You will need to find tools to fix it before you can use it again.");
            }
        } 
        else // hazard reduces player's stamina
        {
            double impact = hazard.getImpact();
            // Impact is a reduction in players energy by this % of Max Stamina
            double reduction = player.getMaximumStaminaLevel() * impact;
            player.reduceStamina(reduction);
            // if stamina drops to zero: player is dead
            if (player.getStaminaLevel() <= 0.0) {
                player.kill();
                this.setLoseMessage(" You have run out of stamina");
            }
            else // Let player know what happened
            {
                this.setPlayerMessage(hazard.getDescription() + " has reduced your stamina.");
            }
        }
    }
    
    
    /**
     * Notifies all game event listeners about a change.
     */
    private void notifyGameEventListeners()
    {
        for ( GameEventListener listener : eventListeners ) 
        {
            listener.gameStateChanged();
        }
    }

    
    /**
     * Loads terrain and occupant data from a file.
     * At this stage this method assumes that the data file is correct and just
     * throws an exception or ignores it if it is not.
     * 
     * @param fileName file name of the data file
     */
    private void initialiseIslandFromFile(String fileName) 
    {
        try
        {
            Scanner input = new Scanner(new File(fileName));
            // make sure decimal numbers are read in the form "123.23"
            input.useLocale(Locale.US);
            input.useDelimiter("\\s*,\\s*");

            // create the island
            int numRows    = input.nextInt();
            int numColumns = input.nextInt();
            island = new Island(numRows, numColumns);

            // read and setup the terrain
            setUpTerrain(input);

            // read and setup the player
            setUpPlayer(input);

            // read and setup the occupants
            setUpOccupants(input);

            input.close();
        }
        catch(FileNotFoundException e)
        {
            System.err.println("Unable to find data file '" + fileName + "'");
        }
        catch(IOException e)
        {
            System.err.println("Problem encountered processing file.");
        }
    }

    /**
     * Reads terrain data and creates the terrain.
     * 
     * @param input data from the level file
     */
    private void setUpTerrain(Scanner input) 
    {
        for ( int row = 0 ; row < island.getNumRows() ; row++ ) 
        {
            String terrainRow = input.next();
            for ( int col = 0 ; col < terrainRow.length() ; col++ )
            {
                Position pos = new Position(island, row, col);
                String   terrainString = terrainRow.substring(col, col+1);
                Terrain  terrain = Terrain.getTerrainFromStringRepresentation(terrainString);
                island.setTerrain(pos, terrain);
            }
        }
    }

    /**
     * Reads player data and creates the player.
     * @param input data from the level file
     */
    private void setUpPlayer(Scanner input) 
    {
        String playerName              = input.next(); ////////////////////////////// change this later when player name input is featured
        int    playerPosRow            = input.nextInt();
        int    playerPosCol            = input.nextInt();
        double playerMaxStamina        = input.nextDouble();
        double playerMaxBackpackWeight = input.nextDouble();
        double playerMaxBackpackSize   = input.nextDouble();
        
        Position pos = new Position(island, playerPosRow, playerPosCol);
        player = new Player(pos, /// took out setting name ////////////////////////////////////////
                playerMaxStamina, 
                playerMaxBackpackWeight, playerMaxBackpackSize);
        island.updatePlayerPosition(player);
    }
    
    
    /**
     * Use this to set player name from gui input
     * @param name 
     */
    public void setPlayerName(String name){
        player.setName(name);
    }

    /**
     * Creates occupants listed in the file and adds them to the island.
     * @param input data from the level file
     */
    private void setUpOccupants(Scanner input) 
    {
        int numItems = input.nextInt();
        for ( int i = 0 ; i < numItems ; i++ ) 
        {
            String occType  = input.next();
            String occName  = input.next(); 
            String occDesc  = input.next();
            int    occRow   = input.nextInt();
            int    occCol   = input.nextInt();
            Position occPos = new Position(island, occRow, occCol);
            Occupant occupant    = null;

            if ( occType.equals("T") )
            {
                double weight = input.nextDouble();
                double size   = input.nextDouble();
                occupant = new Tool(occPos, occName, occDesc, weight, size);
            }
            else if ( occType.equals("E") )
            {
                double weight = input.nextDouble();
                double size   = input.nextDouble();
                double energy = input.nextDouble();
                occupant = new Food(occPos, occName, occDesc, weight, size, energy);
            }
            else if ( occType.equals("H") )
            {
                double impact = input.nextDouble();
                occupant = new Hazard(occPos, occName, occDesc,impact);
            }
            else if ( occType.equals("K") )
            {
                occupant = new Kiwi(occPos, occName, occDesc);
                totalKiwis++;
            }
            else if ( occType.equals("P") )
            {
                occupant = new Predator(occPos, occName, occDesc);
                totalPredators++; 
                predators.add((Predator)occupant);    // to add each predator into the ArrayList 
                                                      // so that the programmer can access to that
                island.updatePredatorPosition((Predator)occupant);    // to set each predator visible to test whether or not each predator moves                                    
            }
            else if ( occType.equals("F") )
            {
                occupant = new Fauna(occPos, occName, occDesc);
            }
            else if(occType.equals("k")){
                occupant = new Kakapo(occPos, occName, occDesc);
                totalEndangered++;
            }
            else if(occType.equals("W")){
                occupant = new Weta(occPos, occName, occDesc);
                totalEndangered++;
            }
            else if(occType.equals("t")){
                occupant = new Tuatara(occPos, occName, occDesc);
                totalEndangered++;
            }
            else if(occType.equals("B")){
                occupant = new Bat(occPos, occName, occDesc);
                totalEndangered++;               
            }
            if ( occupant != null ) island.addOccupant(occPos, occupant);
        }
    }    


    private Island island;
    private Player player;
    private GameState state;
    private int kiwiCount;
    private int totalPredators;
    private int totalKiwis;
    private int totalEndangered; ////////////// will need if new win condition
    private int endangeredCount; ///////////// will use for bonus points
    private int predatorsTrapped;
    private Set<GameEventListener> eventListeners;
    private List<Predator> predators;       // to keep the list of predators.
    
    private final double MIN_REQUIRED_CATCH = 0.8;
        
    private String winMessage = "";
    private String loseMessage  = "";
    private String playerMessage  = "";   
    
    private Occupant occupants[];
    private int numKiwi = 0;
    private int points = 0;
                        

    

}
