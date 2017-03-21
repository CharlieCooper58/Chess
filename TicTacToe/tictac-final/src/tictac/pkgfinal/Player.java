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
        if (row == 0){
            TictacFinal.keepGoing = false;
            return;
        }
        System.out.print("Column:");
        int col = scan.nextInt();
        System.out.println();
        //puts an X in the specified coordinates
        if(row > 0 && col > 0  && row<4 && col <4 && b.board[row-1][col-1].equals("+")) {
               b.board[row-1][col-1] = player;
        }
        //prevents the player from entering bad input
        else if(row == 0 || col == 0){
           TictacFinal.keepGoing = false;
        }
        else {
           System.out.println("Invalid move, try again (Row and then column, or 0 to quit.)");
           move(b);
        }
        } catch (InputMismatchException e) {
            System.out.println("Invalid move, try again (Row and then column, or 0 to quit.)");
            move(b);
            }
        }
}