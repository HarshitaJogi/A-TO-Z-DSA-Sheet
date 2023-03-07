class Solution {
     static int [] dp = new int [105];
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.fill(dp, -1);
        
        for(int i=1; i<=numRows; i++){
            List<Integer> row = new ArrayList<>();
            for(int j=1; j<=i; j++){
                int x = ncr(i-1, j-1);
                row.add(x);
            }
            ans.add(row);
        }

        return ans;
    }

    static int gcd(int a, int b){
        if(b==0) return a;
        else return gcd(b, a%b);
    }

    static int ncr(int n, int r){
        int num = 1;
        int denom = 1;
        if(n-r < r){
            r = n-r;
        }

        while(r>0){
            num = num * n;
            denom = denom * r;
            int gd = gcd(num, denom);
            num = num / gd;
            denom = denom / gd;
            n--;
            r--;

        }
        return num;
    }

   
    // static int fact(int n){
    //     if(dp[n]!= -1) return dp[n];
    //     if(n==0) return 1;
    //     return dp[n] = n*fact(n-1);
    // }

    // static int ncr(int n, int r){
        
    //     int num = fact(n);
    //     int denom = fact(r)*fact(n-r);
    //     int num = 1;
    //     for(int i=1; i<=r; i++){
    //         num = num * n;
    //         n--;
    //     }
    //     int denom = fact(r);
    //     int ans = num/denom;
    //     return ans;
    // }
}