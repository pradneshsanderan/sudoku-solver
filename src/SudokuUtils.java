import java.util.Arrays;

import static java.util.Arrays.fill;

public class SudokuUtils {
    public static String[] boardPieces ;

    public static void initialiseBoarPieces(){
        String[] BoardPieces = new String[81];
        fill(BoardPieces, ".");
        boardPieces = BoardPieces;
    }



}
