class Solution{
    // static ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
    public ArrayList<Integer> longestIncreasingSubsequence(int N, int arr[]){
    //     // Code here
    //      all.clear();
        
    //     ArrayList<Integer> sub = new ArrayList<Integer>();
    //     ArrayList<Integer> ans = new ArrayList<Integer>();
        
    //     int max_length = 0;
    //     for(int i=0; i<arr.length; i++){
    //         max_length = Math.max(max_length, func(arr, sub, i));
    //     }
        
        
    //     // System.out.println(max_length);
        
    //     // for(int i=0; i<all.size(); i++){
    //     //     ArrayList<Integer> li = new ArrayList<Integer>();
    //     //     li = all.get(i);
    //     //     for(int j=0; j<li.size(); j++) System.out.print(li.get(j) + " ");
    //     //     System.out.println();
    //     // }
        
    //     for(int i=0; i<all.size(); i++){
    //         ArrayList<Integer> l = new ArrayList<Integer>();
    //         l = all.get(i);
    //         int len = l.size();
    //         if(len == max_length){
    //             ans = l;
    //             break;
    //         }
    //     }
        
    //     Collections.reverse(ans);
        
    //     return ans;
    
    
        ArrayList<Integer> ans = new ArrayList<Integer>();
    
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        
        // acts as parent array
        int [] hash = new int [arr.length+1];
        for(int i=0; i<hash.length; i++) hash[i] = i;
        
        // TABULAR FORM
        for(int ind=0; ind<arr.length; ind++){
            for(int i=0; i<ind; i++){
                if(arr[ind]>arr[i] && 1+dp[i]>dp[ind]){
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
    
    // static int lis(int [] arr, int index, int []dp){
    
    //     if(dp[index] != -1) return dp[index];
        
    //     int ans = 1;
    //     for(int i=0; i<index; i++){
    //         if(arr[i]<arr[index]){
    //             ans = Math.max(ans, lis(arr, i, dp)+1);
    //         }
    //     }
        
    //     return dp[index] = ans;
    // }
    
    
    
    // static int func(int [] arr, ArrayList<Integer> sub, int index){
        
    //     int length = 1;
    //     sub.add(arr[index]);
    //     for(int i=0; i<=index; i++){
    //         if(arr[index]>arr[i]){
    //             length = Math.max(length, func(arr, sub, i)+1);
    //         }
    //     }
        
    //     // for(int i=0; i<sub.size(); i++) System.out.print(sub.get(i) + " ");
    //     // System.out.println();
        
    //     all.add(new ArrayList<Integer>(sub));
        
    //     sub.remove(sub.size()-1);
        
    //     return length;
    // }
}
