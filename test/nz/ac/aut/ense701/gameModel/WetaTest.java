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
public class WetaTest {
    
    
    private Weta weta;
    private Position position;
    private Island island;
    
    public WetaTest() {
    }
    
    @Before
    public void setUp() {
        island = new Island(5,5);
        position = new Position(island, 4,4);
        weta = new Weta(position, "Weta", "A gross but threated weta");   
    }
    
    @After
    public void tearDown() {
        island = null;
        position = null;
        weta = null;
    }

    @Test
    public void testCountedNotCounted() {
        assertFalse("Should not be counted", weta.counted());
    }
    
    @Test
    public void testCountedIsCounted() {
        assertFalse("Should not be counted", weta.counted());
        weta.count();
        assertTrue("Should  be counted", weta.counted());
    }

    /**
     * Test of getStringRepresentation method, of class Kiwi.
     */
    @Test
    public void testGetStringRepresentation() {
        assertEquals("W", weta.getStringRepresentation());
    }
    
}
