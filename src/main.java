import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        //start game
        System.out.println("WELCOME TO SUDOKU SOLVER");
        boolean chosen = false;
        int choice = 0;
        while (!chosen){
            System.out.println("PLEASE CHOOSE ONE OF THE FOLLOWING" +
                    "\n(1) ADD A SUDOKU AND HAVE IT SOLVED" +
                    "\n(2) EXIT");
            Scanner n = new Scanner(System.in);
            if(n.hasNextInt()){
                choice = n.nextInt();
                chosen = true;
            }
        }
        switch (choice) {
            case 1:
                SudokuUtils.addPieces(SudokuUtils.initialiseBoardPieces(SudokuUtils.boardPieces));
                SudokuUtils.setBoxArray();
                SudokuUtils.setColArray();
                SudokuUtils.setRowArray();
                boolean done = false;
                while (!done){
                    SudokuUtils.addPieces(SudokuUtils.boardPieces);
                    Scanner n = new Scanner(System.in);
                    System.out.println("ARE YOU DONE?" +
                            "\n INPUT 'Y' FOR YES AND 'N' FOR NO");
                    if(n.next().toUpperCase().equals("Y")){
                        done = true;
                    }
                }
                boolean over=false;
                while(!over){
                    SudokuUtils.fillInArrays();
                    SudokuUtils.solvePuzzle();


                    if(SudokuUtils.isGameOver()){
                        over=true;
                    }
                }
                SudokuUI.displayBoard(SudokuUtils.boardPieces);

                break;
            case 0:


                break;
            default:

                break;
        }





        //get an empty board
        //input the numbers
        // choose a button when done
        //computate the result
        // print the result

    }
}
