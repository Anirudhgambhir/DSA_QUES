package lld.snakeAndLadderGame.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Class Maintaining a jump/move using a Snake or Ladder
 */
@Builder
@Data
@Setter
@Getter
public class JumpMove {
    private int startingPosition;
    private int endingPosition;
}
