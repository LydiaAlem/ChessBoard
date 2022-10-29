public class Queen {
    //Instance variables
    private int row;
    private int col;
    private boolean isBlack;

    //Constructer method
    public Queen(int row, int col, boolean isBlack){
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }
//Verifies if the move is both legal, verified, and diagonal
    public boolean isMoveLegal(Board board, int endRow, int endCol){
        if(board.verifySourceAndDestination(this.row, this.col, endRow, endCol, isBlack)){
            return(board.verifyDiagonal(this.row, this.col, endRow, endCol)); 
        }
        return false;
    }
}


