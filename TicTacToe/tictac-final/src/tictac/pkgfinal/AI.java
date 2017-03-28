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
    // Checks if the computer can win
    public int[] canIWin(){
        int vert = 0;
        int hori = 0;
        int[] coor = new int[2];
        coor[0] = -1;
        //determines if the computer has 2 in a row
        for(int i = 0; i<b.board[0].length; i++){
               for(int j = 0; j<b.board[1].length; j++){
                   if(b.board[i][j].equals("O")){
                       hori ++;
                   }
               }
                //If the computer has 2 in a row, it will then figure out if the third space is
                //open.  If it is, then it will return that space's coordinates.
               if(hori == 2){
                   for(int j = 0; j<b.board[1].length; j++){
                       if(b.board[i][j].equals("+")){
                           coor[0] = i;
                           coor[1] = j;
                        }
                               
                           }
                       }
                //Resets hori so as not to mess over future iterations of the loop.
               hori = 0;
        }
        //Determines if the computer has 2 in a column.  The code is the same as the other one,
        //except that x and y are inverted so as to check vertically instead of horizontally.
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
        //Checks the diagonals.  If 2 of the diagonal spots are O's and the third is open,
        //the computer will move there.
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
            coor[0] = 1;
            coor[1] = 1;
        }
        else if(b.board[0][2].equals("+")&&b.board[1][1].equals("O")&&b.board[2][0].equals("O")){
            coor[0] = 0;
            coor[1] = 2;
        }
        else if(b.board[0][2].equals("O")&&b.board[1][1].equals("O")&&b.board[2][0].equals("+")){
            coor[0] = 2;
            coor[1] = 0;
        }
        return coor;   
    }
    public int[] canHeWin(){
        //This method is basically the same as the above method, except that it checks for X's
        //instead of O's.  The purpose of this method is to prevent the player from winning.
        int vert = 0;
        int hori = 0;
        int[] coor = new int[2];
        coor[0] = -1;
        //determines if the player has 2 in a row
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
        int[] coor = new int[2];
        coor[0] = -1;
        coor[1] = -1;
        boolean moved = false;
        //If the computer can win the game, it will choose to do that.
        coor = canIWin();
        if(coor[0] != -1){
            moved = true;
            AIMove(coor[0],coor[1]);
        }
        //If the computer can't win but the player can, the computer will prevent the player from winning.
        coor = canHeWin();
        if(coor[0] != -1 && moved == false){
            moved = true;
            AIMove(coor[0],coor[1]);
        }
        // Otherwise, the computer will move at random.
        Random rand = new Random();
        int row;
        int col;
        while(!moved){
            row = rand.nextInt(3);
            col = rand.nextInt(3);
            if(b.board[row][col].equals("+")){
                AIMove(row, col);
                moved = true;
            }
        }
    }
    //Double-checks that the desired space is available, and if it is, then the AI will move there.
    public void AIMove(int row, int col){
        if(b.board[row][col].equals("+")) {
               b.board[row][col] = "O";
        }
    }
}
