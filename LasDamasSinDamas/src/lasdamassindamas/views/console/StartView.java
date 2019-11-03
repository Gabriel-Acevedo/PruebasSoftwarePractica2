/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasdamassindamas.views.console;

import lasdamassindamas.controllers.StartController;
import lasdamassindamas.views.MessageView;
import utils.WithConsoleView;

/**
 *
 * @author Gabri
 */
public class StartView extends WithConsoleView{
    
    private StartController startController;
    
    StartView (StartController startController){
        this.startController = startController;
    }
    
    void interact() {
        this.console.writeln(MessageView.TITLE.getMessage());
    }
    
}
