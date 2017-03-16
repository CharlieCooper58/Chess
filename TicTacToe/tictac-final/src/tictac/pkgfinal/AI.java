/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictac.pkgfinal;
import java.util.Random;
/**
 *
 * @author 2006572
 */
public class AI {
    private String[][] board;
    public AI(){
        board = TictacFinal.gameBoard;
    }
    public int[] canIWin(){
        int vert = 0;
        int hori = 0;
        int[] coor = new int[2];
        coor[0] = -1;
        for(int i = 0; i<board[0].length; i++){
               for(int j = 0; j<board[1].length; j++){
                   if(board[i][j].equals("O")){
                       hori ++;
                   }
               }
                   if(hori == 2){
                   for(int j = 0; j<board[1].length; j++){
                       if(board[i][j].equals("+")){
                           coor[0] = i;
                           coor[1] = j;
                           }
                               
                           }
                       }
                   else{
                       hori = 0;
                   }
                   }
        for(int i = 0; i<board[0].length; i++){
               for(int j = 0; j<board[1].length; j++){
                   if(board[j][i].equals("O")){
                       vert ++;
                   }
               }
                   if(vert == 2){
                   for(int j = 0; j<board[1].length; j++){
                       if(board[j][i].equals("+")){
                           coor[0] = j;
                           coor[1] = i;
                           }
                               
                           }
                       }
                   else{
                       vert = 0;
                   }
                   }
        if(board[0][0].equals("O")&&board[1][1].equals("O")&&board[2][2].equals("+")){
            coor[0] = 2;
            coor[1] = 2;
        }
        else if(board[0][0].equals("O")&&board[1][1].equals("+")&&board[2][2].equals("O")){
            coor[0] = 1;
            coor[1] = 1;
        }
        else if(board[0][0].equals("+")&&board[1][1].equals("O")&&board[2][2].equals("O")){
            coor[0] = 0;
            coor[1] = 0;
        }
        else if(board[0][2].equals("O")&&board[1][1].equals("+")&&board[2][0].equals("O")){
            coor[0] = 0;
            coor[1] = 2;
        }
        else if(board[0][2].equals("+")&&board[1][1].equals("O")&&board[2][0].equals("O")){
            coor[0] = 0;
            coor[1] = 2;
        }
        else if(board[0][2].equals("O")&&board[1][1].equals("O")&&board[2][0].equals("+")){
            coor[0] = 0;
            coor[1] = 2;
        }
     return coor;   
    }
    public int[] canHeWin(){
        int vert = 0;
        int hori = 0;
        int[] coor = new int[2];
        coor[0] = -1;
        for(int i = 0; i<board[0].length; i++){
               for(int j = 0; j<board[1].length; j++){
                   if(board[i][j].equals("X")){
                       hori ++;
                   }
               }
                   if(hori == 2){
                        for(int j = 0; j<board[1].length; j++){
                            if(board[i][j].equals("+")){
                                coor[0] = i;
                                coor[1] = j;
                             }
                               
                        }
                   }
                   else{
                       hori = 0;
                   }
               }
            
        for(int i = 0; i<board[0].length; i++){
               for(int j = 0; j<board[1].length; j++){
                   if(board[j][i].equals("X")){
                       vert ++;
                   }
               }
                   if(vert == 2){
                   for(int j = 0; j<board[1].length; j++){
                       if(board[j][i].equals("+")){
                           coor[0] = j;
                           coor[1] = i;
                           }
                               
                           }
                       }
                   else{
                       vert = 0;
                   }
        }
        if(board[0][0].equals("X")&&board[1][1].equals("X")&&board[2][2].equals("+")){
            coor[0] = 2;
            coor[1] = 2;
        }
        else if(board[0][0].equals("X")&&board[1][1].equals("+")&&board[2][2].equals("X")){
            coor[0] = 1;
            coor[1] = 1;
        }
        else if(board[0][0].equals("+")&&board[1][1].equals("X")&&board[2][2].equals("X")){
            coor[0] = 0;
            coor[1] = 0;
        }
        else if(board[0][2].equals("X")&&board[1][1].equals("+")&&board[2][0].equals("X")){
            coor[0] = 1;
            coor[1] = 1;
        }
        else if(board[0][2].equals("+")&&board[1][1].equals("X")&&board[2][0].equals("X")){
            coor[0] = 0;
            coor[1] = 2;
        }
        else if(board[0][2].equals("X")&&board[1][1].equals("X")&&board[2][0].equals("+")){
            coor[0] = 2;
            coor[1] = 0;
        }
     return coor;   
    }
    public void move(){
        int[] coor = new int[2];
        coor[0] = -1;
        coor[1] = -1;
        boolean moved = false;
        coor = canIWin();
        if(coor[0] != -1){
            moved = true;
            System.out.println(coor[0] + " " + coor[1]);
            //board[coor[0]][coor[1]] = "O";
            AIMove(coor[0],coor[1]);
        }
        System.out.println(coor[0] + " " + coor[1]);

        coor = canHeWin();
        if(coor[0] != -1 && moved == false){
            System.out.println("I can't win");
            moved = true;
            System.out.println(coor[0] + " " + coor[1]);
            //board[coor[0]][coor[1]] = "O";
            AIMove(coor[0],coor[1]);
        }
        Random rand = new Random();
        int row;
        int col;
        while(!moved){
            row = rand.nextInt(3);
            col = rand.nextInt(3);
            if(board[row][col].equals("+")){
                //board[row][col] = "O";
                AIMove(row, col);
                moved = true;
        }
            }
        }
    public void AIMove(int row, int col){
        for(int i = 0; i<board.length; i++){
                   for(int j = 0; j<board[0].length; j++){
                       System.out.print(board[i][j]);
                    }
                   System.out.println();
                }
        if(board[row][col].equals("+")) {
               board[row][col] = "O";
        }
    }
    }     
