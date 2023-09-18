package Practise;

public class MaximumOccuredInteger {

    public static int maxOccuredEfficient(int L[], int R[], int n, int maxx){
        int[] count = new int[maxx+1];
        for (int i = 0; i < n; i++) {
            count[L[i]]++;
            count[R[i]+1]--;
        }
        int max = count[0];
        int idx = 0;
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i-1];
            if (count[i] > max){
                max = count[i];
                idx = i;
            }
        }
        return idx;
    }


    // Naive Solution counting frequency of all numbers
    public static int maxOccured(int L[], int R[], int n, int maxx){
        int[] count = new int[maxx+1];
        for (int i = 0; i < n; i++) {
            for (int j = L[i]; j < R[i]; j++) {
                count[j - 1]++;
            }
        }
        int ans = 0;
        for (int c :
                count) {
            if (c > ans)
                ans = c;
        }
        return ans;
    }
}
