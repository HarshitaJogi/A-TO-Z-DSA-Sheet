class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        // int sum = 0;
        // for(int i=0; i<piles.length; i++){
        //     sum += piles[i];
        // }
        
        int low = 1;
        int high = Integer.MAX_VALUE;
        int prev_mid = 0;

        while(low<high){
            int mid = low + (high-low)/2;

            //if(mid == 0) return prev_mid;

            int hrs = hours(piles, mid);
            //System.out.println("mid is " + mid + " hrs is " + hrs);

            if(hrs > h){
                low = mid+1;
            } 
            else{
                high = mid;
            }
            //prev_mid = mid;
        }
        return low;
    }

    static int hours(int [] piles, int mid){
        int hrs = 0;
        for(int i=0; i<piles.length; i++){
            hrs += (piles[i]+ mid-1)/mid;

            // int curr = piles[i];
            // if(piles[i]<=mid){
            //     hrs += 1;
            // }
            // else{
            //     while(curr>=mid){
            //         hrs++;
            //         curr = curr - mid;
            //     }
            //     if(curr != 0) hrs++;
            // }
            //System.out.println("hrs for " + piles[i] + " is: " + hrs);
            
        }
        return hrs;
        
    }
}