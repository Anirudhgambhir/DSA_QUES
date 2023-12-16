package Practise;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {

    // Brute Force
    void intersection(int[] a, int[] b) {

        Set<Integer> arraySet = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[i])
                    arraySet.add(a[i]);
            }
        }

        System.out.println(arraySet);
    }

    // Efficient
    void intersectionEfficient(int[] a, int[] b) {

        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }
            if (a[i] < b[j])
                i++;
            else if (a[i] > b[j])
                j--;
            else
                System.out.println("Found intersected Element : A -> " + a[i++] + " B -> " + b[j++]);
        }
    }
}
