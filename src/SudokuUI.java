import java.util.Arrays;

public class SudokuUI {

    //print the board with array  from utils
    public static void displayBoard(String[] boardPieces  ){
        String topBorder = "=========================================";
        System.out.println(topBorder);
        for(int i =0;i<boardPieces.length;i++){

            if(i==0 | i%9==0){
                if(i==27 | i==54){
                    System.out.println();
                    System.out.println(topBorder);
                    System.out.print("|| ");
                }
                else if(i==0){
                    System.out.print("|| ");
                }
                else{
                    System.out.println();
                    String btmBorder = "_________________________________________";
                    System.out.println(btmBorder);
                    System.out.print("|| ");
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
    }
    //print the main menu

}
