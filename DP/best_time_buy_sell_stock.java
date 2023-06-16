class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;

        int low = 0;
        int high = 1;
        int max = 0;

        while(high<n){
            if(prices[low]>prices[high]){
                low = high;
                high++;
            }
            else{
                max = Math.max(max, prices[high]-prices[low]);
                high++;
            }
        }

        return max;
    }
}