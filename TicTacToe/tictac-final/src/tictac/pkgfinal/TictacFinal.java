package tictac.pkgfinal;

import java.util.*;
import java.util.InputMismatchException;
/**
 * Write a description of class TicTacToe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TictacFinal
{
    public static boolean keepGoing = true;
        /**
         *
         */
        public static void main(String[ ]args){
           Board gameBoard = new Board();

           Scanner scan = new Scanner(System.in);
           int col;
           int row;
           Player pl1 = new Player("X");
           Player pl2 = new Player("O");
           AI p2 = new AI(gameBoard);
           //Find out if the player wants to play alone or with a friend
           System.out.println("Do you want to play with one player or two?  (Type \"One\" for one player, or \"Two\" for two players.");
           String yn = scan.next();
           boolean ai;
           if(yn.toUpperCase().equals("ONE")){
                ai = true;
           }
           else if(yn.toUpperCase().equals("TWO")){
                ai = false;
           }
           else{
               ai = false;
           }
           while(keepGoing){
               //If the player hasn't won keep the game going
               if(!ai){
                   //This is the structure for the 2-player game
                    System.out.println("Player 1, where do you want to go? (Row and then column, or 0 to quit.)");
                    pl1.move(gameBoard);
                    //If the player has won, end the game here.
                    if(checkVictory("X", gameBoard)){
                        gameBoard.printBoard();
                        System.out.println("Player 1 wins!");
                        keepGoing = false;
                        break;
                    }
                    if(!keepGoing){
                        break;
                    }

                    System.out.println("Player 2, where do you want to go? (Row and then column, or 0 to quit.)");
                    pl2.move(gameBoard);
                    if(checkVictory("O", gameBoard)){
                        gameBoard.printBoard();
                        System.out.println("Player 2 wins!");
                        keepGoing = false;
                        break;
                    }
               }
               else{
                   //This is the structure for playing against the AI.
                   System.out.println("Player 1, where do you want to go? (Row and then column, or 0 to quit.)");
                    pl1.move(gameBoard);
                    if(checkVictory("X", gameBoard)){
                        gameBoard.printBoard();
                        System.out.println("Player 1 wins!");
                        keepGoing = false;
                        break;
                    }
                    if(!keepGoing){
                        break;
                    }
                    //If the computer wins end the game
                    p2.move();
                    if(checkVictory("O", gameBoard)){
                        gameBoard.printBoard();
                        System.out.println("Computer wins!");
                        keepGoing = false;
                        break;
                    }
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
            System.out.println("Stalemate");
            keepGoing = false;
            return false;
        }
            return false;
    }
    
}