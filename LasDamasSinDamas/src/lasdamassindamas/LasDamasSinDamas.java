/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasdamassindamas;

import lasdamassindamas.controllers.MoveController;
import lasdamassindamas.controllers.ResumeController;
import lasdamassindamas.controllers.StartController;
import lasdamassindamas.models.Game;
import lasdamassindamas.views.View;

/**
 *
 * @author Gabri
 */
public abstract class LasDamasSinDamas {

        private Game game;
	
	private StartController startController;

	private MoveController moveController;

	private ResumeController resumeController;
	
	private View view;

	protected LasDamasSinDamas() {
            this.game = new Game();
            this.startController = new StartController(this.game);
            this.moveController = new MoveController (this.game);
            this.resumeController = new ResumeController (this.game);
            this.view = this.createView(this.startController, this.moveController, this.resumeController);
	}
        
        protected abstract View createView(StartController startController, MoveController moveController, ResumeController resumeController);
        
	protected void play() {
		this.view.interact();
	}
    
}
