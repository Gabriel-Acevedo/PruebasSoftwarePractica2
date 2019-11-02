/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasdamassindamas.controllers;

import lasdamassindamas.models.Game;
import lasdamassindamas.models.Color;
import lasdamassindamas.models.Coordinate;
import lasdamassindamas.models.Piece;
import lasdamassindamas.models.Error;

/**
 *
 * @author Gabri
 */
public class MoveController extends Controller{

    public MoveController(Game game) {
        super(game);
    }

    public Error move(Coordinate origin, Coordinate target){
            return game.move(origin, target);
    }


    public Color getColor() {
	return this.game.getTurn();
    }
    
    public String getBoard(){
        return this.game.getBoard();
    }
    
    public boolean isGameFinished(){
        return this.game.isGameFinished();
    }
    
}
