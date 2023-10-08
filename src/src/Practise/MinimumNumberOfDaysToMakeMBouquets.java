package Practise;


public class MinimumNumberOfDaysToMakeMBouquets {

    public static void main(String[] args) {
        System.out.println(new MinimumNumberOfDaysToMakeMBouquets().minDays(new int[]{1,10,3,10,2}, 3, 1));
        System.out.println(new MinimumNumberOfDaysToMakeMBouquets().minDays(new int[]{1,10,3,10,2}, 3, 2));
        System.out.println(new MinimumNumberOfDaysToMakeMBouquets().minDays(new int[]{7,7,7,7,12,7,7}, 2, 3));
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if ((m*k) > bloomDay.length)
            return -1;

        int i = maxMin(bloomDay)[1];
        int j = maxMin(bloomDay)[0];
        int ans = -1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (findBloomDay(bloomDay, mid, m, k)) {
                ans = mid;
                j = mid - 1;
            }
            else
                i = mid + 1;
        }
        return ans;
    }

    private boolean findBloomDay(int[] bloomDay, int days, int m, int k) {
        int blooms = 0;
        int bouquet = 0;
        for (int i : bloomDay) {
            if (i <= days) {
                blooms++;
            }
            else {
                bouquet += (blooms/k);
                blooms = 0;
            }
        }
        bouquet += (blooms/k);
        return bouquet >= m;
    }

    private int[] maxMin(int[] bloomDay) {
        int[] ans = new int[2];
        for (int i : bloomDay) {
            ans[0] = Math.max(ans[0],i);
            ans[1] = Math.min(ans[1], i);
        }
        return ans;
    }
}
