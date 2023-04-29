class Solution {
    static int [][] dp = new int [500][500];
    public int minimumTotal(List<List<Integer>> triangle) {

        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        int rows = triangle.size();
        int cols = triangle.get(rows-1).size();

        // int ans = func(triangle, rows-1, cols-1);
        int ans = fun(triangle, 0, 0, rows);
        return ans;
        
    }

    static int fun(List<List<Integer>> triangle, int x, int y, int rows){

        if(dp[x][y] != -1) return dp[x][y];
        
        if(x == rows) return 0;

        int row = triangle.size();
        
        //way 1
        int lower_right = fun(triangle, x+1, y+1, row) + triangle.get(x).get(y);

        // way 2
        int lower = fun(triangle, x+1, y, row) + triangle.get(x).get(y);

        return dp[x][y] = Math.min(lower_right, lower);
    }



    // static int func(List<List<Integer>> triangle, int x, int y){

    //     // int m = triangle.size();
    //     // int n = triangle.get(x).size();

    //     if(x<0 || y<0 || y>= triangle.get(x).size()) return (int)1E7;
        
    //     // move right on index i
    //     int ans = func(triangle, x-1, y-1) + triangle.get(x).get(y);

    //     // move left on index i
    //     ans = Math.min(ans, func(triangle, x-1, y+1) + triangle.get(x).get(y));

    //     // move to i+1
    //     ans = Math.min(ans, func(triangle, x-1, y) + triangle.get(x).get(y));

    //     return ans;

    // }
}