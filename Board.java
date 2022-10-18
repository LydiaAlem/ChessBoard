public class Board {

    // Instance variables
    private Piece[][] board;
    int col;
    int row;
    //Piece piece;
    private Piece piece;

    
    //TODO:
    // Construct an object of type Board using given arguments.
    public Board() {
        this.board = new Piece[8][8];
        
    }

    // Accessor Methods

    //TODO:
    // Return the Piece object stored at a given row and column
    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    //TODO:
    // Update a single cell of the board to the new piece.
    public void setPiece(int row, int col, Piece piece) {
        this.row = row;
        this.col = col;
        this.piece = piece;
    }

    // Game functionality methods

    //TODO:
    // Moves a Piece object from one cell in the board to another, provided that
    // this movement is legal. Returns a boolean to signify success or failure.
    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {
        if (board[startRow][startCol].isMoveLegal(this, endRow, endCol)){
            return true;
        }
        return false;
    }

    //TODO:
    // Determines whether the game has been ended, i.e., if one player's King
    // has been captured.
    public boolean isGameOver() {

        int counter = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j].getCharacter() == '\u2654' || board[i][j].getCharacter() == '\u265a')
                    counter++;
                }
       if(counter != 2){
            return true;

    }
        return false;
}
    

    //TODO:
    // Construct a String that represents the Board object's 2D array. Return
    // the fully constructed String.
    public String toString() {

        return null;
    }

    //TODO:
    // Sets every cell of the array to null. For debugging and grading purposes.
    public void clear() {
        this.board[row][col] = null;

    }

    // Movement helper functions

    //TODO:
    // Ensure that the player's chosen move is even remotely legal.
    // Returns a boolean to signify whether:
    // - 'start' and 'end' fall within the array's bounds.
    // - Both contain a Piece object, i.e., not null.
    // - Player's color and color of 'start' Piece match.
    // - Destination contains either no Piece or a Piece of the opposite color.
    public boolean verifySourceAndDestination(int startRow, int startCol, int endRow, int endCol, boolean isBlack) {
        
        






        return false;
    }

    //TODO:
    // Check whether the 'start' position and 'end' position are adjacent to each other
    public boolean verifyAdjacent(int startRow, int startCol, int endRow, int endCol) {
        return false;
    }

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid horizontal move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one row.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyHorizontal(int startRow, int startCol, int endRow, int endCol) {
        return false;
    }

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid vertical move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one column.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyVertical(int startRow, int startCol, int endRow, int endCol) {
        return false;
    }

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid diagonal move.
    // Returns a boolean to signify whether:
    // - The path from 'start' to 'end' is diagonal... change in row and col.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyDiagonal(int startRow, int startCol, int endRow, int endCol) {
        return false;
    
    }
}
}

