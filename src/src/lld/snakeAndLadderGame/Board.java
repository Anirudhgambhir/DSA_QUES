package lld.snakeAndLadderGame;

import lld.snakeAndLadderGame.model.Cell;
import lld.snakeAndLadderGame.model.JumpMove;

import java.util.List;

public class Board {
    private Cell[] board;

    public Board(List<JumpMove> snakesInTheGame, List<JumpMove> laddersInTheGame) {
        this.board = new Cell[100];
        generateBoard(this.board, snakesInTheGame, laddersInTheGame);
    }

    private void generateBoard(Cell[] board, List<JumpMove> snakesInTheGame, List<JumpMove> laddersInTheGame) {
        for (int i = 0; i < 100; i++) {
            board[i] = Cell.builder().build();
        }

        for (JumpMove snake : snakesInTheGame) {
            board[snake.getStartingPosition() - 1].setJumpMove(snake);
        }

        for (JumpMove ladder : laddersInTheGame) {
            board[ladder.getStartingPosition() - 1].setJumpMove(ladder);
        }
    }

    public Cell getCurrentCell(int position) {
        return board[position - 1];
    }
}
