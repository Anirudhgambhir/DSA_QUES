package Practise;

public class KokoEatingBananas {
    public static void main(String[] args) {
        System.out.println(new KokoEatingBananas().minEatingSpeed(new int[]{1, 1, 1, 999999999}, 10));
        System.out.println(new KokoEatingBananas().minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        System.out.println(new KokoEatingBananas().minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int i = 1;
        int j = findMax(piles);
        int ans = -1;
        while (i <= j) {
            int mid = (i + j) / 2;
            int hours = calculateHours(piles, mid);
            if (hours <= h) {
                ans = mid;
                j = mid - 1;
            } else
                i = mid + 1;
        }
        return ans;
    }

    private int findMax(int[] piles) {
        int ans = -1;
        for (int pile : piles) {
            ans = Math.max(ans, pile);
        }
        return ans;
    }

    private int calculateHours(int[] piles, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours += Math.ceil((double) pile / (double) k);
        }
        return hours;
    }

}
