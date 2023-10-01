package Practise;

import java.util.ArrayList;
import java.util.List;

public class SuperiorElements {

    public static void main(String[] args) {
        List<Integer> integers = superiorElements(new int[]{187,64,133,62,49,163,50,115,42,65,60,49,32,87,141,142,146,159});
        System.out.println(integers);
    }

    public static List< Integer > superiorElements(int []a) {
        List<Integer> ans = new ArrayList<>();
        //ans[a.length - 1] = a[a.length - 1];
        int curr = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i] > curr) {
                ans.add(curr);
                curr = a[i];
            }
        }
        ans.add(curr);
        return ans;
    }
}
