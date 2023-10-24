package Practise;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    /**
     * Solution 2 is slightly faster that 1st one.
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> list, tempList=null;
        for (int i = 0; i < numRows; i++) {
            list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == i || j==0)
                    list.add(1);
                else
                    list.add(tempList.get(j-1)+ tempList.get(j));
            }
            tempList = list;
            answer.add(list);
        }
        return answer;
    }

    public List<List<Integer>> generateSolution2(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            answer.add(generateRows(i));
        }
        return answer;
    }

    private List<Integer> generateRows(int row) {
        List<Integer> list = new ArrayList<>();
        int ans = 1;
        list.add(1);
        for (int i = 1; i < row; i++) {
            ans *= (row - i);
            ans /= i;
            list.add((int) ans);
        }
        return list;
    }


}
