class Solution {
    // static int ans = 0;
    static int [] dp = new int [100];
    public int climbStairs(int n) {
        int ans = 0;
        Arrays.fill(dp, 0);
        ans = func(n);
        return ans;
    }


    static int func(int n){

       if(n < 0) return 0;
       if(n == 0) return 1;
       if(dp[n] != 0) return dp[n];
       
       int ans = func(n-1);
       ans += func(n-2);

       return dp[n] = ans;
    }


    // static void stairs(int n, int step, int ways){

    //     if(step > n) return;

    //     if(step == n){
    //         ways++;
    //         System.out.println(ways);
    //         return;
    //     }
        
    //     // climb 1 step
    //     step += 1;
    //     stairs(n, step, ways);

    //     // climb 2 steps
    //     step += 2;
    //     stairs(n, step, ways);
    // }
}
