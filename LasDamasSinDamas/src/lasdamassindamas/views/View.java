/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasdamassindamas.views;

import lasdamassindamas.controllers.MoveController;
import lasdamassindamas.controllers.ResumeController;
import lasdamassindamas.controllers.StartController;

/**
 *
 * @author Gabri
 */
public abstract class View {
    
    protected StartController startController;
    
    protected MoveController moveController;

    protected ResumeController resumeController;

    public View(StartController startController, MoveController moveController, ResumeController resumeController) {
	this.startController = startController;
	this.moveController = moveController;
	this.resumeController = resumeController;
    }
    
    protected abstract void start();
    
    protected abstract boolean move();
    
    protected abstract boolean NewGame();
    
    public void interact() {
        boolean newGame;
        do {
            this.start();
            boolean finished;
            do{
                finished=this.move();
            }while (!finished);
            newGame = this.NewGame();
        }while (newGame);

    } 
    
}
		