package main.java.interpreter;


import main.java.utilties.entities.Player;
import main.java.utilties.models.Location;
import main.java.utilties.models.Map;

/*
*  A class that implements PlayerScriptCommand is added to a list when the drag-and-drop GUI is 'compiled',
*  and performs the action it specifies in 'void performAction();' when prompted by the game clock.
* */
public interface PlayerScriptCommand {

    /*
    *  This function will be called by the class in order to modify the game in some way.
    * */
    void performAction(InterpreterParameter p);

}