/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasdamassindamas.models;

import lasdamassindamas.views.console.CommandView;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Gabri
 */
public class GameTest {
    

    @Mock
    Board board;
    
    @Mock
    Game gameM;

    @Mock
    Piece piece;
    
   @InjectMocks
    CommandView commandView;

    private Game game;

    public GameTest() {
        game = new Game();
    }
   
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void MoveOutCoordinateErrorTest() {
        Error error = null;
        assertNull(error);
        error = game.move(new Coordinate(4, 7), new Coordinate(3, 8));
        assertEquals(Error.OUT_COORDINATE, error);
    }

    @Test
    public void MoveEmptySquareReturnsEmptyOriginErrorTest() {
        assertEquals(Error.EMPTY_ORIGIN, game.move(new Coordinate(4, 3), new Coordinate(3, 4)));
    }

    @Test
    public void MoveOppositePieceTest() {
        assertTrue(game.turnIsColor(Color.WHITE));
        assertEquals(Error.OPPOSITE_PIECE, game.move(new Coordinate(2, 1), new Coordinate(3, 2)));
    }

    @Test
    public void MoveNotDiagonalErrorTest() {
        assertEquals(Error.NOT_DIAGONAL, this.game.move(new Coordinate(5, 0), new Coordinate(4, 2)));
    }

    @Test
    public void MoveNotAdvancedErrorTest() {
        assertEquals(Error.NOT_ADVANCED, game.move(new Coordinate(5, 0), new Coordinate(6, 1)));
    }

    @Test
    public void MoveNotEmptyTargetErrorTest() {

        Coordinate[][] coordinates = new Coordinate[][]{{new Coordinate(5, 0), new Coordinate(4, 1)},
                                                        {new Coordinate(2, 3), new Coordinate(3, 2)}, 
                                                        {new Coordinate(4, 1), new Coordinate(3, 2)}
                                                       };
        Error error = null;
        assertNull(error);
        for (int i = 0; i < coordinates.length; i++) {
            error = game.move(coordinates[i][0], coordinates[i][1]);
        }
        assertEquals(Error.NOT_EMPTY_TARGET, error);
    }
    
    @Test
    public void MockNotEmptyTargetErrorTest() {
        when(gameM.move(new Coordinate(5, 1), new Coordinate(4, 2))).thenReturn(Error.NOT_EMPTY_TARGET);
    }

    @Test
    public void MoveCorrectThenNotError() {
        Coordinate origin = new Coordinate(5, 0);
        Coordinate target = new Coordinate(4, 1);
        this.game.move(origin, target);
        assertNull(this.game.getColor(origin));
        assertEquals(Color.WHITE, this.game.getColor(target));
        origin = new Coordinate(2, 1);
        target = new Coordinate(3, 2);
        this.game.move(origin, target);
        assertNull(this.game.getColor(origin));
        assertEquals(Color.BLACK, this.game.getColor(target));
    }

    @Test
    public void MovementCorrectThenEatPiece() {
        Coordinate[][] coordinates = new Coordinate[][]{{new Coordinate(5, 0), new Coordinate(4, 1)},
                                                        {new Coordinate(2, 1), new Coordinate(3, 2)}, 
                                                        {new Coordinate(5, 4), new Coordinate(4, 5)},
                                                        {new Coordinate(3, 2), new Coordinate(5, 0)}
                                                       };
        Error error = null;
        for (int i = 0; i < coordinates.length; i++) {
            assertNull(error);
            error = game.move(coordinates[i][0], coordinates[i][1]);
        }
        assertNull(error);
        assertNull(game.getColor(new Coordinate(4, 1)));
        assertEquals(Color.BLACK, game.getColor(new Coordinate(5, 0)));
    }

    @Test
    public void MoveEatingEmptyErrorTest() {
        assertEquals(Error.EATING_EMPTY, this.game.move(new Coordinate(5, 4), new Coordinate(3, 2)));
    }

    @Test
    public void MoveBadDistanceErrorTest() {
        assertEquals(Error.BAD_DISTANCE, this.game.move(new Coordinate(5, 0), new Coordinate(2, 3)));
    }
    
    
    @Test
    public void GetPieceTest(){    
        when(board.getPiece(new Coordinate(5,0))).thenReturn(new Piece(Color.WHITE));
        Piece piece = board.getPiece(new Coordinate(5,0));
        assertNotNull(piece);   
    }  
}

