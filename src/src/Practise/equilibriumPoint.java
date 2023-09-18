package Practise;

public class equilibriumPoint {
    public static void main(String[] args) {
        long i = equilibriumPoint(new long[] { 1,3,5,2,2}, 5);
        System.out.println(i);
    }

    public static int equilibriumPoint(long[] a, int n) {
        int rightSum = 0;
        for (long i : a) {
            rightSum += i;
        }

        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            rightSum -= a[i];
            if (leftSum == rightSum) {
                return i + 1;
            }
            leftSum += a[i];
        }
        return -1;
    }

//    public static int equilibriumPoint(long arr[], int n) {
//
//        long[] suma = new long[n];
//        long[] reva = new long[n];
//        int i = 1;
//        int j = n-2;
//        suma[0] = arr[0];
//        reva[n-1] = arr[n-1];
//        while (i < n && j > 0) {
//            suma[i] = suma[i-1] + arr[i];
//            reva[j] = reva[j+1] + arr[j];
//            i++;
//            j--;
//        }
//
//        for (int p = 0; p < n; p++){
//            if (suma[p] == reva[p]) {
//                return p+1;
//            }
//        }
//
//        return -1;
//    }
}
