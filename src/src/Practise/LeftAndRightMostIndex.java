package Practise;

public class LeftAndRightMostIndex {
    public pair indexes(long v[], long x) {
        int a = printFirstOccurence(v, x);
        int b = printLastOccurence(v, x);
        return new pair(a, b);
    }

    private int printLastOccurence(long[] v, long x) {
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

    private int printFirstOccurence(long[] v, long x) {
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
