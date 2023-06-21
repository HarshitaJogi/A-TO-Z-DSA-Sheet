class Solution {
    public int minCost(int n, int[] cuts) {
        // make a new array which is copy of cuts with 0 at start and n at end
        int l = cuts.length;
        int [] cuts2 = new int [l+2];
        for(int i=0; i<l; i++){
            cuts2[i] = cuts[i];
        }
        cuts2[l] = 0;
        cuts2[l+1] = n; 
        Arrays.sort(cuts2);

        // for(int i: cuts2) System.out.print(i + " ");
        // System.out.println();

        int [][] dp = new int [l+2][l+2];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++) dp[i][j] = 0;
        }

        for(int i=l; i>=1; i--){
            for(int j=i; j<=l; j++){

                int min = Integer.MAX_VALUE;
                for(int ind=i; ind<=j; ind++){
                    int costOfCutting_Itself = cuts2[j+1] - cuts2[i-1];   // prev cut - next cut gives total length
                    int costofCutting_Parts = dp[i][ind-1] +  dp[ind+1][j]; 
                    int totalCost = costOfCutting_Itself + costofCutting_Parts;
                    min = Math.min(min, totalCost);
                }

                dp[i][j] = min;

            }
        }

        // int ans = func(1, l, cuts2, dp);
        int ans = dp[1][l];
        return ans;
    }

    static int func(int i, int j, int [] cuts2, int [][] dp){

        if(i>j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for(int ind=i; ind<=j; ind++){
            int costOfCutting_Itself = cuts2[j+1] - cuts2[i-1];   // prev cut - next cut gives total length
            int costofCutting_Parts = func(i, ind-1, cuts2, dp) + func(ind+1, j, cuts2, dp);
            int totalCost = costOfCutting_Itself + costofCutting_Parts;
            min = Math.min(min, totalCost);
        }

        return dp[i][j] = min;
    }
}