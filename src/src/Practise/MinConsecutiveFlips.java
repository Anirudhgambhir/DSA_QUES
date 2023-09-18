package Practise;


/***
 * Question :- Given a binary array, we need to convert this into an array that either contains all 1s or all 0s.
 * We need to do it using the minimum number of group flips.
 * Link - <a href="https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/video/MTU4Ng%3D%3D">Problem</a>
 *
 * The Catch here is there are 2 possibilities - 1. Either number of groups will be same or there is diff of 1 between
 * 2 groups. If start and end bit is same then number starting second is answer. Else both number have same groups
 * So we can always return the second group.
 */

public class MinConsecutiveFlips {
    public static void main(String[] args) {
        minConsecutiveFlips(new int[]{0,0,1,1,0,0,1,1,0,1}, 10);
    }

    private static void minConsecutiveFlips(int[] a, int n){
        for (int i = 1; i < n; i++) {
            if (a[i] != a[i-1]){
                if (a[i] != a[0])
                    System.out.print("From " + i + " to ");
                else
                    System.out.println(i-1);
            }
        }
        if (a[n - 1] != a[0])
            System.out.println(n-1);
    }
}
