import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.fill;

public class SudokuUtils {
    public static int dim =9;
    public static String[] boardPieces = new String[81];

    public static String[] initialiseBoardPieces(String[] BoardPieces){
        fill(BoardPieces, ".");
        return BoardPieces;
    }
    public static void addPieces(String[] BoardPieces){
        boolean valid = false;
        System.out.println("PLEASE ENTER THE SUDOKU PUZZLE INTO THE DIAGRAM");
        System.out.println("ENTER THE ROW FOLLOWED BY THE COLLUMN FOLLOWED BY THE NUMBER");
        Scanner n = new Scanner(System.in);
        int row = n.nextInt();
        int column =n.nextInt();
        int number = n.nextInt();
        boolean validInput = row<10 & row>0 & column<10 & column>0 & number<10 & number>0;
       if(!valid){
           while (!valid){
           }

       }




        int position = (dim*(row-1))+(column-1);
        BoardPieces[position] =String.valueOf(number);

    }

    public static void main(String[] args) {
        addPieces(initialiseBoardPieces(boardPieces));
    }

    



}
