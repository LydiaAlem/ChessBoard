public static void main(String[] args) {
        Board gameBoard = new Board();
        Fen.load("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR", gameBoard);
        System.out.print(gameBoard.toString());
        while(gameBoard.isGameOver() == false){
            //implement all methods for game to work
            Scanner input = new Scanner(System.in);
            System.out.print("What is your move? (format: [startRow][startCol][endRow][endCol]: ");
            int startRow = input.nextInt();
            int startCol = input.nextInt();
            int endRow = input.nextInt();
            int endCol = input.nextInt();
            while(gameBoard.movePiece(startRow, startCol, endRow, endCol) == false){
                Scanner input1 = new Scanner(System.in);
                System.out.print("Invalid input! You can not move here. Please enter a new move: ");
                startRow = input.nextInt();
                startCol = input.nextInt();
                endRow = input.nextInt();
                endCol = input.nextInt();
                input1.close();
            }
            isBlack != isBlack;
            //Calling the board class
            gameBoard.movePiece(startRow, startCol, endRow, endCol);
            //Calling movePiece from the board class
            input.close();
            //if(gameBoard[])
        }
        // if(gameBoard.getPiece(row, col) == '\u2659'){
        //     gameBoard.getPiece().promotion();
        // }
        // public boolean check_piece(){
        //     if(gameBoard.getPiece(row, col).equals('\u2659')){
        //         gameBoard.getPiece(row, col).promotion();
        //         return true;
        //     }
        //     if(gameBoard.getPiece(row, col).equals( '\u265f')){
        //         gameBoard.getPiece(row, col).promotion();
        //         return true;
        //     }
        
        //         // gameBoard.getPiece() == '\u265f'
        // return false;
        // }

        // String color = " ";
        
    }
}
