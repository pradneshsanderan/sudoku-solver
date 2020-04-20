import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.fill;

public class SudokuUtils {
    public static String[] boardPieces ;

    public static void initialiseBoarPieces(){
        String[] BoardPieces = new String[81];
        fill(BoardPieces, ".");
        boardPieces = BoardPieces;
    }
    public static void addPieces(){
        System.out.println("PLEASE ENTER THE SUDOKU PUZZLE INTO THE DIAGRAM");
        System.out.println("ENTER THE ROW FOLLOWED BY THE COLLUMN FOLLOWED BY THE NUMBER");
        Scanner n = new Scanner(System.in);
        int row = n.nextInt();
        int column =n.nextInt();
        int number = n.nextInt();
        System.out.println("row" + row);
        System.out.println("col" + column);
        System.out.println("num" +number);
        System.out.println(n);
    }

    



}
