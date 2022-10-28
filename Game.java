import java.util.Scanner;
public class Game {
    public static void main(String[] args) {
    
        //Testing board:
        Board gameBoard = new Board();
        boolean isBlack = false;
        Fen.load("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR", gameBoard);
        System.out.println(gameBoard.toString());
        Scanner input = new Scanner(System.in);

        while(gameBoard.isGameOver() == false){
            //implement all methods for game to work

            //CHECKS WHO'S TURN IT IS
            isBlack = !isBlack;
            if(isBlack == false){
                System.out.println("\nIt's now whites turn.");
            }else{
                System.out.println("\nIt's now black's turn.");
            }

            System.out.print("What is your move? (format: [startRow][startCol][endRow][endCol]): ");
            int startRow = input.nextInt();
            int startCol = input.nextInt();
            int endRow = input.nextInt();
            int endCol = input.nextInt();
            //gameBoard.movePiece(startRow, startCol, endRow, endCol);

            if(gameBoard.movePiece(startRow, startCol, endRow, endCol) == true){
                //Scanner input1 = new Scanner(System.in);
                // startRow = input.nextInt();
                // startCol = input.nextInt();
                // endRow = input.nextInt();
                // endCol = input.nextInt();
                //input1.close();
                System.out.println("Great move!");
                System.out.println(gameBoard.toString());
                gameBoard.movePiece(startRow, startCol, endRow, endCol);
            }else{
                System.out.println("Invalid input! You can not move here. Please enter a new move: ");
                System.out.println(gameBoard.toString());
            }
        }
    input.close();
}
}
