package tictac.pkgfinal;

import java.util.*;
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
        public static String[][] gameBoard = new String[3][3];
        public static void main(String[ ]args){
           Scanner scan = new Scanner(System.in);
           for(int i = 0; i<gameBoard[0].length; i++){
                   for(int j = 0; j<gameBoard[1].length; j++){
                      gameBoard[i][j] = "+";
                    }
                }
           int col;
           int row;
           while(keepGoing){
               System.out.println("Player 1, where do you want to go? (Row and then column, or 0 to quit.)");
               playerMove("X",gameBoard);
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
               playerMove("O",gameBoard);
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
    }



    public static void playerMove(String player, String[][] board){
        for(int i = 0; i<board.length; i++){
                   for(int j = 0; j<board[0].length; j++){
                       System.out.print(board[i][j]);
                    }
                   System.out.println();
                }
        Scanner scan = new Scanner(System.in);
        System.out.print("Row:");
        int row = scan.nextInt();
        System.out.println();
        if (row == 0){
            keepGoing = false;
            return;
        }
        System.out.print("Column:");
        int col = scan.nextInt();
        System.out.println();
        if(row > 0 && col > 0 && board[row-1][col-1].equals("+") && row<4 && col <4) {
               board[row-1][col-1] = player;
        }
        else if(row == 0 || col == 0){
           keepGoing = false;
        }
        else {
           System.out.println("Invalid move, try again (Row and then column, or 0 to quit.)");
           playerMove(player, board);
        }
    }
    public static boolean checkVictory(String player, String[][] board){
        int vert = 0;
        int hori = 0;
        for(int i = 0; i<board[0].length; i++){
               for(int j = 0; j<board[1].length; j++){
                   if(board[i][j].equals(player)){
                       hori ++;
                       if(board[0][j].equals(player) && board[1][j].equals(player)&&board[2][j].equals(player)){
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
        if(board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)){
            return true;
        }
        else if(board[0][2].equals(player) && board[1][1].equals(player)&&board[2][0].equals(player)){
        return true;
        }
        int full = 0;
        for(int i = 0; i<board[0].length; i++){
               for(int j = 0; j<board[1].length; j++){
                   if(!board[i][j].equals("+")){
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