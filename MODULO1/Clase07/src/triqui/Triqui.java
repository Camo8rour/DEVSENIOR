package triqui;

import java.util.Scanner;

public class Triqui {

    public static void startGame() {
        /*1. Identificar los jugadores X y O.
        2. Inicializar y mostrar el tablero.
        3. Leer el movimiento del jugador.
        4. Verificar si hixo tres en linea.
        Si lo hizo, diga gano.
            Sino
            Cambia de jugador
            Volver al paso 3.*/
        var sc = new Scanner(System.in);

        var player = 'X';
        var counter = 0;
        var isFinish = false;
        var board = inicializeBoard();

        do {
            showBoard(board);

            System.out.printf("Jugador %c ingresa tu movimiento: %n", player);
            System.out.println("Fila (1-3): ");
            var row = sc.nextInt() - 1;
            System.out.println("Columna (1-3): ");
            var column = sc.nextInt() - 1;

            if (makeMove(board, row, column, player)) {
                counter++;

                if (checkWinner(board, player)) {
                    showBoard(board);
                    System.out.printf("El jugador %c ha ganado.", player);

                    isFinish = true;
                } else {
                    player = player == 'X' ? 'O' : 'X';
                }

            } else {
                System.err.println("Movimiento invalido.Intenta de nuevo");
            }

            if (counter == 9) {
                System.out.println("Han quedado empatados.");
                isFinish = true;
            }

        } while (!isFinish);

        sc.close();
    }

    private static boolean checkWinner(char[][] board, char player) {
        for (var row : board) {
            if (row[0] == player && row[1] == player && row[2] == player) {
                return true;
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    private static boolean makeMove(char[][] board, int row, int column, char player) {
        if (board[row][column] != ' ') {
            return false;
        }
        board[row][column] = player;
        return true;
    }

    private static void showBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int u = 0; u < board[i].length; u++) {
                System.out.print(board[i][u]);
                if (u < board[i].length - 1) {
                    System.out.print('|');
                }
            }

            System.out.println();
            if (i < board.length - 1) {
                System.out.println("-----");
            }
        }
    }

    private static char[][] inicializeBoard() {
        var board = new char[3][3];

        for (int i = 0; i < board.length; i++) {
            for (int u = 0; u < board[i].length; u++) {
                board[i][u] = ' ';
            }
        }

        return board;
    }
}
