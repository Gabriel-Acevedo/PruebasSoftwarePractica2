/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasdamassindamas.models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gabri
 */
public class PieceTest {
    
    @Test
    public void testGivenPieceWhenIsAdvancedThenTrue(){
        assertTrue(new Piece(Color.WHITE).isAdvanced(new Coordinate(5,0), new Coordinate(4,1)));
        assertTrue(new Piece(Color.BLACK).isAdvanced(new Coordinate(2,1), new Coordinate(3,2)));
    }

    @Test
    public void testGivenPieceWhenNotIsAdvancedThenFalse(){
        assertFalse(new Piece(Color.WHITE).isAdvanced(new Coordinate(5,0), new Coordinate(6,1)));
        assertFalse(new Piece(Color.BLACK).isAdvanced(new Coordinate(2,1), new Coordinate(1,2)));
    }
    
    @Test
    public void GoodColorAdvanceTest() {
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(3, 2);
        assertTrue(origin.isBlack());
        assertTrue(target.isBlack());
        assertTrue(new Piece(Color.BLACK).isAdvanced(origin, target));
    }

    @Test
    public void ErrorColorAdvanceTest() {
        Coordinate origin = new Coordinate(5,1);
        Coordinate target = new Coordinate(4,2);
        assertFalse(origin.isBlack());
        assertFalse(target.isBlack());
        assertTrue(new Piece(Color.WHITE).isAdvanced(origin, target));
    }
    
    
}


