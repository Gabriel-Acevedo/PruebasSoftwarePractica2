/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasdamassindamas.views.console;

import lasdamassindamas.controllers.MoveController;
import lasdamassindamas.controllers.ResumeController;
import lasdamassindamas.controllers.StartController;
import lasdamassindamas.views.View;

/**
 *
 * @author Gabri
 */
public class ConsoleView extends View{
    
    	private StartView startView;

	private CommandView commandView;

	private ResumeView resumeView;
                
        

	public ConsoleView(StartController startController, MoveController moveController, ResumeController resumeController) {
		super(startController, moveController, resumeController);
		this.startView = new StartView(this.startController);
		this.commandView = new CommandView(this.moveController);
		this.resumeView = new ResumeView(this.resumeController);
	}

    @Override
    protected void start() {
        this.startView.interact();
    }
    
    @Override
    protected boolean move(){
        return this.commandView.interact();
    }
    
    @Override
    protected boolean NewGame(){
        return this.resumeView.interact();
    }
    
}
