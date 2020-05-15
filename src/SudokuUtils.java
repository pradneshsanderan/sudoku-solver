import java.util.ArrayList;
import java.util.Scanner;

import static java.util.Arrays.fill;

public class SudokuUtils {
    public static int dim =9;
    public static String[] boardPieces = new String[81];
    public static  String[] row1 = new String[9];
    public static  String[] row2 = new String[9];
    public static  String[] row3 = new String[9];
    public static  String[] row4 = new String[9];
    public static  String[] row5 = new String[9];
    public static  String[] row6 = new String[9];
    public static  String[] row7 = new String[9];
    public static  String[] row8 = new String[9];
    public static  String[] row9 = new String[9];
    public static  String[] col1 = new String[9];
    public static  String[] col2 = new String[9];
    public static  String[] col3 = new String[9];
    public static  String[] col4 = new String[9];
    public static  String[] col5 = new String[9];
    public static  String[] col6 = new String[9];
    public static  String[] col7 = new String[9];
    public static  String[] col8 = new String[9];
    public static  String[] col9 = new String[9];
    public static  String[] box1 = new String[9];
    public static  String[] box2 = new String[9];
    public static  String[] box3 = new String[9];
    public static  String[] box4 = new String[9];
    public static  String[] box5 = new String[9];
    public static  String[] box6 = new String[9];
    public static  String[] box8 = new String[9];
    public static  String[] box7 = new String[9];
    public static  String[] box9 = new String[9];
    public static String[][] rowArrays = new String[][]{row1,row2,row3,row4,row5,row6,row7,row8,row9};
    public static String[][] colArrays = new String[][]{col1,col2,col3,col4,col5,col6,col7,col8,col9};
    public static String[][] boxArrays = new String[][]{box1,box2,box3,box4,box5,box6,box7,box8,box9};



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
//
//    public static void makeArrays(){
//        for(int i =0;i<boardPieces.length;i++){
//            String[] newArray = new String[9];
//            for(int j=1;j<newArray.length+1;j++){
//                newArray[j]=String.valueOf(j);
//            }
//            boardArrays.add(newArray);
//        }
//    }
    public static void setRowArray(){
        fill(row1, ".");
        fill(row2, ".");
        fill(row3, ".");
        fill(row4, ".");
        fill(row9, ".");
        fill(row5, ".");
        fill(row6, ".");
        fill(row7, ".");
        fill(row8, ".");


    }
    public static void setColArray(){
        fill(col1, ".");
        fill(col2, ".");
        fill(col3, ".");
        fill(col4, ".");
        fill(col5, ".");
        fill(col6, ".");
        fill(col7, ".");
        fill(col8, ".");
        fill(col9, ".");

    }
    public static  void setBoxArray(){
        fill(box1, ".");
        fill(box2, ".");
        fill(box3, ".");
        fill(box4, ".");
        fill(box5, ".");
        fill(box6, ".");
        fill(box7, ".");
        fill(box8, ".");
        fill(box9, ".");
        ;
    }

    public static void fillInArrays(){
        for(int i=0;i<boardPieces.length;i++){
            if(!boardPieces[i].equals(".")){
                int[] coordinates = getCoordinates(i);
                fillRowArray(coordinates[0],boardPieces[i]);
                fillColArray(coordinates[0],boardPieces[i]);
                fillBoxArray(i,boardPieces[i]);

            }
        }
    }

    public static void solvePuzzle(){
        for(int i=0;i<boardPieces.length;i++){
            if(boardPieces[i].equals(".")){
                int[] coordinates = getCoordinates(i);
                String[] rowArray= rowArrays[coordinates[0]-1];
                String[] colArray= colArrays[coordinates[0]-1];
                ArrayList<Integer> boxList = checkBoxes(i);
                ArrayList<Integer> rowList = new ArrayList<>();
                ArrayList<Integer> colList = new ArrayList<>();
                for(int j=0;j<rowArray.length;j++){
                    if(rowArray[j].equals(".")){
                        rowList.add(j+1);
                    }
                }
                for(int k=0;k<colArray.length;k++){
                    if(rowArray[k].equals(".")){
                        colList.add(k+1);
                    }
                }
                if(boxList.size()==1 & colList.size()!=1 & rowList.size()!=1){
                    boardPieces[i]= String.valueOf(boxList.get(0));
                }
                if(boxList.size()!=1 & colList.size()==1 & rowList.size()!=1){
                    boardPieces[i] = String.valueOf(colList.get(0));
                }
                if(boxList.size()!=1 & colList.size()!=1 & rowList.size()==1){
                    boardPieces[i] = String.valueOf(rowList.get(0));
                }
                if(boxList.size()==1 && colList.size()==1 & rowList.size()!=1){
                    if(boxList.get(0).equals(colList.get(0))){
                        boardPieces[i]= String.valueOf(boxList.get(0));
                    }
                }
                if(boxList.size()==1 && colList.size()!=1 & rowList.size()==1){
                    if(boxList.get(0).equals(rowList.get(0))){
                        boardPieces[i]= String.valueOf(boxList.get(0));
                    }
                }
                if(boxList.size()!=1 && colList.size()==1 & rowList.size()==1){
                    if(rowList.get(0).equals(colList.get(0))){
                        boardPieces[i]= String.valueOf(rowList.get(0));
                    }
                }
                if(boxList.size()==1 && colList.size()==1 & rowList.size()==1){
                    if(boxList.get(0).equals(colList.get(0)) & boxList.get(0).equals(rowList.get(0))){
                        boardPieces[i]= String.valueOf(boxList.get(0));
                    }
                }
            }


        }
    }

