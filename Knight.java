public class Knight {
    //Instance
    private int row;
    private int col;
    private boolean isBlack;

    //Constructer:
    public Knight(int row, int col, boolean isBlack){
        this.row= row;
        this.col = col;
        this.isBlack = isBlack;
    }

    public boolean isMoveLegal(Board board, int endRow, int endCol){
        if(board.verifySourceAndDestination(this.row, this.col, endRow, endCol, this.isBlack)){
            if(((this.row + 2) == endRow ) && (this.col -1 == endCol)){
                return true; //Checks BOTTOM left
            }
            if(((this.row + 1) == endRow && this.col -2 == endCol)){
                return true; //Checks lower left
            }
            if(((this.row - 1) == endRow && this.col - 2 == endCol)){
                return true; //Checks upper left
            }
            if(((this.row - 2) == endRow && this.col - 1 == endCol)){
                return true; //Checks TOP LEFT
            }
            if(((this.row - 1) == endRow && this.col + 2 == endCol)){
                return true; //Checks upper right
            }
            if(((this.row + 2) == endRow && this.col + 1 == endCol)){
                return true; //Checks BOTTOM right
            }
            if(((this.row + 1) == endRow && this.col + 2 == endCol)){
                return true; //Checks lower right
            }
            if(((this.row -2 ) == endRow && this.col + 1 == endCol)){
                return true; //Checks TOP right
            }
        }
        return false;
    }
}
