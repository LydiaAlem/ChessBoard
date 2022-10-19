public class King {

    private int row;
    private int col;
    private boolean isBlack;

    public King(int row, int col, boolean isBlack){
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    public boolean isMoveLegal(Board board, int endRow, int endCol){
        if (board.verifyDiagonal(this.row, this.col, endRow, endCol) && board.getPiece(endRow, endCol) == null) {
            // Case 1: Forward movement to empty square.
            if (this.isBlack) {
                return (endRow == this.row + 1) || ((endRow == this.row + 2) && (this.row == 1));
            } else {
                return (endRow == this.row - 1) || ((endRow == this.row - 2) && (this.row == 6));
            }
}
//Not completed YET
      
