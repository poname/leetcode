class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minBuy = prices[0];
        for (int p : prices) {
            maxProfit = Math.max(maxProfit, p-minBuy);
            minBuy = Math.min(minBuy, p);
        }
        return maxProfit;
    }
}

// time: O(n)
// space: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += prices[i] - prices[i - 1];
            if (profit < 0)
                profit = 0;
            max = Math.max(max, profit);
        }
        return max;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int max = 0;
        int l = 0, r = 1;
        while (r < prices.length) {
            profit = prices[r] - prices[l];
            if (profit < 0)
                l = r;
            max = Math.max(max, profit);
            r++;
        }
        return max;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int l=0;
        int r=1;
        while (r < prices.length) {
            if (prices[r] > prices[l]) {
                max = Math.max(max, prices[r]-prices[l]);
            } else {
                l = r;
            }
            r++;
        }

        return max;
    }
}
