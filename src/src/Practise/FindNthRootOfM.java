package Practise;

public class FindNthRootOfM {
    public static int NthRoot(int n, int m) {
        int i = 1;
        int j = m;
        while (i <= j) {
            int mid = (i+j) / 2;
            if (Math.pow(mid, n) == m)
                return mid;
            else if (Math.pow(mid,n) < m) {
                i = mid + 1;
            }
            else
                j = mid - 1;
        }
        return -1;
    }
}
