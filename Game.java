public static void main(String[] args) {
        Board gameBoard = new Board();
        boolean isBlack = false;
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
                gameBoard.movePiece(startRow, startCol, endRow, endCol);
            }
            isBlack = !isBlack;
            if(isBlack == false){
                System.out.println("It's now whites turn.");
                // Scanner input2 = new Scanner(System.in);
                // System.out.print("What is your move? (format: [startRow][startCol][endRow][endCol]: ");
                // startRow = input.nextInt();
                // startCol = input.nextInt();
                // endRow = input.nextInt();
                // endCol = input.nextInt();
                // input2.close();
                // gameBoard.movePiece(startRow, startCol, endRow, endCol);
            }else{
                System.out.println("It's not black's turn.");
                // Scanner input3 = new Scanner(System.in);
                // System.out.print("What is your move? (format: [startRow][startCol][endRow][endCol]: ");
                // startRow = input.nextInt();
                // startCol = input.nextInt();
                // endRow = input.nextInt();
                // endCol = input.nextInt();
                // input3.close();
                // gameBoard.movePiece(startRow, startCol, endRow, endCol);
            }
            input.close();
        } 
