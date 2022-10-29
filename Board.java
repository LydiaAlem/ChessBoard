public class Board {
    private Piece[][] board;

    public Board() {
        this.board = new Piece[8][8];
    }

    public Piece getPiece(int row, int col) {
        return this.board[row][col];
    }

    public void setPiece(int row, int col, Piece piece) {
        this.board[row][col] = piece;
    }

    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {
        boolean bool = startRow >= 0 && startCol >= 0 && startRow < 8 && startCol < 8 && endRow >= 0 && endCol >= 0 && endRow < 8 && endCol <8; //Making sure user input is IN BOUNDS
        if (bool && this.board[startRow][startCol] != (null) && this.board[startRow][startCol].isMoveLegal(this, endRow, endCol)) {
            board[endRow][endCol] = board[startRow][startCol];
            board[endRow][endCol].setPosition(endRow, endCol);
            board[endRow][endCol].pawnPromotion();
            board[startRow][startCol] = null;
            return true;
        }
        return false;
    }

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
    public boolean check_winner(){
        for(int i = 0; i< board.length; i++){
            for(int j = 0; j<board[i].length;j++){
                if(board[i][j] != null){
                    if(board[i][j].getCharacter() == '\u265a'){
                        System.out.println("Game over... \n Congrats! \n Black has won");
                        return true;
                    }
                }
            }
        }
        System.out.println("Game over... \nCongrats! \nWhite has won");
        return false;
    }

    public String toString() {
        String map = "Board: " + "\n" + "   0 1 2 3 4 5 6 7 " + "\n";
        for(int i=0; i<= 7; i++){
            map += Integer.toString(i) + " |";
            for(int j=0; j<=7; j++){
                if(board[i][j] != (null)){ 
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

    public boolean verifySourceAndDestination(int startRow, int startCol, int endRow, int endCol, boolean isBlack) {
        if(startRow <= 7 && startCol <= 7 && endRow <= 7 & endCol <= 7){ //Checks bounds check if greater than or equal to 0
            if(board[startRow][startCol] != null){  //Checks empty piece
                    if(board[startRow][startCol].getIsBlack() == isBlack){ //checks if oponents piece is black
                        if(board[endRow][endCol] == (null) || board[endRow][endCol].getIsBlack() != isBlack){
                            return true;
                        }
                    }
                }
            }
        return false;
    }
    public boolean verifyAdjacent(int startRow, int startCol, int endRow, int endCol) {
        if(endRow - startRow == -1|| endRow - startRow == 1){ //checks top and bottom
            return true;
        }
        if(endCol - startCol == -1|| endCol - startCol == 1){ //checks sides
            return true;
        }
        if(endRow - startRow == -1|| endRow - startRow == 1){ //checks top and bottom
            return true;
        }
        if(Math.abs(endRow-startRow) == Math.abs(endCol-startCol)){// checks diagonal
            return true;
        }
        else {
            return false;
        }
    }

    public boolean verifyHorizontal(int startRow, int startCol, int endRow, int endCol) {
        if(startRow == endRow){
            for(int i = 0; i <= endCol; i++){
                if((board[endRow][endCol + i]) != null || (board[endRow][endCol - i] != null)){
                    return true;
                }
            }
        }
    return false;
    }

    public boolean verifyVertical(int startRow, int startCol, int endRow, int endCol) {
        if (startCol == endCol){
        for(int i = 0; i <= endRow; i++){
            if((board[endRow + i][endCol]) != null|| (board[endRow - i][endCol] != null)){
                return true;
            }   
        }
    }
        return false;
    }

    public boolean verifyDiagonal(int startRow, int startCol, int endRow, int endCol) {
        for(int i = 0; i <= board.length;i++){
            for(int j = 0; j< board[i].length; j++){
            if((board[endRow + j][endCol + i]) != null || (board[endRow + j][endCol - i] != null) || (board[endRow - j][endCol + i] != null) || (board[endRow - j][endCol - i]) != null){
                return true;
            } 
        }
        }
    return false;
    }
}
