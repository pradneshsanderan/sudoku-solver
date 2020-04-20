import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.fill;

public class SudokuUtils {
    public static int dim =9;

    public static String[] initialiseBoardPieces(){
        String[] BoardPieces = new String[81];
        fill(BoardPieces, ".");
        return BoardPieces;
    }
    public static void addPieces(String[] BoardPieces){
        System.out.println("PLEASE ENTER THE SUDOKU PUZZLE INTO THE DIAGRAM");
        System.out.println("ENTER THE ROW FOLLOWED BY THE COLLUMN FOLLOWED BY THE NUMBER");
        Scanner n = new Scanner(System.in);
        int row = n.nextInt();
        int column =n.nextInt();
        int number = n.nextInt();
        int position = (dim*(row-1))+(column-1);
        BoardPieces[position] =String.valueOf(number);
        System.out.println(BoardPieces[position]);

    }

    public static void main(String[] args) {
        addPieces(initialiseBoardPieces());
    }

    



}
