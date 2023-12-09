package Practise;

public class PowOfXAndN {
    public static double myPow(double x, int n) {
        double ans = positivePow(x, Math.abs(n));
        return n < 0 ? 1 / ans : ans;
    }

    private static double positivePow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;

        double ans = myPow(x * x, n / 2);
        ans = n % 2 != 0 ? ans * x : ans;

        return ans;
    }
}
