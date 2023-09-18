package Practise;

/**
 * The task is to complete the function transitionPoint() that takes array and N as input parameters
 * and returns the 0 based index of the position where "0" ends and "1" begins.
 * If array does not have any 1s, return -1. If array does not have any 0s, return 0.
 * Problem - <a href="https://practice.geeksforgeeks.org/problems/find-transition-point-1587115620/">Link</a>
 */
public class TransitionPoint {
    int transitionPoint(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] != arr[0])
                return i;

        }

        return arr[0] == 0 ? -1 : 0;
    }
}
