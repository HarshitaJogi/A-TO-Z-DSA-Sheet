class Solution {
    public static double findSmallestMaxDist(int stations[],int K) {
    
        double low = 0;
        double high = 1E9;
        double eps = 1E-6;    
        
        double ans = 1E9;
        while((high - low) > eps){
            double mid = low + (high-low)/2.0;
            
            if(isPossible(mid, stations, K) == true){
                high = mid;
                ans = Math.min(ans, mid);
            }
            else{
                low = mid;
            }
        }
        
        
        return ans;

    }
    
    static boolean isPossible(double mid, int [] stations, int K){
        
        int placedStations = 0;
        
        for(int i=1; i<stations.length; i++){
            placedStations += (int)((stations[i]-stations[i-1])/mid);
        }
        
        if(placedStations <= K) return true;
        else return false;
    }
}
     