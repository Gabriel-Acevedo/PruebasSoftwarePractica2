/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasdamassindamas.views.console;

import lasdamassindamas.controllers.ResumeController;
import lasdamassindamas.views.MessageView;
import utils.WithConsoleView;
import utils.YesNoDialog;

/**
 *
 * @author Gabri
 */
public class ResumeView extends WithConsoleView{
    
    private ResumeController resumeController;

    ResumeView(ResumeController resumeController) {
	this.resumeController = resumeController;
    }
    
    boolean interact() {
        boolean newGame = new YesNoDialog().read(MessageView.RESUME.getMessage());
	if (newGame) {
            this.resumeController.clearGame();			
	}
	return newGame;
    }
    
}
