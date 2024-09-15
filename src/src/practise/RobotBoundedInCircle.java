package practise;

public class RobotBoundedInCircle {

    private final int[] cardinalPoints = new int[2];

    private Direction direction = Direction.NORTH;

    public boolean isRobotBounded(String instructions) {
        for (char instruction : instructions.toCharArray()) {
            handleInstruction(instruction, cardinalPoints);
        }
        System.out.println("Direction -  " + direction);
        return (cardinalPoints[0] == 0 && cardinalPoints[1] == 0) || direction != Direction.NORTH;
    }

    /**
     * Handle each instruction
     * @param instruction - instruction to be processed
     * @param cardinalPoints - cardinal points of the robot
     */
    private void handleInstruction(char instruction, int[] cardinalPoints) {
        switch (instruction) {
            case 'G': // move forward
                performMovement(cardinalPoints);
                break;
            case 'L': // turn left
                direction = Direction.values()[(direction.ordinal() + 3) % 4];
                break;
            case 'R': // turn right
                direction = Direction.values()[(direction.ordinal() + 1) % 4];
                break;
            default:
                throw new UnsupportedOperationException(instruction + " is not supported");
        }
    }

    private void performMovement(int[] cardinalPoints) {
        switch (direction) {
            case NORTH:
                cardinalPoints[1]++;
                break;
            case EAST:
                cardinalPoints[0]++;
                break;
            case SOUTH:
                cardinalPoints[1]--;
                break;
            case WEST:
                cardinalPoints[0]--;
                break;
        }
    }

    private enum Direction {
        NORTH, EAST, SOUTH, WEST
    }
}
