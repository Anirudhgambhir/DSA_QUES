package Practise;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MinimumNumberOfJumps {

    static int minJumps(int @NonNull [] arr) {
        if (arr.length <= 1)
            return 0;

        if (arr[0] == 0)
            return -1;

        if (arr[0] >= arr.length)
            return 1;

        int max = arr[0];
        int step = arr[0];
        int jump = 1;

        for (int i = 1; i < arr.length; i++) {

            if (i == arr.length - 1)
                return jump;

            if (arr[i] >= (arr.length - 1) - i)
                return jump + 1;

            max = Math.max(max, i + arr[i]);

            step--;

            if (step == 0) {
                jump++;

                if (i >= max)
                    return -1;

                step = max - i;
            }
        }
        return-1;
    }

}

