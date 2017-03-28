import java.util.Scanner;
/**
 *
 * @author 2006572
 */
//Initializes a blank board.
public class Board {
    public String[][] board = new String[3][3];
    public Board(){
        for(int i = 0; i<board[0].length; i++){
            for(int j = 0; j< board[1].length; j++){
                board[i][j] = "+";
            }
        }
    }
    public void clearBoard(){
        for(int i = 0; i<board[0].length; i++){
            for(int j = 0; j< board[1].length; j++){
                 board[i][j] = "+";
            }
        }
    }
}
