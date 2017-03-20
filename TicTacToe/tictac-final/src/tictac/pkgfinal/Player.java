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
        for(int i = 0; i<b.board.length; i++){
                   for(int j = 0; j<b.board[0].length; j++){
                       System.out.print(b.board[i][j]);
                    }
                   System.out.println();
                }
        try {
        Scanner scan = new Scanner(System.in);
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
        if(row > 0 && col > 0  && row<4 && col <4 && b.board[row-1][col-1].equals("+")) {
               b.board[row-1][col-1] = player;
        }
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
