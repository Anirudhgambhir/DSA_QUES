package lld.snakeAndLadderGame.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cell {
    private JumpMove jumpMove;
}
