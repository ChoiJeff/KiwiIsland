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
public class KakapoTest {
   
    private Kakapo kakapo;
    private Position position;
    private Island island;
    
    public KakapoTest() {
    }
    
    @Before
    public void setUp() {
        island = new Island(5,5);
        position = new Position(island, 4,4);
        kakapo = new Kakapo(position, "Kakapo", "A chubby green Kakapo");   
    }
    
    @After
    public void tearDown() {
        island = null;
        position = null;
        kakapo = null;
    }

    @Test
    public void testCountedNotCounted() {
        assertFalse("Should not be counted", kakapo.counted());
    }
    
    @Test
    public void testCountedIsCounted() {
        assertFalse("Should not be counted", kakapo.counted());
        kakapo.count();
        assertTrue("Should  be counted", kakapo.counted());
    }

    /**
     * Test of getStringRepresentation method, of class Kiwi.
     */
    @Test
    public void testGetStringRepresentation() {
        assertEquals("k", kakapo.getStringRepresentation());
    }
    
}
