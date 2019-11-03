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
public class SquareTest {
    
    public SquareTest(){
    }
    
    @Test
    public void NewSquareIsEmptyTest() {
        Square square = new Square(new Coordinate(0, 0));
        assertNull(square.getPiece());
    }

    @Test
    public void NewPieceOnSquareReturnsPieceTest() {
        Square square = new Square(new Coordinate(2, 2));
        Piece piece = new Piece(Color.WHITE);
        square.put(piece);
        assertEquals(piece, square.getPiece());
    }

    @Test
    public void RemovePieceFromSquareTest() {
        Square square = new Square(new Coordinate(2, 0));
        Piece piece = new Piece(Color.WHITE);
        square.put(piece);
        assertEquals(piece, square.getPiece());
        square.remove();
        assertNull(square.getPiece());
    }
    
    @Test
        public void NewPieceSquareIsNotEmptyTest(){
        Square square = new Square(new Coordinate(2, 0));
        assertTrue(square.isEmpty());
        Piece piece = new Piece(Color.WHITE);
        square.put(piece);
        assertFalse(square.isEmpty());
    }
    
}
