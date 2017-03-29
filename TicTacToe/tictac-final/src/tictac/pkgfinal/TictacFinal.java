import java.util.*;
import java.util.InputMismatchException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Write a description of class TicTacToe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TictacFinal
{
    //Initialize the players, the computer and all necessary variables.
    public static Board gameBoard = new Board();
    public static boolean ai = true;
    int col;
    int row;
    public static Player pl1 = new Player("X");
    public static Player pl2 = new Player("O");
    public static AI p2 = new AI(gameBoard);
    public static boolean stalemate;
    public static void runTurn(int player){
          //If the player hasn't won keep the game going
          if(!ai){
               //This is the structure for the 2-player game
               if(player == 1)
                   pl1.move(gameBoard);
               else
                   pl2.move(gameBoard);              
               //If a player has won or there is a stalemate end the game here.
               if(checkVictory("X", gameBoard)){
                   TicGui.victory = true;
                   TicGui.whoWon = "Player 1";                 
               }
               else if(stalemate){
                   TicGui.victory = true;
                   TicGui.whoWon = "Stalemate";
               }
               else if(checkVictory("O", gameBoard)){
                   TicGui.victory = true;
                   TicGui.whoWon = "Player 2";
               }
          }
          else{
                //This is the structure for playing against the AI.
                pl1.move(gameBoard);
                if(checkVictory("X", gameBoard)){
                     TicGui.victory = true;
                     TicGui.whoWon = "Player 1";
                     return;
                }
                else if(stalemate){
                     TicGui.victory = true;
                     TicGui.whoWon = "Stalemate";
                     return;
                }
            
            p2.move();
            if(checkVictory("O", gameBoard)){
               TicGui.victory = true;
               TicGui.whoWon = "Computer";
           }
        }
       }
           
    
    // determines if someone has won
    public static boolean checkVictory(String player, Board b){
        int vert = 0;
        int hori = 0;
        //determines if someone has 3 in a row
        for(int i = 0; i<b.board[0].length; i++){
             for(int j = 0; j<b.board[1].length; j++){
                  if(b.board[i][j].equals(player)){
                       hori ++;
                       //Determines if the player has 3 in a row vertically
                       if(b.board[0][j].equals(player) && b.board[1][j].equals(player)&&b.board[2][j].equals(player)){
                            return true;
                       }
                   }
                }
             //Determines if a player has 3 in a row horizontally
             if(hori == 3){
                  return true;
             }
             else{
                  hori = 0;
             }
        }
        //Checks the first diagonal for victory
        if(b.board[0][0].equals(player) && b.board[1][1].equals(player) && b.board[2][2].equals(player)){
            return true;
        }
        //Checks the other diagonal for victory
        else if(b.board[0][2].equals(player) && b.board[1][1].equals(player)&&b.board[2][0].equals(player)){
            return true;
        }
        //Checks for a stalemate.  If full = 9, then the board is full and no one has won the game
        int full = 0;
        for(int i = 0; i<b.board[0].length; i++){
               for(int j = 0; j<b.board[1].length; j++){
                   if(!b.board[i][j].equals("+")){
                       full ++;
                       }
                   }
                }
        if(full == 9){
            stalemate = true;
            full = 0;
            return false;

        }
        return false;
    }
}
