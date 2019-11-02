/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasdamassindamas.views;

/**
 *
 * @author Gabri
 */
public enum MessageView {
    TITLE("Las Damas!!!"),
    WINNER("Victoria!!!"),
    LOOSER("Derrota!! No quedan piezas para mover."),
    RESUME("¿Queréis jugar otra?");
    
    private String message;
	
    private MessageView(String message) {
	this.message = message;
    }
	
    public String getMessage() {
    	return this.message;
    }
    
}
