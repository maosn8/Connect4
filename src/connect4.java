import java.util.*;
public class connect4 {
    public static void main(String[] args) {
        boolean win = false;
        int count = 0;
        char[][] gameBoard = new char[6][7];
        int[] countRow = new int[7];
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Connect 4®! Which player will be starting: R or Y?");
        char startingColor = input.next().charAt(0);
        startingColor = Character.toUpperCase(startingColor);
        for(int i = 0; i < gameBoard.length; i++){
            for(int j = 0; j < gameBoard[i].length; j++){
                gameBoard[i][j] = ' ';
            }
        }
        for(int i = 0; i < countRow.length; i++){
            countRow[i] = 5;
        }
        while(!win){
            playGame(startingColor,input,gameBoard,countRow);
            count++;
            if (count >= 4){
                System.out.println("Is there a winner?");
                String winStr = input.next().toLowerCase();
                if (winStr.equals("yes") || winStr.equals("y")){
                    win = true;
                }
            }
        }
        System.out.println("Which color won?");
        System.out.println("Congrats " + input.next().toUpperCase() + "! You have won!!");
    }
    public static void displayBoard(char[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.print("|" + arr[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("---------------");
    }
    public static void playGame(char color, Scanner input, char[][] arr, int[] row){
        char color1;
        if (color == 'R') {
            color1 = 'Y';
        }else{
            color1 = 'R';
        }
        System.out.println("Which colum, 1-7, would " + color + " like to drop their chip at?");
        int colum = input.nextInt() - 1;
        arr[row[colum]][colum] = color;
        row[colum]--;
        displayBoard(arr);
        System.out.println("Which colum, 1-7, would " + color1 + " like to drop their chip at?");
        colum = input.nextInt() - 1;
        arr[row[colum]][colum] = color1;
        row[colum]--;
        displayBoard(arr);
    }
}
