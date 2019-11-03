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
public class TurnTest {
    
    @Test
    public void NewTurnReturnsWhiteTest() {
        assertEquals(Color.WHITE, new Turn().getTurn());
    }
    
    @Test
    public void TurnWhiteThenChangeTurnReturnBlackTest() {
        Turn turn = new Turn();
        assertEquals(Color.WHITE, turn.getTurn());
        turn.change();
        assertEquals(Color.BLACK, turn.getTurn());
    }
    
    @Test
    public void TwoChaneTurnReturnsWhiteTest() {
        Turn turn = new Turn();
        assertEquals(Color.WHITE, turn.getTurn());
        turn.change();
        assertEquals(Color.BLACK, turn.getTurn());
        turn.change();
        assertEquals(Color.WHITE, turn.getTurn());
    }
    
    @Test
    public void ChangeTurnReturnsDifferentColorTest() {
        Turn turn = new Turn();
        assertTrue(turn.isColor(Color.WHITE));
        turn.change();
        assertTrue(turn.isColor(Color.BLACK));
    }
    
}
