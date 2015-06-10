public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        int max = 0;
        int diff;
        
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            diff = prices[i] - min;
            if (max < diff) {
                max = diff;
            }
        }
        
        return max;
    }
}