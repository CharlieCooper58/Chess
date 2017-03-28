import java.util.*;
import java.util.InputMismatchException;
/**
 *
 * @author 2006572
 */
public class Player {
    public String player;
    public Player(String p){
        player = p;
    }
    public void move(Board b){
        try {
            //finds out where the player wants to move
            int row = TicGui.getRow();
            int col = TicGui.getCol();
            //If the player decides to quit, cut the method immediately to save them the hassle of entering column.
            if (row == -1){
                TictacFinal.keepGoing = false;
                return;
            }
            //Puts an X or an O in the specified location as long as the specified spot is on the board.
            if(row > -1 && col > -1  && row<3 && col <3 && b.board[row][col].equals("+")) {
                   //Players enter a number between 1 and 3, rather than starting at 0.
                   b.board[row][col] = player;
                   TictacFinal.gameBoard = b;
            }
            //If the player decides to quit, sends a message to end the game.
            else if(row == -1 || col == -1){
               TictacFinal.keepGoing = false;
            }
            //If the player enters an invalid number, the machine will prompt them to try again.
            else {
               move(b);
            }
        } 
        //If the player enters anything but a number, catch it and prompt them to try again.
        catch (InputMismatchException e) {
            move(b);
        }
    }
}
