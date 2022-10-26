import java.util.Arrays;
import java.util.Scanner;
public class Game {
    public static void main(String[] args) {
     
        //Testing board:
//         Board board = new Board();
//         Fen.load("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR", board);
//         System.out.println(board);

        Scanner input = new Scanner(System.in);
        int array[] = new int[4];
        
        System.out.println("What is your move? (format: [startRow][startCol][endRow][endCol]");
        for(int i = 0; i < 4; i++){
            array[i] = input.nextInt();
        }

        System.out.println("Array: " + Arrays.toString(array));
        
        //Grabbing the indexes from the array[]
        int startRow = array[0];
        int startCol = array[1];
        int endRow = array[2];
        int endCol = array[3];

        //Calling the board class
        Board myBoard = new Board();
        myBoard.movePiece(startRow, startCol, endRow, endCol);
        //Calling movePiece from the board class
        input.close();
    }






}
