import java.util.Scanner;

public class Start {

    public static void startGame() {

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the game of Tic-Tac-Toe!!");
        char symbol = GUI.CROSS;
        int dim = 3;
        boolean finished = false;
        char[][] board = GUI.initialiseBoardSize(dim);
        boolean allowed = false;

        while (!finished) {
            GUI.displayBoard(board, dim);
            System.out.println("Its " + symbol + " turn, please type your desired coordinate: ");
            String coordinate = scan.next();

            allowed = GUI.updateBoard(board, coordinate, symbol);
            if (!allowed) {
                System.out.println("The coordinate is occupied");
            }
            finished = GUI.isWin(board, symbol, dim);
            if (finished) {
                GUI.displayBoard(board, dim);
                System.out.println(symbol + " WON!!");
            }

            finished = GUI.isTie(board, dim);
            if (finished) {
                GUI.displayBoard(board, dim);
                System.out.println("It's a TIE!!");
            }
            symbol = (symbol == GUI.CROSS) ? GUI.CIRCLE : GUI.CROSS;
        }
    }
}
