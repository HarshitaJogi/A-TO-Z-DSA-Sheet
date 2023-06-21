class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;

        int [] dp = new int [n+5];
        Arrays.fill(dp, -1);

        for(int ind=n-1; ind>=0; ind--){

            int len = 0;
            int currmax = Integer.MIN_VALUE;
            int ans = 0;

            for(int i=ind; i<Math.min(n, ind+k); i++){
                len++;
                currmax = Math.max(currmax, arr[i]);
            // bec that part all elements change to currmax, the total sum of that part will be (length of  part*currmax)
                int sum = len*currmax + dp[i+1];    // curr sum + sum of next half
                ans = Math.max(ans, sum);
            }

            dp[ind] = ans;
        }

        // int ans = func(0, arr, k, dp);
        int ans = dp[0];
        return ans+1;
    }

    // func gives us max sum of array partitioned till that index
    static int func(int ind, int [] arr, int k, int [] dp){
        int n = arr.length;
        if(ind == arr.length) return 0;

        if(dp[ind] != -1) return dp[ind];

        int len = 0;
        int currmax = Integer.MIN_VALUE;
        int ans = 0;
        for(int i=ind; i<Math.min(n, ind+k); i++){
            len++;
            currmax = Math.max(currmax, arr[i]);
            // bec that part all elements change to currmax, the total sum of that part will be (length of part*currmax)
            int sum = len*currmax + func(i+1,arr,k, dp);    // curr sum + sum of next half
            ans = Math.max(ans, sum);
        }

        return dp[ind] = ans;
    }
}