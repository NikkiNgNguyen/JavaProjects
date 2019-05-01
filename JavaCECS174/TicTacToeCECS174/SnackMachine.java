
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author NikkiNguyen
 */
public class Lab9 {

    /**
     * @param args the command line arguments
     */
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        boolean turn = true;
        int move = 0;
        //change boolean to string
        //String turnString = String.valueOf(turn);
        //char[][] board = printBoard();

        char[][] board = {
            {'-', '0', '1', '2'},
            {'0', '_', '_', '_'},
            {'1', '_', '_', '_'},
            {'2', '_', '_', '_'},};

        turns(board, turn, move);

    }


    public static void bardockBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void turns(char[][] board, boolean turn, int move) {
        bardockBoard(board);

        while (true) {

            if (turn) {
                System.out.println("X's turn. Please enter a move (row and column).");
                //keep track of move under/equal to 9 for tie

                move++;
            } else {
                System.out.println("O's turn. Please enter a move (row and column).");
                move++;
            }

            int row, col;
            row = scan.nextInt();
            col = scan.nextInt();
            //char Player = board[row+1][col+1];
            //validate out of array
            while (row > 2 || col > 2 || row < 0 || col < 0) {
                System.out.println("Invalid move, spot not available!");
                row = scan.nextInt();
                col = scan.nextInt();
            }
            //validate if not empty
            while (board[row + 1][col + 1] == 'X' || board[row + 1][col + 1] == 'O') {
                System.out.println("Please input an open spot!");
                row = scan.nextInt();
                col = scan.nextInt();
            }

            //get input
            if (turn) {

                board[row + 1][col + 1] = 'X';
                bardockBoard(board);
            } else {

                board[row + 1][col + 1] = 'O';
                bardockBoard(board);

            }
            //check the module
            if (winnerWinnerChickenDinner(board)) {
                if (turn) {
                    System.out.println("Huzzah! Player X is the winner!");
                    break;

                } else {
                    System.out.println("Oh Shit! Player O is the winner! (Player X was garbage)");
                    break;
                }
            }
            if (move >= 5 && winnerWinnerChickenDinner(board)) {
                break;
            }
            if (move == 9 && winnerWinnerChickenDinner(board) != true) {
                System.out.println("Tie, might I suggest a jousting match.");

                break;

            }

            turn = !turn;
        }
    }

    // return true or false when checking winning triplets
    public static boolean winnerWinnerChickenDinner(char[][] board) {
        //diamonds in the sky
        if (board[1][1] == 'X' && board[1][1] == board[2][2] && board[2][2] == board[3][3]||
            board[1][3] == 'X' && board[1][3] == board[2][2] && board[2][2] == board[3][1]){
            return true;
        }
        // shine bright like a diamond
        if (board[1][1] == 'O' && board[1][1] == board[2][2] && board[2][2] == board[3][3]||
            board[1][3] == 'O' && board[1][3] == board[2][2] && board[2][2] == board[3][1]){
            return true;
        }
        // checks row win for X
        if (board[1][1] == 'X' && board[1][1] == board[1][2] && board[1][2] == board[1][3]||
                board[2][1] == 'X' && board[2][1] == board[2][2] && board[2][2] == board[2][3]||
                board[3][1] == 'X' && board[3][1] == board[3][2] && board[3][2] == board[3][3]||
                // check column wins
                board[1][1] == 'X' && board[1][1] == board[2][1] && board[2][1] == board[3][1]||
                board[1][2] == 'X' && board[1][2] == board[2][2] && board[2][2] == board[3][2]||
                board[1][3] == 'X' && board[1][3] == board[2][3] && board[2][3] == board[3][3]) {
            return true;
        }
        //check row win for O
        if (board[1][1] == 'O' && board[1][1] == board[1][2] && board[1][2] == board[1][3]||
                board[2][1] == 'O' && board[2][1] == board[2][2] && board[2][2] == board[2][3]||
                board[3][1] == 'O' && board[3][1] == board[3][2] && board[3][2] == board[3][3]||
                // check column wins
                board[1][1] == 'O' && board[1][1] == board[2][1] && board[2][1] == board[3][1]||
                board[1][2] == 'O' && board[1][2] == board[2][2] && board[2][2] == board[3][2]||
                board[1][3] == 'O' && board[1][3] == board[2][3] && board[2][3] == board[3][3]) {
            return true;
        }

        return false;
    }

}
