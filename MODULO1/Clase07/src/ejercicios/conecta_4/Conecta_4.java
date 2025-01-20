package ejercicios.conecta_4;

import java.util.Scanner;

public class Conecta_4 {

    public static void startGame() {
        var request = new Scanner(System.in);

        char currentPlayer = 'X';
        boolean gameOver = false;
        char[][] board = initializeBoard();
        
        while (!gameOver) {
            displayBoard(board);
            int column = getPlayerMove(request, currentPlayer);

            boolean moveMade = makeMove(board, column, currentPlayer);
            if (moveMade) {
                if (checkWinner(board, currentPlayer)) {
                    displayBoard(board);
                    System.out.printf("¡Jugador %c gana!%n", currentPlayer);
                    gameOver = true;
                } else if (isBoardFull(board)) {
                    displayBoard(board);
                    System.out.println("¡El juego terminó en empate!");
                    gameOver = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Movimiento inválido. Intenta nuevamente.");
            }
        }

        System.out.println("Gracias por jugar Conecta 4.");
        request.close();
    }

    private static char[][] initializeBoard() {
        char[][] board = new char[6][7];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = ' ';
            }
        }
        return board;
    }

    private static void displayBoard(char[][] board) {
        System.out.println("\n-----------------------------");
        for (int i = 0; i < 6; i++) {
            System.out.print("| ");
            for (int j = 0; j < 7; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-----------------------------");
        }
    }

    private static int getPlayerMove(Scanner request, char player) {
        int column;
        while (true) {
            System.out.printf("Jugador %c, elige una columna (1-7): ", player);
            column = request.nextInt() - 1;  

            if (column >= 0 && column < 7) {
                break;
            } else {
                System.out.println("Columna inválida. Ingresa un número entre 1 y 7.");
            }
        }
        return column;
    }

    private static boolean makeMove(char[][] board, int column, char player) {
        for (int row = 5; row >= 0; row--) { 
            if (board[row][column] == ' ') {
                board[row][column] = player;
                return true;
            }
        }
        return false;  
    }

    private static boolean checkWinner(char[][] board, char player) {

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                if (board[row][col] == player) {

                    if (col + 3 < 7 && board[row][col + 1] == player && board[row][col + 2] == player && board[row][col + 3] == player) {
                        return true;
                    }

                    if (row + 3 < 6 && board[row + 1][col] == player && board[row + 2][col] == player && board[row + 3][col] == player) {
                        return true;
                    }

                    if (row + 3 < 6 && col + 3 < 7 && board[row + 1][col + 1] == player && board[row + 2][col + 2] == player && board[row + 3][col + 3] == player) {
                        return true;
                    }

                    if (row - 3 >= 0 && col + 3 < 7 && board[row - 1][col + 1] == player && board[row - 2][col + 2] == player && board[row - 3][col + 3] == player) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    private static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}