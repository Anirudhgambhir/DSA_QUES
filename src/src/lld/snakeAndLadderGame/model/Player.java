package lld.snakeAndLadderGame.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Player {
    private int playerId;
    private int currentPosition;
    private List<Integer> previousMoves;
}
