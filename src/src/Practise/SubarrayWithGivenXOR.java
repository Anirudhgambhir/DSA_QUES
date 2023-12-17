package Practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubarrayWithGivenXOR {
    public static int subarrayWithSumK(int[] a, int k) {
        int xr = 0;
        Map<Integer, Integer> mpp = new HashMap<>(); //declaring the map.
        mpp.put(xr, 1); //setting the value of 0.
        int cnt = 0;

        for (int j : a) {
            // prefix XOR till index i:
            xr = xr ^ j;

            //By formula: x = xr^k:
            int x = xr ^ k;

            // add the occurrence of xr^k
            // to the count:
            if (mpp.containsKey(x)) {
                cnt += mpp.get(x);
            }

            // Insert the prefix xor till index i
            // into the map:
            if (mpp.containsKey(xr)) {
                mpp.put(xr, mpp.get(xr) + 1);
            } else {
                mpp.put(xr, 1);
            }
        }
        return cnt;
    }

    public int solve(ArrayList<Integer> A, int B) {
        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            int xor = 0;
            for (int j = i; j < A.size(); j++) {
                xor = xor ^ A.get(j);
                if (xor == B)
                    count++;
            }
        }
        return count;
    }
}
