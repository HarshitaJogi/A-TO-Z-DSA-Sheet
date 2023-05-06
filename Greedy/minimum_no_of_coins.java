// User function Template for Java

class Solution{
    static List<Integer> minPartition(int N)
    {
        // code here
        List<Integer> ans = new ArrayList<Integer>();
        
        int [] coins = {2000, 500, 200, 100, 50, 20, 10, 5, 2, 1};
        
        int val_left = N;
        
        for(int coin: coins){
            if(coin > val_left) continue;
            
            while(val_left>=0){
                if(val_left - coin < 0) break;
                ans.add(coin);
                val_left -= coin;
            }
        }
        
        return ans;
        
    }
}