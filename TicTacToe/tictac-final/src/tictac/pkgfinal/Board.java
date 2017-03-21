/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictac.pkgfinal;

import java.util.Scanner;
/**
 *
 * @author 2006572
 */
//creates the board
public class Board {
    public String[][] board = new String[3][3];
    public Board(){
           for(int i = 0; i<board[0].length; i++){
                   for(int j = 0; j< board[1].length; j++){
                      board[i][j] = "+";
                    }
                }
    }
    //prints the board
    public void printBoard(){
        System.out.println(" " + 123);
        for(int i = 0; i<board.length; i++){
            System.out.print(i+1 + " ");
                   for(int j = 0; j<board[0].length; j++){
                       System.out.print(board[i][j]);
                    }
                   System.out.println();
                }
    }
    //edit
}
