public class King {

    //Instance variable
    private int row;
    private int col;
    private boolean isBlack;

    //Constructor
    public King(int row, int col, boolean isBlack){
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }
//Tests if the the move is legal, and returns a boolean if that piece if moving to an adjacent piece
    public boolean isMoveLegal(Board board, int endRow, int endCol){
        if(board.verifySourceAndDestination(this.row, this.col, endRow, endCol, isBlack)){
            return(board.verifyAdjacent(this.row, this.col, endRow, endCol));

    }
        else{
            return false;
        }
    }
}


    
