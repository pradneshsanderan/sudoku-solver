import java.util.Arrays;

public class SudokuUI {

    //print the board with array  from utils
    public static void displayBoard(String[] boardPieces  ){
        String topBorder = " ========================================";
        System.out.println("    1   2   3    4   5   6    7   8   9");
        System.out.println(topBorder);
        int j = 1;
        for(int i =0;i<boardPieces.length;i++){

            if(i==0 | i%9==0){
                if(i==27 | i==54){
                    System.out.println();
                    System.out.println(topBorder);
                    System.out.print(j+"|| ");
                    j++;
                }
                else if(i==0){
                    System.out.print(j+"|| ");
                    j++;
                }
                else{
                    System.out.println();
                    String btmBorder = " ________________________________________";
                    System.out.println(btmBorder);
                    System.out.print(j+"|| ");
                    j++;
                }
            }
            if(i==2 | (i-2)%3==0){
                System.out.print(boardPieces[i] + " || ");
            }
            else{
                System.out.print(boardPieces[i]+" | ");
            }


        }
        System.out.println();
        System.out.println(topBorder);
        System.out.println("    1   2   3    4   5   6    7   8   9");
    }
    //print the main menu

}
