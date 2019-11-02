/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasdamassindamas.views;

import lasdamassindamas.controllers.MoveController;
import lasdamassindamas.models.Color;
import lasdamassindamas.models.Coordinate;
import lasdamassindamas.views.console.CommandView;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import utils.Console;


/**
 *
 * @author Gabri
 */
@RunWith(MockitoJUnitRunner.class)
public class CommandViewTest {
    
    @Mock
    MoveController moveController;

    @Mock
    Console console;

    @InjectMocks
    CommandView commandView;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testInteract(){
       when(moveController.getColor()).thenReturn(Color.BLACK);
       when(console.readString("\nMueven las negras: ")).thenReturn("21,31");
       commandView.interact();
       verify(moveController).move(new Coordinate(2,1), new Coordinate(3, 1));
    }
    
    @Test
    public void testisGameFinished(){
        when(moveController.isGameFinished()).thenReturn(Boolean.TRUE);
        assertTrue(moveController.isGameFinished());
    }
    
    @Test
    public void testGameNotFinished(){
        when(moveController.isGameFinished()).thenReturn(Boolean.FALSE);
        assertFalse(moveController.isGameFinished());
    }
    
}
