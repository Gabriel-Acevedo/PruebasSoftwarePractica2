/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasdamassindamas.controllers;

import lasdamassindamas.models.Game;

/**
 *
 * @author Gabri
 */
public abstract class Controller {

    protected Game game;
        
    Controller(Game game) {
	this.game = game;
    }
    
}
