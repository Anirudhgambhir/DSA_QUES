package Practise;

public class CountGoodNumbers {
    public static void main(String[] args) {
        System.out.println(new CountGoodNumbers().countGoodNumbers(50));
    }
    private static final long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long odd = n / 2;
        long even = (n + 1) / 2;
        return (int) ( myPow(5, even) * myPow(4, odd) % MOD);
    }

    private long myPow(long x, long n) {
        if (n == 0) return 1;
        long ans = myPow(x, n / 2);
        ans = n % 2 != 0 ? (ans * ans * x) % MOD : (ans * ans) % MOD;
        return ans;
    }
}
