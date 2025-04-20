import java.util.Scanner;
import java.util.Random;

class TicTacToeAIVsHuman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean playagain = true;
        HumanPlayer player1 = new HumanPlayer("Ansh", 'X');
        int player1score = 0;
        int player2score = 0;
        AIPlayer player2 = new AIPlayer("AI", 'O');
        Player cp;
        while (playagain) {
            TicTacToe obj = new TicTacToe();
            cp = player1;
            while (true) {
                System.out.println(cp.name + " turn: ");
                cp.makeMove();
                TicTacToe.displayBoard();
                if (obj.checkColWin() || obj.checkRowWin() || obj.checkDiagWin()) {
                    System.out.println(cp.name + " has Won. ");
                    if (cp == player1) {
                        player1score++;
                    } else {
                        player2score++;
                    }
                    break;
                } else if (obj.checkDraw()) {
                    System.out.println("Game is a draw");
                    break;
                } else {
                    if (cp == player1) {
                        cp = player2;
                    } else {
                        cp = player1;
                    }
                }
            }
            System.out.println("\n--- Scoreboard ---");
            System.out.println(player1.name + ": " + player1score);
            System.out.println(player2.name + ": " + player2score);
            System.out.print("\nDo you want to play again? (y/n): ");
            String response = sc.next();
            if (!response.equalsIgnoreCase("y")) {
                playagain = false;
                System.out.println("Thanks for playing!");
            }
        }
        sc.close();

    }
}

class TicTacToe {
    static char[][] board;

    public TicTacToe() {
        board = new char[3][3];
        initBoard();
    }

    void initBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    static void displayBoard() {
        System.out.println("-------------");
        for (int i = 0; i < board.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    static void placeMark(int row, int col, char mark) {
        if (row >= 0 && row < board.length && col >= 0 && col < board[0].length) {
            board[row][col] = mark;
        } else {
            System.out.println("Invalid Position");
        }
    }

    boolean checkColWin() {
        for (int j = 0; j <= 2; j++) {
            if (board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return true;
            }
        }
        return false;
    }

    boolean checkRowWin() {
        for (int i = 0; i <= 2; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        return false;
    }

    boolean checkDiagWin() {
        if ((board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
                (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0])) {
            return true;
        }
        return false;
    }

    boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}

abstract class Player {
    String name;
    char mark;

    abstract void makeMove();

    boolean isValid(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            if (TicTacToe.board[row][col] == ' ') {
                return true;
            }
        }
        return false;
    }

}

class HumanPlayer extends Player {
    Scanner scan = new Scanner(System.in);

    public HumanPlayer(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    void makeMove() {
        int row = -1;
        int col = -1;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Enter the row and col: ");
                row = scan.nextInt();
                col = scan.nextInt();
                if (isValid(row, col)) {
                    validInput = true;
                } else {
                    System.out.println("Invalid move. Cell already filled or out of bounds. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter valid integers for row and column.");
                scan.nextLine();
            }
        }
        TicTacToe.placeMark(row, col, mark);
    }

}

class AIPlayer extends Player {
    public AIPlayer(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    void makeMove() {
        int row = -1, col = -1;
        boolean validInput = false;
        System.out.println("AI is making a move...");
        Random r = new Random();
        while (!validInput) {
            try {
                row = r.nextInt(3);
                col = r.nextInt(3);

                if (isValid(row, col)) {
                    validInput = true;
                }

            } catch (Exception e) {
                System.out.println("Error while generating move: " + e.getMessage());
            }
        }
        System.out.println("AI chose: " + row + " " + col);
        TicTacToe.placeMark(row, col, mark);
    }
}
