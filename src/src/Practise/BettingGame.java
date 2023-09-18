package Practise;

public class BettingGame {

    public static void main(String[] args) {
        int ans = betBalance("WL");
        System.out.println(ans);
    }

    static int betBalance(String result) {
        int sum = 4;
        int bet = 1;
        for (char c : result.toCharArray()) {
            if (sum - bet < 0){
                return -1;
            }
            if (c == 'W') {
                sum += bet;
                bet = 1;
            }
            else {
                sum -= bet;
                bet *= 2;
            }
        }
        return sum;
    }
}
