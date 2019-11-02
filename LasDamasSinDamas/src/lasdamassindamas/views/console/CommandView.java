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
        String board= moveController.getBoard();
        console.write(board);
        String color = CommandView.COLORS[moveController.getColor().ordinal()];
        Error error = null;
        do {
            String command = this.console.readString("\nMueven las " + color + ": ");
            int origin = Integer.parseInt(command.substring(0, 2));
            int target = Integer.parseInt(command.substring(3, 5));
            error = moveController.move(new Coordinate(origin/10, origin%10), new Coordinate(target/10, target%10));
            if (error != null){
                console.write("Error!!!" + error.name());
            }
        } while (error != null);  
        
        if(moveController.isGameFinished()){
            console.write(MessageView.LOOSER.getMessage());
            return true;
        }
        return false;
    }

}