package lasdamassindamas.views.console;

import lasdamassindamas.controllers.MoveController;
import lasdamassindamas.models.Coordinate;
import utils.Console;
import lasdamassindamas.models.Error;
import lasdamassindamas.views.MessageView;

public class CommandView extends Console{

    private Console console;

    private MoveController moveController;

    private static final String[] COLORS = {"blancas", "negras"};

    public CommandView(MoveController moveController){
        this.moveController = moveController;
        this.console = new Console();
    }

    public boolean interact() {
        String color = null;
        int numPiecesLeft = -1;
        Error error = null;
        String command="";
        do {
            color = CommandView.COLORS[moveController.getColor().ordinal()];
            numPiecesLeft = this.moveController.getNumberOfPieces(moveController.getColor());
            String board= moveController.getBoardStatus();
            console.write(board);
            command = this.console.readString("\nMueven las " + color + ": ");
            if(!command.equals("-1")){
                int origin = Integer.parseInt(command.substring(0, 2));
                int target = Integer.parseInt(command.substring(3, 5));
                error = moveController.move(new Coordinate(origin/10, origin%10), new Coordinate(target/10, target%10));
                if (error != null){
                    console.write("Error!!!" + error.name());
            }}
            
        } while (error != null || !command.equals("-1") && numPiecesLeft != 0); 
        
        if(numPiecesLeft==0){
            console.write(MessageView.LOOSER.getMessage());
            return true;
        }else if (command.equals("-1")) {
            console.write(MessageView.RENDIRSE.getMessage().replaceAll("##color", color));
            return true;
        }         
        return false;
    }

}