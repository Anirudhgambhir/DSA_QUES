package Practise;

public class SquareRootOfNumber {
    public static void main(String[] args) {
        System.out.println(sqrtN(7));
    }

    public static int sqrtN(long N) {
        long i = 0;
        long j = N/2;
        int ans = -1;
        while (i <= j){
            long mid = (i+j) /2;
            if (mid * mid <= N) {
                ans = (int) mid;
                i = mid + 1;
            }
            else
                j = mid - 1;
        }
        return ans;
    }
}

