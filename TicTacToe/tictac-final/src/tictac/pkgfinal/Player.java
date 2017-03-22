/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictac.pkgfinal;
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
        b.printBoard();
        try {
            Scanner scan = new Scanner(System.in);
            //finds out where the player wants to move
            System.out.print("Row:");
            int row = scan.nextInt();
            System.out.println();
            //If the player decides to quit, cut the method immediately to save them the hassle of entering column.
            if (row == 0){
                TictacFinal.keepGoing = false;
                return;
            }
            System.out.print("Column:");
            int col = scan.nextInt();
            System.out.println();
            //Puts an X or an O in the specified location as long as the specified spot is on the board.
            if(row > 0 && col > 0  && row<4 && col <4 && b.board[row-1][col-1].equals("+")) {
                   //Players enter a number between 1 and 3, rather than starting at 0.
                   b.board[row-1][col-1] = player;
            }
            //If the player decides to quit, sends a message to end the game.
            else if(row == 0 || col == 0){
               TictacFinal.keepGoing = false;
            }
            //If the player enters an invalid number, the machine will prompt them to try again.
            else {
               System.out.println("Invalid move, try again (Row and then column, or 0 to quit.)");
               move(b);
            }
        } 
        //If the player enters anything but a number, catch it and prompt them to try again.
        catch (InputMismatchException e) {
            System.out.println("Invalid move, try again (Row and then column, or 0 to quit.)");
            move(b);
            }
        }
}