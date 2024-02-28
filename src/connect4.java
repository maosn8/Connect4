import java.util.*;
public class connect4 {
    public static void main(String[] args) {
        boolean win = false;
        int count = 0;
        char[][] gameBoard = new char[6][7];
        int[] countRow = new int[7];
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Connect 4®! Which player will be starting: R or Y?");
        char startingColor = Character.toUpperCase(input.next().charAt(0));
        // prompts to select which color starts
        for (char[] chars : gameBoard) {
            Arrays.fill(chars, ' ');
        }
        Arrays.fill(countRow, 5);
        // fills both arrays with their respective values
        displayBoard(gameBoard);
        // shows an initial board layout
        while(!win){ //runs until a win is stated
            playGame(startingColor,input,gameBoard,countRow);
            count++; // creates a count for at least for turns to be played (there cant be a game with less than 4 turns)
            if (count >= 4){
                System.out.println("Is there a winner?");
                String winStr = input.next().toLowerCase(); // prompts to ask for a win
                if (winStr.equals("yes") || winStr.equals("y")){
                    win = true;
                }
            }
        }
        System.out.println("Which color won?");
        System.out.println("Congrats " + input.next().toUpperCase() + "! You have won!!");
        // prompts for which color won and prints it out
    }
    public static void displayBoard(char[][] arr){ // displays the game board
        for (char[] chars : arr) {
            for (char aChar : chars) {
                System.out.print("|" + aChar);
            }
            System.out.println("|");
        }
        System.out.println("---------------");
    }
    public static void playGame(char color, Scanner input, char[][] arr, int[] row){
        char color1;
        if (color == 'R') { // part of what selects what color
            color1 = 'Y';
        }else{
            color1 = 'R';
        }
        System.out.println("Which colum, 1-7, would " + color + " like to drop their chip at?");
        int colum = input.nextInt() - 1; // prompts to select a column and stores it in a variable
        arr[row[colum]][colum] = color; // sets the value at the row and column that is specified
        row[colum]--; // the array for row index is decremented so the next call to that column is above the last
        displayBoard(arr); // displays the board
        System.out.println("Which colum, 1-7, would " + color1 + " like to drop their chip at?"); // repeats for the next color
        colum = input.nextInt() - 1;
        arr[row[colum]][colum] = color1;
        row[colum]--;
        displayBoard(arr);
    }
}
