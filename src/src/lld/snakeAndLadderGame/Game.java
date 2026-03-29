package lld.snakeAndLadderGame;

import lld.snakeAndLadderGame.manager.DiceManager;
import lld.snakeAndLadderGame.model.Cell;
import lld.snakeAndLadderGame.model.JumpMove;
import lld.snakeAndLadderGame.model.Player;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Game {

    private Board board;
    private Deque<Player> players;
    private DiceManager diceManager;
    private Player winner;

    // Constructor
    Game(List<JumpMove> snakesPair, List<JumpMove> ladderPair, int playerCount) {
        this.board = new Board(snakesPair, ladderPair);
        this.players = new ArrayDeque<>();
        for (int i = 0; i < playerCount; i++) {
            players.offerLast(Player.builder().currentPosition(0).previousMoves(new ArrayList<>()).build());
        }
        this.diceManager = new DiceManager();
    }

   public void startGame() {
        while (winner == null) {
            Player currentPlayer = players.poll();
            int positionBeforeTurn = currentPlayer.getCurrentPosition();
            int consecutiveSixes = 0;

            while (true) {
                int roll = diceManager.rollDice();
                System.out.println("Player " + currentPlayer.getPlayerId() + " rolled a " + roll);

                if (roll == 6) {
                    consecutiveSixes++;
                    if (consecutiveSixes == 3) {
                        System.out.println("Three consecutive 6s! All moves cancelled.");
                        currentPlayer.setCurrentPosition(positionBeforeTurn);
                        break;
                    }
                }

                int newPos = applyMove(currentPlayer, roll);
                if (newPos == currentPlayer.getCurrentPosition()) {
                    System.out.println("Move exceeds 100, ignoring");
                } else {
                    System.out.println("Moved from " + currentPlayer.getCurrentPosition() + " to " + newPos);
                    currentPlayer.setCurrentPosition(newPos);
                }

                if (newPos == 100) {
                    winner = currentPlayer;
                    System.out.println("WINNER IS FINALISED - Player " + currentPlayer.getPlayerId());
                    break;
                }

                if (roll != 6) break;
                System.out.println("Bonus turn for rolling a 6!");
            }

            players.add(currentPlayer);
        }
   }

   private int applyMove(Player player, int roll) {
        int newPos = player.getCurrentPosition() + roll;
        if (newPos > 100) return player.getCurrentPosition();
        if (newPos == 100) return 100;
        Cell cell = board.getCurrentCell(newPos);
        if (cell.getJumpMove() != null && cell.getJumpMove().getStartingPosition() == newPos) {
            System.out.println("Snake/Ladder! " + newPos + " → " + cell.getJumpMove().getEndingPosition());
            newPos = cell.getJumpMove().getEndingPosition();
        }
        return newPos;
   }
}
