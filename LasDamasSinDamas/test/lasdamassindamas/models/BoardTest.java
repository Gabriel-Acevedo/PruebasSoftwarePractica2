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
public class BoardTest {
    
    private Board board;

    public BoardTest() {
        this.board = new Board();
    }

    @Test
    public void NewBoardWithGoodLocationsTest() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < Board.DIMENSION; j++) {
                Coordinate coordinate = new Coordinate(i,j);
                Color color = board.getColor(coordinate);
                if (coordinate.isBlack()){
                    assertEquals(Color.BLACK, color);
                } else {
                    assertNull(color);
                }
            }
        }
        for (int i = 5; i < Board.DIMENSION; i++) {
            for (int j = 0; j < Board.DIMENSION; j++) {
                Coordinate coordinate = new Coordinate(i,j);
                Color color = board.getColor(coordinate);
                if (coordinate.isBlack()){
                    assertEquals(Color.WHITE, color);
                } else {
                    assertNull(color);
                }
            }
        }
    }   
    
    @Test
    public void EmptySquareTest(){
        Coordinate coordinate= new Coordinate(3,0);
        assertTrue(board.isEmpty(coordinate));
    }

}