    private static ArrayList<Integer> checkBoxes(int i) {
        ArrayList<Integer> spaces = new ArrayList<>();
        if(i ==0| i ==1| i ==2| i ==9| i ==10| i ==11| i ==18| i ==19| i ==20){
            //check box array
            for(int j =0;j<box1.length;j++){
                if(box1[j].equals(".")){
                    spaces.add(j+1);
                }
            }
        }
        if(i ==3| i ==4| i ==5| i ==12| i ==13| i ==14| i ==21| i ==22| i ==23){
            for(int j =0;j<box1.length;j++){
                if(box1[j].equals(".")){
                    spaces.add(j);
                }
            }
        }
        if(i ==6| i ==7| i ==8| i ==15| i ==16| i ==17| i ==24| i ==25| i ==26){
            for(int j =0;j<box1.length;j++){
                if(box1[j].equals(".")){
                    spaces.add(j);
                }
            }
        }
        if(i ==27| i ==28| i ==29| i ==36| i ==37| i ==38| i ==45| i ==46| i ==47){
            for(int j =0;j<box1.length;j++){
                if(box1[j].equals(".")){
                    spaces.add(j);
                }
            }
        }
        if(i ==30| i ==31| i ==32| i ==39| i ==40| i ==41| i ==48| i ==49| i ==50){
            for(int j =0;j<box1.length;j++){
                if(box1[j].equals(".")){
                    spaces.add(j);
                }
            }
        }
        if(i ==33| i ==34| i ==35| i ==42| i ==43| i ==44| i ==51| i ==52| i ==53){

        }for(int j =0;j<box1.length;j++){
            if(box1[j].equals(".")){
                spaces.add(j);
            }
        }
        if(i ==54| i ==55| i ==56| i ==63| i ==64| i ==65| i ==72| i ==73| i ==74){
            for(int j =0;j<box1.length;j++){
                if(box1[j].equals(".")){
                    spaces.add(j);
                }
            }
        }
        if(i ==57| i ==58| i ==59| i ==66| i ==67| i ==68| i ==75| i ==76| i ==77){
            for(int j =0;j<box1.length;j++){
                if(box1[j].equals(".")){
                    spaces.add(j);
                }
            }
        }
        if(i ==60| i ==61| i ==62| i ==69| i ==70| i ==71| i ==78| i ==79| i ==80){
            for(int j =0;j<box1.length;j++){
                if(box1[j].equals(".")){
                    spaces.add(j);
                }
            }
        }
        return spaces;
    }

    public static void fillRowArray(int row,String number){
        String[] arraytofill = rowArrays[row-1];
        int num = Integer.parseInt(number);
        arraytofill[num-1]=number;
    }
    public static void fillColArray(int col,String number){
        String[] arraytofill = colArrays[col-1];
        int num = Integer.parseInt(number);
        arraytofill[num-1]=number;
    }
    public static void fillBoxArray(int pos,String number){
        if(pos==0|pos==1|pos==2|pos==9|pos==10|pos==11|pos==18|pos==19|pos==20){
            String[] arraytofill =box1;
            int num = Integer.parseInt(number);
            arraytofill[num-1]=number;
        }
        if(pos==3|pos==4|pos==5|pos==12|pos==13|pos==14|pos==21|pos==22|pos==23){
            String[] arraytofill =box2;
            int num = Integer.parseInt(number);
            arraytofill[num-1]=number;
        }
        if(pos==6|pos==7|pos==8|pos==15|pos==16|pos==17|pos==24|pos==25|pos==26){
            String[] arraytofill =box3;
            int num = Integer.parseInt(number);
            arraytofill[num-1]=number;
        }
        if(pos==27|pos==28|pos==29|pos==36|pos==37|pos==38|pos==45|pos==46|pos==47){
            String[] arraytofill =box4;
            int num = Integer.parseInt(number);
            arraytofill[num-1]=number;
        }
        if(pos==30|pos==31|pos==32|pos==39|pos==40|pos==41|pos==48|pos==49|pos==50){
            String[] arraytofill =box5;
            int num = Integer.parseInt(number);
            arraytofill[num-1]=number;
        }
        if(pos==33|pos==34|pos==35|pos==42|pos==43|pos==44|pos==51|pos==52|pos==53){
            String[] arraytofill =box6;
            int num = Integer.parseInt(number);
            arraytofill[num-1]=number;
        }
        if(pos==54|pos==55|pos==56|pos==63|pos==64|pos==65|pos==72|pos==73|pos==74){
            String[] arraytofill =box7;
            int num = Integer.parseInt(number);
            arraytofill[num-1]=number;
        }
        if(pos==57|pos==58|pos==59|pos==66|pos==67|pos==68|pos==75|pos==76|pos==77){
            String[] arraytofill =box8;
            int num = Integer.parseInt(number);
            arraytofill[num-1]=number;
        }
        if(pos==60|pos==61|pos==62|pos==69|pos==70|pos==71|pos==78|pos==79|pos==80){
            String[] arraytofill =box9;
            int num = Integer.parseInt(number);
            arraytofill[num-1]=number;
        }

    }

    public static void checkEachBox(){
        //
    }

    public static boolean isGameOver(){
        boolean over = true;
        for(int i=0;i<boardPieces.length;i++){
            if(boardPieces[i].equals(".")){
                over=false;
                break;
            }
        }
        return over;
    }

    public static int getPosition(int row, int column){
        return (9*(row-1))+(column-1);
    }

    public static int[] getCoordinates( int position){
        int[] coordinates = new int[2];
        coordinates[0]=(position/9)+1;
        coordinates[1]=(position%9)+1;
        return coordinates;
    }


//    public static void checkRow(int position){
//
//        for(int i =0;i<boardArrays.size();i++){
//            String[] chosenBox = boardArrays.get(i);
//
//
//        }
//    }


    public static void checkColumn(){

    }




    



}
