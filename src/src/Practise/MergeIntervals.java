package Practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        new MergeIntervals().merge(new int[][]{{2,6},{1,3},{8,10},{15,18}});
    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> ans = new LinkedList<>();
        for (int[] interval: intervals) {
            if (ans.isEmpty() || ans.getLast()[1] < interval[0])
                ans.add(interval);
            else
                ans.getLast()[1] = Math.max(interval[1], ans.getLast()[1]);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
