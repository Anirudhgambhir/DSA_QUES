package practise;

import java.util.Arrays;

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int wealthOfRichestCustomer = 0;
        for (int[] account : accounts) {
            wealthOfRichestCustomer = Math.max(Arrays.stream(account).sum(), wealthOfRichestCustomer);
        }
        return wealthOfRichestCustomer;
    }
}
