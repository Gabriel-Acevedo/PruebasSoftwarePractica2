/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasdamassindamas.controllers;

import lasdamassindamas.models.Color;
import lasdamassindamas.models.Coordinate;
import lasdamassindamas.models.Game;
import lasdamassindamas.models.Piece;
import lasdamassindamas.models.Error;
import org.junit.Test;
import static org.junit.Assert.*;



/**
 *
 * @author Gabri
 */

public class MoveControllerTest {

    public MoveControllerTest() {

    }

    @Test
    public void CorrectMovementThenNotError() {
        Game game = new Game();
        Coordinate origin = new Coordinate(5, 0);
        Coordinate target = new Coordinate(4, 1);
        MoveController moveController = new MoveController(game);
        assertNull(moveController.move(origin, target));
        assertNull(moveController.getPiece(origin));
        Piece pieceTarget = moveController.getPiece(target);
        assertNotNull(pieceTarget);
        assertEquals(pieceTarget.getColor(), Color.WHITE);
    }

    @Test
    public void NotAdvancedErrorTest() {
        MoveController moveController = new MoveController(new Game());
        Error error = moveController.move(new Coordinate(5, 0), new Coordinate(6, 1));
        assertNotNull(error);
        assertEquals(Error.NOT_ADVANCED, error);
    }
    
    @Test
    public void OutCoordinateErrorTest() {
        MoveController moveController = new MoveController(new Game());
        Error error = moveController.move(new Coordinate(8, 2), new Coordinate(9, 4));
        assertNotNull(error);
        assertEquals(Error.OUT_COORDINATE, error);
    }

    @Test
    public void OppositePieceErrorTest() {
        MoveController moveController = new MoveController(new Game());
        Error error = moveController.move(new Coordinate(2, 1), new Coordinate(3, 2));
        assertNotNull(error);
        assertEquals(Error.OPPOSITE_PIECE, error);
    }
    
    
}
