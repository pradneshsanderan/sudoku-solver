import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.fill;

public class SudokuUtils {
    public static int dim =9;
    public static String[] boardPieces = new String[81];
    public static ArrayList<String[]> boardArrays = new ArrayList<>();

    public static String[] initialiseBoardPieces(String[] BoardPieces){
        fill(BoardPieces, ".");
        return BoardPieces;
    }
    public static void addPieces(String[] BoardPieces){
        SudokuUI.displayBoard(BoardPieces);
        System.out.println("PLEASE ENTER THE SUDOKU PUZZLE INTO THE DIAGRAM");
        int[] input = new int[3];
        boolean valid = false;
        while(!valid){
            getInput(input);
            final int row = input[0];
            final int column = input[1];
            final int number = input[2];
            boolean validInput = row <10 & row >0 & column <10 & column >0 & number <10 & number >0;
            if(validInput){
                valid = true;
                int position = (dim*(row -1))+(column -1);
                BoardPieces[position] =String.valueOf(number);

            }
        }

    }

    private static void getInput(int[] input) {

        boolean valid = false;

        while(!valid){
            System.out.println("THE INPUT FOR ROW,COLUMN AND THE NUMBER MUST BE BETWEEN 1-9");
            System.out.println("ENTER THE ROW FOLLOWED BY THE COLLUMN FOLLOWED BY THE NUMBER");
            Scanner n = new Scanner(System.in);
            if (!n.hasNextInt()) {
                continue;
            }
            input[0]= n.nextInt();
            if (!n.hasNextInt()) {
                continue;
            }
            input[1] =n.nextInt();
            if (!n.hasNextInt()) {
                continue;
            }
            input[2] = n.nextInt();
            valid=true;
        }




    }

    public static void makeArrays(){
        for(int i =0;i<boardPieces.length;i++){
            String[] newArray = new String[9];
            for(int j=1;j<newArray.length+1;j++){
                newArray[j]=String.valueOf(j);
            }
            boardArrays.add(newArray);
        }
    }

    public static void checkRow(){

    }

    public static void checkColumn(){
        
    }


    public static void main(String[] args) {
        addPieces(initialiseBoardPieces(boardPieces));
    }

    



}
