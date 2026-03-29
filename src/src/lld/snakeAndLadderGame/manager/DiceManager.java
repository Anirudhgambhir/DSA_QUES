package lld.snakeAndLadderGame.manager;

import java.util.concurrent.ThreadLocalRandom;

public class DiceManager {

    public int rollDice() {
        return ThreadLocalRandom.current().nextInt(1, 7);
    }
}
