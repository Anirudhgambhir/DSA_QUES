package practise;

public class FindWinnerOnATicTacToeGame {

    private final int[][] ticTacToeBoard = new int[3][3];

    public String tictactoe(int[][] moves) {
        boolean canGameBePending = moves.length < 9;
        for (int i = 0; i < moves.length; i++) {
            int[] move = moves[i];
            if (i % 2 == 0) { // A's move
                ticTacToeBoard[move[0]][move[1]] = 1;
            } else { // B's move
                ticTacToeBoard[move[0]][move[1]] = -1;
            }
            if (validateIfPlayerHasWon(i % 2 == 0 ? 1 : -1)) {
                return i % 2 == 0 ? "A" : "B";
            }
        }
        return canGameBePending ? "Pending" : "Draw";
    }

    private boolean validateIfPlayerHasWon(int playerKey) {
        // Check for Diagonals
        if (ticTacToeBoard[0][0] + ticTacToeBoard[1][1] + ticTacToeBoard[2][2] == playerKey * 3 ||
                ticTacToeBoard[0][2] + ticTacToeBoard[1][1] + ticTacToeBoard[2][0] == playerKey * 3) {
            return true;
        }

        // Check for Rows and Columns
        for (int i = 0; i < 3; i++) {
            if (ticTacToeBoard[i][0] + ticTacToeBoard[i][1] + ticTacToeBoard[i][2] == playerKey * 3 ||
                    ticTacToeBoard[0][i] + ticTacToeBoard[1][i] + ticTacToeBoard[2][i] == playerKey * 3 )
            {
                return true;
            }
        }
        return false;
    }
}
