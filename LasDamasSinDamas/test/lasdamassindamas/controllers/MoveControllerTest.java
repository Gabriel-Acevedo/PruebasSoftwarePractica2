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
import lasdamassindamas.views.console.CommandView;
import org.junit.Test;
import static org.junit.Assert.*;
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
public class MoveControllerTest {
    
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
    public void givenPlayControllerWhenMovementRequiereCorrectThenNotError() {
        when(moveController.getColor()).thenReturn(Color.WHITE);
        when(console.readString("\nMueven las blancas: ")).thenReturn("50,41");
        commandView.interact();
        verify(moveController).move(new Coordinate(5,0), new Coordinate(4, 1));    
    }
   
    
}
