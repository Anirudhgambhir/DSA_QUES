package Practise;

public class NumberOfOccurenceOfNumber {
    public static int count(int arr[], int n, int x) {
        int last = printLastOccurence(arr,x);
        int first = printFirstOccurence(arr,x);
        return last - first + 1;
    }

    private static int printLastOccurence(int[] v, int x) {
        int i = 0;
        int j = v.length - 1;
        int ans = -1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (v[mid] == x) {
                ans = mid;
                i = mid + 1;
            } else if (v[mid] < x) {
                i = mid + 1;
            } else
                j = mid - 1;
        }
        return ans;
    }

    private static int printFirstOccurence(int[] v, int x) {
        int i = 0;
        int j = v.length - 1;
        int ans = -1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (v[mid] == x) {
                ans = mid;
                j = mid - 1;
            } else if (v[mid] < x) {
                i = mid + 1;
            } else
                j = mid - 1;
        }
        return ans;
    }
}
