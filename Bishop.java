public class Bishop {
    public class Bishop {
    //Instance variables
    private int row;
    private int col;
    private boolean isBlack;

    //Constructur
    public Bishop(int row, int col, boolean isBlack){
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }
    //Begins by checking if the move is legal & if the endRow and endCol are being placed in a verified source
    //Then return true if endCol and endRow are being moved DIAGONALLY
    public boolean isMoveLegal(Board board, int endRow, int endCol){
        if(board.verifySourceAndDestination(this.row, this.col, endRow, endCol, isBlack){
            return(board.verifyDiagonal(this.row, this.col, endRow, endCol));
        }
    }
    
}
