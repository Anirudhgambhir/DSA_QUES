package Practise;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int i2 = lowerBound(new int[]{1, 3, 5, 6}, 5);
        int i1 = lowerBound(new int[]{1, 3, 5, 6}, 2);
        int i = lowerBound(new int[]{1, 3, 5, 6}, 7);
        System.out.println(i2);
        System.out.println(i1);
        System.out.println(i);
    }

    /**
     *  <p>Lower Bound is the smallest index which is equal or greater than the number</p>
     *
     * @param a - Array in which we need to find the insert position
     * @param x - Number for which insert position is required.
     * @return Integer - Index where elements need to be inserted.
     */
    private static int lowerBound(int[] a, int x) {
        int i = 0;
        int j = a.length - 1;
        int ans = a.length;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (a[mid] >= x){
                ans = mid;
                j = mid - 1;
            }
            else
                i = mid + 1;
        }
        return ans;
    }
}
