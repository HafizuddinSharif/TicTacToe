import java.util.Objects;

public class GUI {

    public static final char CROSS = 'X';
    public static final char CIRCLE = 'O';
    public static final char EMPTY = ' ';

    public static void displayBoard(char[][] pieces, int dim) {
        Objects.requireNonNull(pieces, "Argument should not be a null");
        Objects.requireNonNull(dim, "Argument should not be a null");
        if (dim < 3 || dim % 2 == 0) {
            throw new IllegalArgumentException("Odd dimension only");
        }

        System.out.print("   ");

        for (int i = 0; i < dim; i++) {
            System.out.print("  " + (i+1) + "  ");
        }

        System.out.print("\n   ");

        for (int j = 0; j < dim; j++) {
            System.out.print("-----");
        }
        System.out.println();

        for (int i = 0; i < dim; i++) {
            System.out.print((i+1) + "  ");

            for (int j = 0; j < dim; j++) {
                if (pieces[i][j] == EMPTY) {
                    System.out.print("|   |");
                }
                else if (pieces[i][j] == CIRCLE) {
                    System.out.print("| O |");
                }
                else if (pieces[i][j] == CROSS) {
                    System.out.print("| X |");
                }
            }
            System.out.print("\n   ");

            for (int j = 0; j < dim; j++) {
                System.out.print("-----");
            }
            System.out.println();
        }
    }

    public static char[][] initialiseBoardSize(int dim) {
        char[][] pieces = new char[dim][dim];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                pieces[i][j] = EMPTY;
            }
        }
        return pieces;
    }

    public static boolean updateBoard(char[][] pieces, String coordinate, char symbol) {
        boolean allowed = false;
        int x = (int) coordinate.charAt(0) - 49;
        int y = (int) coordinate.charAt(1) - 49;

        if (pieces[x][y] == EMPTY) {
            pieces[x][y] = symbol;
            allowed = true;
        }

        return allowed;
    }

    public static boolean isWin(char[][] pieces, char symbol, int dim) {
        int count = 0;

        // horizontal
        for (int i = 0; i < dim; i++) {
            count = 0;
            for (int j = 0; j < dim; j++) {
                if (pieces[i][j] == symbol) {
                    count++;
                }
            }
            if (count == dim) {
                return true;
            }
        }

        // vertical
        for (int i = 0; i < dim; i++) {
            count = 0;
            for (int j = 0; j < dim; j++) {
                if (pieces[j][i] == symbol) {
                    count++;
                }
            }
            if (count == dim) {
                return true;
            }
        }

        // diagonal
        count = 0;
        for (int i = 0; i < dim; i++) {
            if (pieces[i][i] == symbol) {
                count++;
            }
        }
        if (count == dim) {
            return true;
        }

        count = 0;
        for (int i = 0; i < dim; i++) {
            if (pieces[i][dim-(i+1)] == symbol) {
                count++;
            }
        }
        if (count == dim) {
            return true;
        }
        return false;
    }

    public static boolean isTie(char[][] pieces, int dim) {
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (pieces[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static char[][] winPositions(int dim, char symbols) {
        char[][] positions = new char[dim][dim];
        return positions;
    }
}
