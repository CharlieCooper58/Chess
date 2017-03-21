/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictac.pkgfinal;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 2006572
 */
public class AI {
    Board b;
    public AI(Board board){
        b = board;
    }
    public int[] canIWin(){
        int vert = 0;
        int hori = 0;
        int[] coor = new int[2];
        coor[0] = -1;
        for(int i = 0; i<b.board[0].length; i++){
               for(int j = 0; j<b.board[1].length; j++){
                   if(b.board[i][j].equals("O")){
                       hori ++;
                   }
               }
                   if(hori == 2){
                   for(int j = 0; j<b.board[1].length; j++){
                       if(b.board[i][j].equals("+")){
                           coor[0] = i;
                           coor[1] = j;
                           hori = 0;
                           }
                               
                           }
                       }
                       hori = 0;
                   
                   }
        for(int i = 0; i<b.board[0].length; i++){
               for(int j = 0; j<b.board[1].length; j++){
                   if(b.board[j][i].equals("O")){
                       vert ++;
                   }
               }
                   if(vert == 2){
                   for(int j = 0; j<b.board[1].length; j++){
                       if(b.board[j][i].equals("+")){
                           coor[0] = j;
                           coor[1] = i;
                           vert = 0;
                           }
                               
                           }
                       }
                  
                       vert = 0;
                   
                   }
        if(b.board[0][0].equals("O")&&b.board[1][1].equals("O")&&b.board[2][2].equals("+")){
            coor[0] = 2;
            coor[1] = 2;
        }
        else if(b.board[0][0].equals("O")&&b.board[1][1].equals("+")&&b.board[2][2].equals("O")){
            coor[0] = 1;
            coor[1] = 1;
        }
        else if(b.board[0][0].equals("+")&&b.board[1][1].equals("O")&&b.board[2][2].equals("O")){
            coor[0] = 0;
            coor[1] = 0;
        }
        else if(b.board[0][2].equals("O")&&b.board[1][1].equals("+")&&b.board[2][0].equals("O")){
            coor[0] = 0;
            coor[1] = 2;
        }
        else if(b.board[0][2].equals("+")&&b.board[1][1].equals("O")&&b.board[2][0].equals("O")){
            coor[0] = 0;
            coor[1] = 2;
        }
        else if(b.board[0][2].equals("O")&&b.board[1][1].equals("O")&&b.board[2][0].equals("+")){
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
        for(int i = 0; i<b.board[0].length; i++){
               for(int j = 0; j<b.board[1].length; j++){
                   if(b.board[i][j].equals("X")){
                       hori ++;
                   }
               }
               if(hori == 2){
                    for(int j = 0; j<b.board[1].length; j++){
                        if(b.board[i][j].equals("+")){
                            coor[0] = i;
                            coor[1] = j;
                            hori = 0;
                         }

                    }
               }
                       hori = 0;
                   
               }
            
        for(int i = 0; i<b.board[0].length; i++){
               for(int j = 0; j<b.board[1].length; j++){
                   if(b.board[j][i].equals("X")){
                       vert ++;
                   }
               }
                   if(vert == 2){
                   for(int j = 0; j<b.board[1].length; j++){
                       if(b.board[j][i].equals("+")){
                           coor[0] = j;
                           coor[1] = i;
                           vert = 0;
                           }
                               
                           }
                       }
                       vert = 0;
                   
        }
        if(b.board[0][0].equals("X")&&b.board[1][1].equals("X")&&b.board[2][2].equals("+")){
            coor[0] = 2;
            coor[1] = 2;
        }
        else if(b.board[0][0].equals("X")&&b.board[1][1].equals("+")&&b.board[2][2].equals("X")){
            coor[0] = 1;
            coor[1] = 1;
        }
        else if(b.board[0][0].equals("+")&&b.board[1][1].equals("X")&&b.board[2][2].equals("X")){
            coor[0] = 0;
            coor[1] = 0;
        }
        else if(b.board[0][2].equals("X")&&b.board[1][1].equals("+")&&b.board[2][0].equals("X")){
            coor[0] = 1;
            coor[1] = 1;
        }
        else if(b.board[0][2].equals("+")&&b.board[1][1].equals("X")&&b.board[2][0].equals("X")){
            coor[0] = 0;
            coor[1] = 2;
        }
        else if(b.board[0][2].equals("X")&&b.board[1][1].equals("X")&&b.board[2][0].equals("+")){
            coor[0] = 2;
            coor[1] = 0;
        }
     return coor;   
    }
    public void move(){
        b.printBoard();
        System.out.println("Computer is thinking...");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(AI.class.getName()).log(Level.SEVERE, null, ex);
        }
        int[] coor = new int[2];
        coor[0] = -1;
        coor[1] = -1;
        boolean moved = false;
        coor = canIWin();
        if(coor[0] != -1){
            moved = true;
            //board[coor[0]][coor[1]] = "O";
            AIMove(coor[0],coor[1]);
        }

        coor = canHeWin();
        if(coor[0] != -1 && moved == false){
            moved = true;
            //board[coor[0]][coor[1]] = "O";
            AIMove(coor[0],coor[1]);
        }
        Random rand = new Random();
        int row;
        int col;
        while(!moved){
            row = rand.nextInt(3);
            col = rand.nextInt(3);
            if(b.board[row][col].equals("+")){
                //board[row][col] = "O";
                AIMove(row, col);
                moved = true;
        }
            }
        }
    public void AIMove(int row, int col){
        if(b.board[row][col].equals("+")) {
               b.board[row][col] = "O";
        }
    }
    }     
