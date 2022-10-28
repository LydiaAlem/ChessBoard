public class Board {
    // Instance variables
    private Piece[][] board;

    //TODO:
    // Construct an object of type Board using given arguments.
    public Board() {
        this.board = new Piece[8][8];
    }

    // Accessor Methods
    //TODO:
    // Return the Piece object stored at a given row and column
    public Piece getPiece(int row, int col) {
        return this.board[row][col];
    }

    //TODO:
    // Update a single cell of the board to the new piece.
    public void setPiece(int row, int col, Piece piece) {
        this.board[row][col] = piece;
    }

    // Game functionality methods

    //TODO:
    // Moves a Piece object from one cell in the board to another, provided that
    // this movement is legal. Returns a boolean to signify success or failure.
    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {
        if (this.board[startRow][startCol] != null && this.board[startRow][startCol].isMoveLegal(this, endRow, endCol)) {
            board[endRow][endCol] = board[startRow][startCol];
            board[endRow][endCol].setPosition(endRow, endCol);
            board[startRow][startCol] = null;
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
                if(board[i][j] != null && (board[i][j].getCharacter() == '\u2654' || board[i][j].getCharacter() == '\u265a')) {
                    counter = counter + 1;
                }
            }
        }
        if(counter != 2){
            return true;
        }
        return false;
    }

    //TODO:
    // Construct a String that represents the Board object's 2D array. Return
    // the fully constructed String.
    //How do i do this???
    public String toString() {
        String map = "Board: " + "\n" + "   0 1 2 3 4 5 6 7 " + "\n";
        for(int i=0; i<= 7; i++){
            map += Integer.toString(i) + " |";
            for(int j=0; j<=7; j++){
                //System.out.print(board[i][j]);
                if(board[i][j] != (null)){ // ASK OH
                    //System.out.print('k');
                    map += board[i][j].getCharacter() + "|" ; 
                }
                else{
                    map += " |";
                }
            }
            map += "\n";
        }
        return map;
    }

    public void clear() {
        for(int i = 0; i < this.board.length; i++){
            for(int j = 0; j< this.board[i].length; j++){
                this.board[i][j]= null;
            }
        }
    }

    // Movement helper functions
    
//Finished
    public boolean verifySourceAndDestination(int startRow, int startCol, int endRow, int endCol, boolean isBlack) {
        if(startRow <= 7 && startCol <= 7 && endRow <= 7 & endCol <= 7){ //Checks bounds check if greater than or equal to 0
            if(board[startRow][startCol].equals(null)){  //Checks empty piece
                    if(board[startRow][startCol].getIsBlack() == isBlack){ //checks if oponents piece is black
                        if(board[endRow][endCol].equals(null) || board[endRow][endCol].getIsBlack() != isBlack){
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
        //to help others use switch statement
        
        if(board[startRow][startCol + 1] == (board[endRow][endCol])){ //Check right
            return true;
        } 

        else if(board[startRow + 1][startCol + 1] == (board[endRow][endCol])){ //Checks bottom right corner
            return true;
        }

        else if(board[startRow - 1][startCol] == (board[endRow][endCol])) {//checks right
            return true; 
        }

        else if(board[startRow -1][startCol -1] == (board[endRow][endCol])){ //checks upper left corner
            return true;
        }

        else if(board[startRow][startCol - 1] == (board[endRow][endCol])){ //checks ABOVE pieve
            return true;
        }

        else if(board[startRow-1][startCol+1] == (board[endRow][endCol])){ //checks bottem left corner
            return true;
        }

        else if(board[startRow+1][startCol - 1] == (board[endRow][endCol])){ //checks upper right corner
            return true;
        }

        else if(board[startRow +1][startCol] == (board[endRow][endCol])){ //checks left
            return true;
        }

        else {
            return false;
        }
    }

    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyHorizontal(int startRow, int startCol, int endRow, int endCol) {
        for(int i = 0; i < board.length; i++){
                if((board[endRow][endCol + i]) != null || (board[endRow][endCol - i] != null)){
                    return true;
                }
            }
        
    return false; 
    }

    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyVertical(int startRow, int startCol, int endRow, int endCol) {
        for(int i = 0; i < board.length; i++){
            if((board[endRow + i][endCol]) != null|| (board[endRow - i][endCol] != null)){
                return true;
            }   
        }
        return false;
    }
    
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyDiagonal(int startRow, int startCol, int endRow, int endCol) {
        for(int i = 0; i < board.length;i++){
            for(int j = 0; j< board.length; j++){
            if((board[endRow + j][endCol + i]) != null || (board[endRow + j][endCol - i] != null) || (board[endRow - j][endCol + i] != null) || (board[endRow - j][endCol - i]) != null){
                return true;
            } 
        }
        }
    return false;
    }
}
