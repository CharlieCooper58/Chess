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
           boolean AI = true;
           while(keepGoing){
               if(!AI){
                    System.out.println("Player 1, where do you want to go? (Row and then column, or 0 to quit.)");
                    pl1.move(gameBoard);
                    if(checkVictory("X", gameBoard)){
                        for(int i = 0; i<gameBoard.length; i++){
                            for(int j = 0; j<gameBoard[0].length; j++){
                                System.out.print(gameBoard[i][j]);
                             }
                        System.out.println();
                     }
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
                        for(int i = 0; i<gameBoard.length; i++){
                             for(int j = 0; j<gameBoard[0].length; j++){
                                 System.out.print(gameBoard[i][j]);
                              }
                        System.out.println();
                     }
                        System.out.println("Player 2 wins!");
                        keepGoing = false;
                        break;
                    }
               }
               else{
                   System.out.println("Player 1, where do you want to go? (Row and then column, or 0 to quit.)");
                    pl1.move(gameBoard);
                    if(checkVictory("X", gameBoard)){
                        for(int i = 0; i<gameBoard.length; i++){
                            for(int j = 0; j<gameBoard[0].length; j++){
                                System.out.print(gameBoard[i][j]);
                             }
                        System.out.println();
                     }
                        System.out.println("Player 1 wins!");
                        keepGoing = false;
                        break;
                    }
                    if(!keepGoing){
                        break;
                    }
                    p2.move();
                    if(checkVictory("O", gameBoard)){
                        for(int i = 0; i<gameBoard.length; i++){
                             for(int j = 0; j<gameBoard[0].length; j++){
                                 System.out.print(gameBoard[i][j]);
                              }
                        System.out.println();
                     }
                        System.out.println("Computer wins!");
                        keepGoing = false;
                        break;
                    }
               }


            }
    }




    public static boolean checkVictory(String player, Board b){
        int vert = 0;
        int hori = 0;
        for(int i = 0; i<b.board[0].length; i++){
               for(int j = 0; j<b.board[1].length; j++){
                   if(b.board[i][j].equals(player)){
                       hori ++;
                       if(b.board[0][j].equals(player) && b.board[1][j].equals(player)&&b.board[2][j].equals(player)){
                            return true;
                       }
                   }
                }
           if(hori == 3){
               return true;
           }
           else{
               hori = 0;
           }
        }
        if(b.board[0][0].equals(player) && b.board[1][1].equals(player) && b.board[2][2].equals(player)){
            return true;
        }
        else if(b.board[0][2].equals(player) && b.board[1][1].equals(player)&&b.board[2][0].equals(player)){
        return true;
        }
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
    //change
    //change
    
}