package Practise;

public class CeilAndFloor {

    public static void ceilingInSortedArray(int n, int x, int[] arr) {
        int floor = floor(n,x,arr);
        int ceil = ceil(n,x,arr);
        System.out.printf("%d, %d", floor, ceil);
    }

    private static int floor(int n, int x, int[] arr) {
        int floor = -1;
        int i = 0;
        int j = n - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (arr[mid] <= x) {
                i = mid + 1;
                floor = Math.max(floor, arr[mid]);
            }
            else
                j = mid - 1;
        }
        return floor;
    }

    private static int ceil(int n, int x, int[] arr) {
        int ceil = -1;
        int i = 0;
        int j = n - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (arr[mid] >= x) {
                j = mid - 1;
                ceil = Math.max(ceil, arr[mid]);
            }
            else
                i = mid + 1;
        }
        return ceil;
    }


}
