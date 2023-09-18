package Practise;

public class WeightedPrefixSum {
    public static void main(String[] args) {
        WeightedPrefixSum weightedPrefixSum = new WeightedPrefixSum();
        System.out.println(weightedPrefixSum.weightedPrefixSum(new int[] {2,3,5,1,7}, 5,2 ,4));
    }
    public int weightedPrefixSum(int[] a, int n, int l, int r) {
        int[] prefixArray = new int[n];
        int[] weightedPrefixArray = new int[n];
        prefixArray[0] = a[0];
        weightedPrefixArray[0] = a[0];
        long start = System.currentTimeMillis();
        for (int i = 1; i < n; i++) {
            prefixArray[i] = prefixArray[i-1] + a[i];
            weightedPrefixArray[i] = weightedPrefixArray[i-1] + (a[i] * (i+1));
        }
        int pfAns;
        int wPfAns;
        if (l > 0){
            pfAns = prefixArray[r] - prefixArray[l-1];
            wPfAns = weightedPrefixArray[r] - weightedPrefixArray[l-1];
        } else {
            pfAns = prefixArray[r];
            wPfAns = weightedPrefixArray[r];
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return wPfAns - (pfAns * l);


    }
}
