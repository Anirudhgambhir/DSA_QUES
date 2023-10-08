package Practise;

public class CapacityToShipPackagesWithinDDays {

    public static void main(String[] args) {
        System.out.println(new CapacityToShipPackagesWithinDDays().shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
        System.out.println(new CapacityToShipPackagesWithinDDays().shipWithinDays(new int[]{3,2,2,4,1,4}, 3));
        System.out.println(new CapacityToShipPackagesWithinDDays().shipWithinDays(new int[]{1,2,3,1,1}, 4));
    }

    public int shipWithinDays(int[] weights, int days) {
        int i = max(weights);
        int j = sum(weights);
        int ans = -1;
        while (i <= j) {
            int mid = (i + j) /2;
            int currDays = findDaysToShip(weights, mid);
            if (currDays <= days) {
                ans = mid;
                j = mid - 1;
            }
            else
                i = mid + 1;
        }
        return ans;
    }

    private int max(int[] weights) {
        int ans = -1;
        for (int i : weights) {
            ans = Math.max(ans,i);
        }
        return ans;
    }

    private int findDaysToShip(int[] weights, int weightOfShip) {
        int currWeight = 0;
        int days = 0;
        for (int i : weights) {
            if (currWeight + i <= weightOfShip) {
                currWeight += i;
            }else {
                days++;
                currWeight = i;
            }
        }
        return ++days;
    }

    private int sum(int[] weights) {
        int sum = 0;
        for (int i : weights)
            sum += i;
        return sum;
    }

    // Slightly Faster and Memory Efficient Solution Below
    // (Approach is same only extra Variables and logic moved to main function)-

    public int shipWithinDaysEfficient(int[] weights, int days) {
        int i = -1;
        int j = 0;
        for (int k : weights) {
            j += k;
            i = Math.max(i,k);
        }
        int ans = -1;
        while (i <= j) {
            int mid = (i + j) /2;
            if (findDaysToShip(weights, mid) <= days) {
                ans = mid;
                j = mid - 1;
            }
            else
                i = mid + 1;
        }
        return ans;
    }
}
