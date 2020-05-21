import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.fill;

public class SudokuUtils {
    public static int dim =9;
    //public static String[] boardPieces = new String[81];
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
    //public static String[][] eachBoxArray = new String[81][9];
    public static String[] boardPieces = new String[]{"6",".",".","1",".","8","2",".","3",".","2",".",".","4",".",".","9",".","8",".","3",".",".","5","4",".",".","5",".","4","6",".","7",".",".","9",".","3",".",".",".",".",".","5",".","7",".",".","8",".","3","1",".","2",".",".","1","7",".",".","9",".","6",".","8",".",".","3",".",".","2",".","3",".","2","9",".","4",".",".","5"};


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
        outerloop:
        for(int i=0;i<boardPieces.length;i++){
            if(boardPieces[i].equals(".")){
                int[] coordinates = getCoordinates(i);
                String[] rowArray= rowArrays[coordinates[0]-1];
                String[] colArray= colArrays[coordinates[1]-1];
                String[] boxArrays =checkBoxes(i);
                ArrayList<String> boxList = new ArrayList<>();
                ArrayList<String> possibleChoices = new ArrayList<>();
                for(int j=1;j<10;j++){
                    assert boxArrays != null;
                    if(rowArray[j-1].equals(".") && colArray[j-1].equals(".") && boxArrays[j-1].equals(".")){
                        if(!checkOtherBoxes(j, rowArray, colArray, i)){
                            //add to every single list then if only 1 in the list, choose that number
                            //check each box in that row if the number can be used there
                            // check each box in that column if the number can be used there
                            if(!checkRows(i,coordinates[1],j) && !checkColumns(i,coordinates[0],j)){
                                boardPieces[i] = String.valueOf(j);
                                //possibleChoices.add(String.valueOf(j));
                                SudokuUI.displayBoard(boardPieces);
                                break outerloop;
                            }


                        }
                    }
                }

            }


        }
    }

    public static boolean checkRows(int boxPosition, int column,int numbBeingChecked){

        if(column == 1 || column == 4 || column == 7){
            int nextInt1 = boxPosition+1;
            int nextInt2 = boxPosition + 2;
            int[] coordinates1 = getCoordinates(nextInt1);
            int[] coordinates2 = getCoordinates(nextInt2);
            String[] rowArray1= rowArrays[coordinates1[0]-1];
            String[] colArray1= colArrays[coordinates1[1]-1];
            String[] rowArray2= rowArrays[coordinates2[0]-1];
            String[] colArray2= colArrays[coordinates2[1]-1];
            if(boardPieces[nextInt1].equals(".")){
                if(rowArray1[numbBeingChecked-1].equals(".") && colArray1[numbBeingChecked-1].equals(".")){
                    return true;
                }
            }
            if(boardPieces[nextInt2].equals(".")){
                if(rowArray2[numbBeingChecked-1].equals(".") && colArray2[numbBeingChecked-1].equals(".")){
                    return true;
                }
            }


        }
        if(column==2 || column==5 || column==8){
            int nextInt1 = boxPosition-1;
            int nextInt2 = boxPosition +1;
            int[] coordinates1 = getCoordinates(nextInt1);
            int[] coordinates2 = getCoordinates(nextInt2);
            String[] rowArray1= rowArrays[coordinates1[0]-1];
            String[] colArray1= colArrays[coordinates1[1]-1];
            String[] rowArray2= rowArrays[coordinates2[0]-1];
            String[] colArray2= colArrays[coordinates2[1]-1];
            if(boardPieces[nextInt1].equals(".")){
                if(rowArray1[numbBeingChecked-1].equals(".") && colArray1[numbBeingChecked-1].equals(".")){
                    return true;
                }
            }
            if(boardPieces[nextInt2].equals(".")){
                if(rowArray2[numbBeingChecked-1].equals(".") && colArray2[numbBeingChecked-1].equals(".")){
                    return true;
                }
            }
        }
        if(column==3 || column==6||column==9){
            int nextInt1 = boxPosition-1;
            int nextInt2 = boxPosition - 2;
            int[] coordinates1 = getCoordinates(nextInt1);
            int[] coordinates2 = getCoordinates(nextInt2);
            String[] rowArray1= rowArrays[coordinates1[0]-1];
            String[] colArray1= colArrays[coordinates1[1]-1];
            String[] rowArray2= rowArrays[coordinates2[0]-1];
            String[] colArray2= colArrays[coordinates2[1]-1];
            if(boardPieces[nextInt1].equals(".")){
                if(rowArray1[numbBeingChecked-1].equals(".") && colArray1[numbBeingChecked-1].equals(".")){
                    return true;
                }
            }
            if(boardPieces[nextInt2].equals(".")){
                if(rowArray2[numbBeingChecked-1].equals(".") && colArray2[numbBeingChecked-1].equals(".")){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean checkColumns(int boxPosition, int row,int numbBeingChecked){
        if(row == 1 || row == 4 || row == 7){
            int nextInt1 = boxPosition+9;
            int nextInt2 = boxPosition + 18;
            int[] coordinates1 = getCoordinates(nextInt1);
            int[] coordinates2 = getCoordinates(nextInt2);
            String[] rowArray1= rowArrays[coordinates1[0]-1];
            String[] colArray1= colArrays[coordinates1[1]-1];
            String[] rowArray2= rowArrays[coordinates2[0]-1];
            String[] colArray2= colArrays[coordinates2[1]-1];
            if(boardPieces[nextInt1].equals(".")){
                if(rowArray1[numbBeingChecked-1].equals(".") && colArray1[numbBeingChecked-1].equals(".")){
                    return true;
                }
            }
            if(boardPieces[nextInt2].equals(".")){
                if(rowArray2[numbBeingChecked-1].equals(".") && colArray2[numbBeingChecked-1].equals(".")){
                    return true;
                }
            }
        }
        if(row==2 || row==5 || row==8){
            int nextInt1 = boxPosition-9;
            int nextInt2 = boxPosition +9;
            int[] coordinates1 = getCoordinates(nextInt1);
            int[] coordinates2 = getCoordinates(nextInt2);
            String[] rowArray1= rowArrays[coordinates1[0]-1];
            String[] colArray1= colArrays[coordinates1[1]-1];
            String[] rowArray2= rowArrays[coordinates2[0]-1];
            String[] colArray2= colArrays[coordinates2[1]-1];
            if(boardPieces[nextInt1].equals(".")){
                if(rowArray1[numbBeingChecked-1].equals(".") && colArray1[numbBeingChecked-1].equals(".")){
                    return true;
                }
            }
            if(boardPieces[nextInt2].equals(".")){
                if(rowArray2[numbBeingChecked-1].equals(".") && colArray2[numbBeingChecked-1].equals(".")){
                    return true;
                }
            }
        }
        if(row==3 ||row==6||row==9){
            int nextInt1 = boxPosition-9;
            int nextInt2 = boxPosition - 18;
            int[] coordinates1 = getCoordinates(nextInt1);
            int[] coordinates2 = getCoordinates(nextInt2);
            String[] rowArray1= rowArrays[coordinates1[0]-1];
            String[] colArray1= colArrays[coordinates1[1]-1];
            String[] rowArray2= rowArrays[coordinates2[0]-1];
            String[] colArray2= colArrays[coordinates2[1]-1];
            if(boardPieces[nextInt1].equals(".")){
                if(rowArray1[numbBeingChecked-1].equals(".") && colArray1[numbBeingChecked-1].equals(".")){
                    return true;
                }
            }
            if(boardPieces[nextInt2].equals(".")){
                if(rowArray2[numbBeingChecked-1].equals(".") && colArray2[numbBeingChecked-1].equals(".")){
                    return true;
                }
            }
        }
        return false;
    }

    public static Boolean checkOtherBoxes(int numberBeingChecked,String[] rowArrays,String[] colArrays,int Boxposition){
        if(Boxposition ==0|| Boxposition ==1|| Boxposition ==2|| Boxposition ==9|| Boxposition ==10|| Boxposition ==11|| Boxposition ==18|| Boxposition ==19|| Boxposition ==20){

            for(int l=0;l<3;l++){
                if(l!= Boxposition && boardPieces[l].equals(".")){
                    if(!rowArrays[numberBeingChecked - 1].equals(".") || !colArrays[numberBeingChecked - 1].equals(".")|| !box1[numberBeingChecked - 1].equals(".")){
                        return true;

                    }
                }
            }
            for(int l=9;l<12;l++){
                if(l!= Boxposition && boardPieces[l].equals(".")){
                    if(!rowArrays[numberBeingChecked - 1].equals(".") || !colArrays[numberBeingChecked - 1].equals(".")|| !box1[numberBeingChecked - 1].equals(".")){
                        return true;

                    }
                }
            }
            for(int l=18;l<21;l++){
                if(l!= Boxposition && boardPieces[l].equals(".")){
                    if(!rowArrays[numberBeingChecked - 1].equals(".") || !colArrays[numberBeingChecked - 1].equals(".")|| !box1[numberBeingChecked - 1].equals(".")){
                        return true;

                    }

                }
            }




        }
        else if(Boxposition ==3|| Boxposition ==4|| Boxposition ==5|| Boxposition ==12|| Boxposition ==13|| Boxposition ==14|| Boxposition ==21|| Boxposition ==22|| Boxposition ==23){

            for(int l=3;l<6;l++){
                if(l!= Boxposition && boardPieces[l].equals(".")){
                    if(!rowArrays[numberBeingChecked - 1].equals(".") || !colArrays[numberBeingChecked - 1].equals(".")|| !box2[numberBeingChecked - 1].equals(".")){
                        return true;

                    }
                }
            }
            for(int l=12;l<15;l++){
                if(l!= Boxposition && boardPieces[l].equals(".")){
                    if(!rowArrays[numberBeingChecked - 1].equals(".") || !colArrays[numberBeingChecked - 1].equals(".")|| !box2[numberBeingChecked - 1].equals(".")){
                        return true;

                    }
                }
            }
            for(int l=21;l<24;l++){
                if(l!= Boxposition && boardPieces[l].equals(".")){
                    if(!rowArrays[numberBeingChecked - 1].equals(".") || !colArrays[numberBeingChecked - 1].equals(".")|| !box2[numberBeingChecked - 1].equals(".")){
                        return true;

                    }


                }
            }



        }
        else if(Boxposition ==6|| Boxposition ==7|| Boxposition ==8|| Boxposition ==15|| Boxposition ==16|| Boxposition ==17|| Boxposition ==24|| Boxposition ==25|| Boxposition ==26){

            for(int l=6;l<9;l++){
                if(l!= Boxposition && boardPieces[l].equals(".")){
                    if(!rowArrays[numberBeingChecked - 1].equals(".") || !colArrays[numberBeingChecked - 1].equals(".")|| !box3[numberBeingChecked - 1].equals(".")){
                        return true;

                    }
                }
            }
            for(int l=15;l<18;l++){
                if(l!= Boxposition && boardPieces[l].equals(".")){
                    if(!rowArrays[numberBeingChecked - 1].equals(".") || !colArrays[numberBeingChecked - 1].equals(".")|| !box3[numberBeingChecked - 1].equals(".")){
                        return true;

                    }
                }
            }
            for(int l=24;l<27;l++){
                if(l!= Boxposition && boardPieces[l].equals(".")){
                    if(!rowArrays[numberBeingChecked - 1].equals(".") || !colArrays[numberBeingChecked - 1].equals(".")|| !box3[numberBeingChecked - 1].equals(".")){
                        return true;

                    }


                }
            }



        }
        else if(Boxposition ==27|| Boxposition ==28|| Boxposition ==29|| Boxposition ==36|| Boxposition ==37|| Boxposition ==38|| Boxposition ==45|| Boxposition ==46|| Boxposition ==47){

            for(int l=27;l<30;l++){
                if(l!= Boxposition && boardPieces[l].equals(".")){
                    if(!rowArrays[numberBeingChecked - 1].equals(".") || !colArrays[numberBeingChecked - 1].equals(".")|| !box4[numberBeingChecked - 1].equals(".")){
                        return true;

                    }
                }
            }
            for(int l=36;l<39;l++){
                if(l!= Boxposition && boardPieces[l].equals(".")){
                    if(!rowArrays[numberBeingChecked - 1].equals(".") || !colArrays[numberBeingChecked - 1].equals(".")|| !box4[numberBeingChecked - 1].equals(".")){
                        return true;

                    }
                }
            }
            for(int l=45;l<48;l++){
                if(l!= Boxposition && boardPieces[l].equals(".")){
                    if(!rowArrays[numberBeingChecked - 1].equals(".") || !colArrays[numberBeingChecked - 1].equals(".")|| !box4[numberBeingChecked - 1].equals(".")){
                        return true;

                    }


                }
            }



        }
        else if(Boxposition ==30|| Boxposition ==31|| Boxposition ==32|| Boxposition ==39|| Boxposition ==40|| Boxposition ==41|| Boxposition ==48|| Boxposition ==49|| Boxposition ==50){

            for(int l=30;l<33;l++){
                if(l!= Boxposition && boardPieces[l].equals(".")){
                    if(!rowArrays[numberBeingChecked - 1].equals(".") || !colArrays[numberBeingChecked - 1].equals(".")|| !box5[numberBeingChecked - 1].equals(".")){
                        return true;

                    }
                }
            }
            for(int l=39;l<42;l++){
                if(l!= Boxposition && boardPieces[l].equals(".")){
                    if(!rowArrays[numberBeingChecked - 1].equals(".") || !colArrays[numberBeingChecked - 1].equals(".")|| !box5[numberBeingChecked - 1].equals(".")){
                        return true;

                    }
                }
            }
            for(int l=48;l<51;l++){
                if(l!= Boxposition && boardPieces[l].equals(".")){
                    if(!rowArrays[numberBeingChecked - 1].equals(".") || !colArrays[numberBeingChecked - 1].equals(".")|| !box5[numberBeingChecked - 1].equals(".")){
                        return true;

                    }


                }
            }


        }
        else if(Boxposition ==33|| Boxposition ==34|| Boxposition ==35|| Boxposition ==42|| Boxposition ==43|| Boxposition ==44|| Boxposition ==51| Boxposition ==52|| Boxposition ==53){

            for(int l=33;l<36;l++){
                if(l!= Boxposition && boardPieces[l].equals(".")){
                    if(!rowArrays[numberBeingChecked - 1].equals(".") || !colArrays[numberBeingChecked - 1].equals(".")|| !box6[numberBeingChecked - 1].equals(".")){
                        return true;

                    }
                }
            }
            for(int l=42;l<45;l++){
                if(l!= Boxposition && boardPieces[l].equals(".")){
                    if(!rowArrays[numberBeingChecked - 1].equals(".") || !colArrays[numberBeingChecked - 1].equals(".")|| !box6[numberBeingChecked - 1].equals(".")){
                        return true;

                    }
                }
            }
            for(int l=51;l<54;l++){
                if(l!= Boxposition && boardPieces[l].equals(".")){
                    if(!rowArrays[numberBeingChecked - 1].equals(".") || !colArrays[numberBeingChecked - 1].equals(".")|| !box6[numberBeingChecked - 1].equals(".")){
                        return true;

                    }


                }
            }

        }
        else if(Boxposition ==54|| Boxposition ==55|| Boxposition ==56|| Boxposition ==63|| Boxposition ==64|| Boxposition ==65|| Boxposition ==72|| Boxposition ==73|| Boxposition ==74){

            for(int l=54;l<57;l++){
                if(l!= Boxposition && boardPieces[l].equals(".")){
                    if(!rowArrays[numberBeingChecked - 1].equals(".") || !colArrays[numberBeingChecked - 1].equals(".")|| !box7[numberBeingChecked - 1].equals(".")){
                        return true;

                    }
                }
            }
            for(int l=63;l<66;l++){
                if(l!= Boxposition && boardPieces[l].equals(".")){
                    if(!rowArrays[numberBeingChecked - 1].equals(".") || !colArrays[numberBeingChecked - 1].equals(".")|| !box7[numberBeingChecked - 1].equals(".")){
                        return true;

                    }
                }
            }
            for(int l=75;l<78;l++){
                if(l!= Boxposition && boardPieces[l].equals(".")){
                    if(!rowArrays[numberBeingChecked - 1].equals(".") || !colArrays[numberBeingChecked - 1].equals(".")|| !box7[numberBeingChecked - 1].equals(".")){
                        return true;

                    }


                }
            }

        }
        else if(Boxposition ==57|| Boxposition ==58|| Boxposition ==59|| Boxposition ==66|| Boxposition ==67|| Boxposition ==68|| Boxposition ==75|| Boxposition ==76|| Boxposition ==77){

            for(int l=57;l<60;l++){
                if(l!= Boxposition && boardPieces[l].equals(".")){
                    if(!rowArrays[numberBeingChecked - 1].equals(".") || !colArrays[numberBeingChecked - 1].equals(".")|| !box8[numberBeingChecked - 1].equals(".")){
                        return true;

                    }
                }
            }
            for(int l=66;l<69;l++){
                if(l!= Boxposition && boardPieces[l].equals(".")){
                    if(!rowArrays[numberBeingChecked - 1].equals(".") || !colArrays[numberBeingChecked - 1].equals(".")|| !box8[numberBeingChecked - 1].equals(".")){
                        return true;

                    }
                }
            }
            for(int l=75;l<78;l++){
                if(l!= Boxposition && boardPieces[l].equals(".")){
                    if(!rowArrays[numberBeingChecked - 1].equals(".") || !colArrays[numberBeingChecked - 1].equals(".")|| !box8[numberBeingChecked - 1].equals(".")){
                        return true;

                    }


                }
            }


        }
        else if(Boxposition ==60|| Boxposition ==61|| Boxposition ==62|| Boxposition ==69|| Boxposition ==70|| Boxposition ==71|| Boxposition ==78|| Boxposition ==79|| Boxposition ==80){

            for(int l=60;l<63;l++){
                if(l!= Boxposition && boardPieces[l].equals(".")){
                    if(!rowArrays[numberBeingChecked - 1].equals(".") || !colArrays[numberBeingChecked - 1].equals(".")|| !box9[numberBeingChecked - 1].equals(".")){
                        return true;

                    }

                }
            }
            for(int l=69;l<72;l++){
                if(l!= Boxposition && boardPieces[l].equals(".")){
                    if(!rowArrays[numberBeingChecked - 1].equals(".") || !colArrays[numberBeingChecked - 1].equals(".")|| !box9[numberBeingChecked - 1].equals(".")){
                        return true;

                    }

                }
            }
            for(int l=78;l<81;l++){
                if(l!= Boxposition && boardPieces[l].equals(".")){
                    if(!rowArrays[numberBeingChecked - 1].equals(".") || !colArrays[numberBeingChecked - 1].equals(".")|| !box9[numberBeingChecked - 1].equals(".")){
                        return true;

                    }



                }
            }


        }
        return false;

    }


    private static String[] checkBoxes(int i) {

        if(i ==0|| i ==1|| i ==2|| i ==9|| i ==10|| i ==11|| i ==18|| i ==19|| i ==20){
            //check box array
            return box1;
        }
        if(i ==3|| i ==4|| i ==5|| i ==12|| i ==13|| i ==14|| i ==21|| i ==22|| i ==23){
           return box2;
        }
        if(i ==6|| i ==7|| i ==8|| i ==15|| i ==16|| i ==17|| i ==24|| i ==25|| i ==26){
          return box3;
        }
        if(i ==27|| i ==28|| i ==29|| i ==36|| i ==37|| i ==38|| i ==45|| i ==46|| i ==47){
            return box4;
        }
        if(i ==30|| i ==31|| i ==32|| i ==39|| i ==40|| i ==41|| i ==48|| i ==49|| i ==50){
            return box5;
        }
        if(i ==33|| i ==34|| i ==35|| i ==42|| i ==43|| i ==44|| i ==51| i ==52|| i ==53){
            return box6;
        }
        if(i ==54|| i ==55|| i ==56|| i ==63|| i ==64|| i ==65|| i ==72|| i ==73|| i ==74){
            return box7;
        }
        if(i ==57|| i ==58|| i ==59|| i ==66|| i ==67|| i ==68|| i ==75|| i ==76|| i ==77){
            return box8;
        }
        if(i ==60|| i ==61|| i ==62|| i ==69|| i ==70|| i ==71|| i ==78|| i ==79|| i ==80){
            return box9;
        }
        return null;

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


//    public static void checkColumn(){
//        ArrayList<Integer> boxList = checkBoxes(i);
//        ArrayList<Integer> rowList = new ArrayList<>();
//        ArrayList<Integer> colList = new ArrayList<>();
//        for(int j=0;j<rowArray.length;j++){
//            if(rowArray[j].equals(".")){
//                rowList.add(j+1);
//            }
//        }
//        for(int k=0;k<colArray.length;k++){
//            if(rowArray[k].equals(".")){
//                colList.add(k+1);
//            }
//        }
//        if(boxList.size()==1 & colList.size()!=1 & rowList.size()!=1){
//            boardPieces[i]= String.valueOf(boxList.get(0));
//        }
//        if(boxList.size()!=1 & colList.size()==1 & rowList.size()!=1){
//            boardPieces[i] = String.valueOf(colList.get(0));
//        }
//        if(boxList.size()!=1 & colList.size()!=1 & rowList.size()==1){
//            boardPieces[i] = String.valueOf(rowList.get(0));
//        }
//        if(boxList.size()==1 && colList.size()==1 & rowList.size()!=1){
//            if(boxList.get(0).equals(colList.get(0))){
//                boardPieces[i]= String.valueOf(boxList.get(0));
//            }
//        }
//        if(boxList.size()==1 && colList.size()!=1 & rowList.size()==1){
//            if(boxList.get(0).equals(rowList.get(0))){
//                boardPieces[i]= String.valueOf(boxList.get(0));
//            }
//        }
//        if(boxList.size()!=1 && colList.size()==1 & rowList.size()==1){
//            if(rowList.get(0).equals(colList.get(0))){
//                boardPieces[i]= String.valueOf(rowList.get(0));
//            }
//        }
//        if(boxList.size()==1 && colList.size()==1 & rowList.size()==1){
//            if(boxList.get(0).equals(colList.get(0)) & boxList.get(0).equals(rowList.get(0))){
//                boardPieces[i]= String.valueOf(boxList.get(0));
//            }
//        }
//
//    }




    



}
