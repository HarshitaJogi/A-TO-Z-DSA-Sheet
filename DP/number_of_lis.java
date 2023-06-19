class Solution {

    /*
        1 3 5 4 7
    */

    public int findNumberOfLIS(int[] arr) {
        
        int[] dp = new int[arr.length+5];
        Arrays.fill(dp, 1);

        int [] count = new int [arr.length+5];
        Arrays.fill(count, 1);
        
        int maxi = 1;
        for(int ind=1; ind<arr.length; ind++){
            for(int prev_ind=0; prev_ind<ind; prev_ind++){
                if(arr[ind]>arr[prev_ind] && 1+dp[prev_ind]>dp[ind]){
                    dp[ind] = dp[prev_ind] + 1;
                    // inherit the count
                    count [ind] = count[prev_ind];
                }
                else if(arr[ind]>arr[prev_ind] && 1+dp[prev_ind] == dp[ind]){
                    // increment the count of index
                    count[ind] = count[ind] + count[prev_ind];
                }
            }
            maxi = Math.max(maxi, dp[ind]);
        }

        int ans = 0;
        for(int i=0; i<arr.length; i++){
            if(dp[i] == maxi) ans += count[i];
        }
        

        return ans;
    }
}