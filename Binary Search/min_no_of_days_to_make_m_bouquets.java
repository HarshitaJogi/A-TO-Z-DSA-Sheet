class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        // if total number of flowers required < available flowers, it is not possible to make bouquets
        long flowers = (long)m*(long)k;
        long flowers_available = (long)n;
        if(flowers > flowers_available) return -1;

        int low = 1;
        int high = -1;
        for(int i: bloomDay){
            high = Math.max(i, high);
        }

        int ans = Integer.MAX_VALUE;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(isPossible(mid, bloomDay, k, m) == true){
                high = mid-1;   // minimize it
                ans = Math.min(ans, mid);
            }
            else{
                low = mid+1;
            }
        }

        return ans;

    }

    static boolean isPossible(int mid, int [] bloomDay, int k, int m){
        int n = bloomDay.length;

        int adj_count = 0;
        int bouquets = 0;

        for(int i=0; i<n; i++){
            if(bloomDay[i]<=mid){
                adj_count++;
            }
            else{
                bouquets += (adj_count/k);
                adj_count=0;
            }
        }

        bouquets += (adj_count/k);

        if(bouquets >= m) return true;
        else return false;

    }
}