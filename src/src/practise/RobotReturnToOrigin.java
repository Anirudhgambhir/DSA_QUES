package practise;

public class RobotReturnToOrigin {
    private int xAxis = 0, yAxis = 0;
    public boolean judgeCircle(String moves) {
        for (char c : moves.toCharArray()) {
            handleMove(c);
        }
        return xAxis == 0 && yAxis == 0;
    }

    private void handleMove(char c) {
        switch (c) {
            case 'U':
                yAxis++;
                break;
            case 'D':
                yAxis--;
                break;
            case 'L':
                xAxis--;
                break;
            case 'R':
                xAxis++;
                break;
        }
    }
}
