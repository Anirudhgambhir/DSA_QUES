package Practise;

public class RepeatingElements {

    /**
     * O(N) solution with constant space
     */
    public static int repeatingElementsEfficient(int[] a){
        int fast = a[0] + 1;
        int slow = a[0] + 1;
        do {
            fast = a[a[fast] + 1] + 1;
            slow = a[slow] + 1;
        } while (fast != slow);
        slow = a[0] + 1;
        while (fast != slow) {
            fast = a[fast] + 1;
            slow = a[slow] + 1;
        }
        return slow - 1;
    }


    /**
     * O(N) solution but needs Extra Space
     */
    public static int repeatingElements(int[] a) {
        boolean[] check = new boolean[a.length];
        for (int i : a){
            if (check[i])
                return i;
            check[i] = true;
        }
        return -1;
    }
}
