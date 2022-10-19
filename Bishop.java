//NOT COMPLETED!!
public class Bishop {
    //Instance variables
    private int row;
    private int col;
    private boolean isBlack;

    public Bishop(int row, int col, boolean isBlack){
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

  
  //the reason why i am using the verifyAdjacent method from Board.java, is because the queen can only move diagonaly IF they are nothing on that square
    public boolean isMoveLegal(Board board, int endRow, int endCol){
        //Case 1: Move to the empty ADJACENT square
        if(board.verifyAdjacent(this.row, this.col, endRow, endCol) && board.getPiece(endRow, endCol) == null){

        }
        //Case 2: Capture the piece
        else if {
          //Continue


        }
        //Case 3: Illegal Move
        else { 
          //Continue
          
        }
        return isBlack;//Ignore for now
    }
    
}

