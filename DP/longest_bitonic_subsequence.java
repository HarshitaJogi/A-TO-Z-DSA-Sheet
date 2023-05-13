class Solution
{
    public int LongestBitonicSequence(int[] arr)
    {
        
        // for increasing subsequence
        int[] inc_dp = new int[arr.length];
        Arrays.fill(inc_dp, 1);
        
        for(int ind=1; ind<arr.length; ind++){
            for(int i=0; i<ind; i++){
                if(arr[ind]>arr[i] && 1+inc_dp[i]>inc_dp[ind]){
                    inc_dp[ind] = inc_dp[i] + 1;
                }
            }
        }
        
        
        
        // for decreasing subsequence
        int n = arr.length;
        int [] dec_dp = new int[arr.length];
        Arrays.fill(dec_dp, 1);
        
        for(int ind=n-1; ind>=0; ind--){
            for(int i=n-1; i>ind; i--){
                if(arr[ind]>arr[i] && 1+dec_dp[i]>dec_dp[ind]){
                    dec_dp[ind] = dec_dp[i] + 1;
                }
            }
        }
        
        // for(int i: inc_dp) System.out.print(i + " ");
        // System.out.println();
        // for(int i: dec_dp) System.out.print(i + " ");
        // System.out.println();
        
        int ans = -1;
        for(int i=0; i<n; i++){
            int x = inc_dp[i]+dec_dp[i]-1;
            ans = Math.max(ans, x);
        }
        return ans;
    }
}