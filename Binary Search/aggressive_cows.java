
// User function Template for Java
class Solution {
    public static int solve(int n, int k, int[] stalls) {
        
        int low = 1;
        int high = Integer.MAX_VALUE;
        Arrays.sort(stalls);
        
        while(low <= high){
            int mid = low + (high-low)/2;
            
            // int cows = isPossible(n, k, stalls, mid);
            
            if(isPossible(n, k, stalls, mid)==true){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        
        return high;
        
    }
    
    static boolean isPossible(int n, int k, int [] stalls, int mid){
        
        int placedcows = 1;
        int last_placed_cow = stalls[0];
        for(int i=0; i<n; i++){
            if((stalls[i]-last_placed_cow) >= mid){
                placedcows++;
                last_placed_cow = stalls[i];
                if(placedcows == k) return true;
            }
        }
        
        return false;
    }
}