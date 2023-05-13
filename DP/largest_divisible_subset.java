class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        
        List<Integer> ans = new ArrayList<Integer>();
    
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);

        Arrays.sort(arr);
        
        // acts as parent array
        int [] hash = new int [arr.length+1];
        for(int i=0; i<hash.length; i++) hash[i] = i;
        
        // TABULAR FORM
        for(int ind=1; ind<arr.length; ind++){
            for(int i=0; i<ind; i++){
                if((arr[ind]%arr[i]==0 || arr[i]%arr[ind]==0) && 1+dp[i]>dp[ind]){
                    dp[ind] = dp[i] + 1;
                    hash[ind] = i;
                }
            }
        }

        // int ans = 0;
        // for(int i: dp) ans = Math.max(ans, i);
        // System.out.println(ans);
        
        // for(int d: dp) System.out.print(d + " ");
        // System.out.println();
        // for(int h: hash) System.out.print(h + " ");
        // System.out.println();
        
        int last_index = -1;
        int max_value = -1;
        for(int i=0; i<dp.length; i++){
            if(dp[i]>max_value){
                max_value = dp[i];
                last_index = i;
            }
        }
        
        ans.add(arr[last_index]);
        while(hash[last_index] != last_index){
            last_index = hash[last_index];
            ans.add(arr[last_index]);
        }
        
        Collections.reverse(ans);
        
        
        return ans;
    }
}