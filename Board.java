public class Board {

    // Instance variables
    private Piece[][] board;
    int row;
    int col;

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
    }

    // Game functionality methods

    //TODO:
    // Moves a Piece object from one cell in the board to another, provided that
    // this movement is legal. Returns a boolean to signify success or failure.
    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {
        if(board[startRow][startCol].isMoveLegal(this,endRow,endCol)) {
            board[startRow][startCol ]= board[endRow][endCol];
            return true;
        }
        return false;
    }

    //TODO:
    // Determines whether the game has been ended, i.e., if one player's King
    // has been captured.
    public boolean isGameOver() {
        int count = 0;
        for(int i = 0; i< board.length; i++){
            for(int j = 0; j<board[i].length;i++){
                if(board[i][j].getCharacter() == '\u265a' || board[i][j].getCharacter() == '\u2654')
                    count++;
                }
            if(count != 2){
                return true;
            }
        }
        return false;
    }
        

    //TODO:
    // Construct a String that represents the Board object's 2D array. Return
    // the fully constructed String.
    public String toString() {
        String map = "Board: " + "\n" + " 0 1 2 3 4 5 6 7" + "\n";
        for(int i=0; i<= 7; i++){
            map += Integer.toString(i) + "|";
            for(int j=0; j<=7; j++){
                if(board[i][j] != (null)){ // ASK OH
                    map += board[i][j].getCharacter() + "|"; 
                }
                else{
                    map += " |";
                }
            }
            map += "\n";
        }
        return map;
    }

    //TODO:
    // Sets every cell of the array to null. For debugging and grading purposes.
    public void clear() {  
        for(int i = 0; i<this.board[row].length; i++){
            for(int j = 0; j<this.board[col].length; j++){
               this.board[row][col] = null;
            }
        }
    }

    // Movement helper functions

    //TODO:
    // Ensure that the player's chosen move is even remotely legal.
    // Returns a boolean to signify whether:
    // - 'start' and 'end' fall within the array's bounds.
    // - 'start' contains a Piece object, i.e., not null.
    // - Player's color and color of 'start' Piece match.
    // - 'end' contains either no Piece or a Piece of the opposite color.
    public boolean verifySourceAndDestination(int startRow, int startCol, int endRow, int endCol, boolean isBlack) {
        if(startRow<= 7 && startCol<=7 && endRow<=7&& startRow<= 7){
            if(!board[startRow][startCol].equals(null)){
                if(board[startRow][startCol].getIsBlack() == isBlack){
                    if(board[endRow][endCol].equals(null)|| board[endRow][endCol].getIsBlack()!= isBlack){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //TODO:
    // Check whether the 'start' position and 'end' position are adjacent to each other
    public boolean verifyAdjacent(int startRow, int startCol, int endRow, int endCol) {
        if(board[startRow+1][startCol] == board[endRow][endCol]){//check below
            return true;
        }
        if(board[startRow-1][startCol] == (board[endRow][endCol])){//check above
            return true;
        }
        if(board[startRow][startCol+1] == (board[endRow][endCol])){//check right
            return true;
        }
        if(board[startRow][startCol-1] == (board[endRow][endCol])){//check left
            return true;
        }
        if(board[startRow-1][startCol-1] == (board[endRow][endCol])){//up one, left one
            return true;
        }
        if(board[startRow+1][startCol+1] == (board[endRow][endCol])){//down one, right one
            return true;
        }
        if(board[startRow-1][startCol+1] == (board[endRow][endCol])){//up one, right one
            return true;
        }
        if(board[startRow+1][startCol-1] == (board[endRow][endCol])){//down one, left one
            return true;
        }
        return false;
        //within one box of each other horizontal or vertical or diagonal
    }

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid horizontal move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one row.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyHorizontal(int startRow, int startCol, int endRow, int endCol) {
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                if(board[startRow+i][startCol] == (board[endRow][endCol])){
                    return true;
                }
            }
        }
        return false;
    }

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid vertical move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one column.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyVertical(int startRow, int startCol, int endRow, int endCol) {
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                if(board[startRow][startCol+i] == (board[endRow][endCol])){
                    return true;
                }
            }
        }
        return false;
    }

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid diagonal move.
    // Returns a boolean to signify whether:
    // - The path from 'start' to 'end' is diagonal... change in row and col.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyDiagonal(int startRow, int startCol, int endRow, int endCol) {
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                if(board[startRow+i][startCol+i] == (board[endRow][endCol])){
                    return true;
                }
            }
        }
        return false;
    }
    // public booelan check_piece(){
    //     Board gameBoard = new Board();
    //     if(gameBoard.getPiece(row, col).equals('\u2659')){
    //         gameBoard.getPiece(row, col).promotion();
    //         return true;
    //     }
    //     if(gameBoard.getPiece(row, col).equals( '\u265f')){
    //         gameBoard.getPiece(row, col).promotion();
    //         return true;
    //     }
    
    //         // gameBoard.getPiece() == '\u265f'
    //     return false;
    // }
     
}

