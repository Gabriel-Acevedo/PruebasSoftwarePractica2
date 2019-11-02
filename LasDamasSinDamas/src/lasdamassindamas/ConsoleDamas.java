/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasdamassindamas;

import lasdamassindamas.controllers.MoveController;
import lasdamassindamas.controllers.ResumeController;
import lasdamassindamas.controllers.StartController;
import lasdamassindamas.views.View;
import lasdamassindamas.views.console.ConsoleView;


/**
 *
 * @author Gabri
 */
public class ConsoleDamas extends LasDamasSinDamas{

    @Override
    protected View createView(StartController startController, MoveController moveController, ResumeController resumeController) {
        return new ConsoleView(startController, moveController, resumeController);
    }
    
    public static void main(String[] args) {
	new ConsoleDamas().play();
    }
    
}
