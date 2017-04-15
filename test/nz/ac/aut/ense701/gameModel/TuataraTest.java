/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gameModel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author OEM-PC
 */
public class TuataraTest {
    
    
    private Tuatara tuatara;
    private Position position;
    private Island island;
    
    public TuataraTest() {
    }
    
    @Before
    public void setUp() {
        island = new Island(5,5);
        position = new Position(island, 4,4);
        tuatara = new Tuatara(position, "Tuatara", "Misses his dinosaur buddies");   
    }
    
    @After
    public void tearDown() {
        island = null;
        position = null;
        tuatara = null;
    }

    @Test
    public void testCountedNotCounted() {
        assertFalse("Should not be counted", tuatara.counted());
    }
    
    @Test
    public void testCountedIsCounted() {
        assertFalse("Should not be counted", tuatara.counted());
        tuatara.count();
        assertTrue("Should  be counted", tuatara.counted());
    }

    /**
     * Test of getStringRepresentation method, of class Kiwi.
     */
    @Test
    public void testGetStringRepresentation() {
        assertEquals("t", tuatara.getStringRepresentation());
    }
    
}
