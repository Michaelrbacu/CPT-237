import java.util.*;
public class SudokoBoard {
    int grid[][];
    boolean isValid;
    SudokoBoard(){
        grid=new int[9][9];
        isValid=false;
    }
    boolean isValidRow(int row){
        Set<Integer> s=new HashSet<Integer>();
        for(int i = 0; i < 9; i++){

          if(grid[row][i] < 0 || grid[row][i] > 9){

            return false;
          }
          else
          { //Checking for repeated values.
            if(grid[row][i] != 0){
              if(s.size()==0)
                  s.add(grid[row][i]);
              
              else if(s.contains(grid[row][i])== true){
                 // System.out.println("Row : "+row+" Col : "+i+" "+s);
                return false;
              }
              s.add(grid[row][i]);
            }
          }
        }

        return true;
    }
    boolean isValidColumn(int col){
        Set<Integer> s=new HashSet<Integer>();
        for(int i = 0; i < 9; i++){

          if(grid[col][i] < 0 || grid[col][i] > 9){

            return false;
          }
          else
          { //Checking for repeated values.
            if(grid[col][i] != 0){
              if(s.contains(grid[col][i])== true){
                   //System.out.println("Row :"+i+" Col : "+col+" "+s);
                return false;
              }
              s.add(grid[col][i]);
            }
          }

        }
      return true;
  }
   boolean  isValidSubsquares(){
        for(int row = 0; row < 9; row = row + 3){
          for(int col = 0; col < 9; col = col + 3){
              Set<Integer> s=new HashSet<Integer>();
              for(int r = row; r < row + 3; r++){
                for(int c = col; c < col + 3; c++){

                  if(grid[r][c] < 0 || grid[r][c] > 9){

                  }
                  else{


                    if(grid[r][c] != 0){
                    if(s.contains(grid[r][c])== true){
                        //System.out.println("Row :"+row+" Col : "+c+" "+s);
                      return false;
                    }
                    s.add(grid[r][c]);
                  }
                  }
                }
              }    
          }
        }
        return true;
    }
   void checkValidBoard(){
  for(int i = 0; i < 9; i++){
    
    // If a row or a column is invalid, then the board is invalid.
    if(!isValidRow(i) || !isValidColumn(i)){
       // System.out.println("Row : "+i+" Valid : "+isValidRow(i));
       this.isValid=false;
      return ;
    }
  }
  // if any one the subsquares is invalid, then the board is invalid.
  
  if(isValidSubsquares()){
    this.isValid=true;
  }
  
}

    public boolean isValid() {
        return isValid;
    }
   
   void setXY(int x,int y,int v){
       grid[x][y]=v;
   }
}