package lld.snakeAndLadderGame;

import lld.snakeAndLadderGame.model.JumpMove;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<JumpMove> snakes = new ArrayList<>();
        snakes.add(JumpMove.builder().startingPosition(34).endingPosition(6).build());
        snakes.add(JumpMove.builder().startingPosition(72).endingPosition(15).build());
        snakes.add(JumpMove.builder().startingPosition(98).endingPosition(25).build());

        List<JumpMove> ladders = new ArrayList<>();
        ladders.add(JumpMove.builder().startingPosition(3).endingPosition(38).build());
        ladders.add(JumpMove.builder().startingPosition(21).endingPosition(59).build());
        ladders.add(JumpMove.builder().startingPosition(50).endingPosition(75).build());

        Game game = new Game(snakes, ladders, 2);
        game.startGame();
    }
}
