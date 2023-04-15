class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for(int i=0; i<weights.length; i++){
            low = Math.max(low, weights[i]);
            high += weights[i];
        }

        while(low < high){
            int mid = low + (high -low)/2;

            int D = isPossible(mid, weights, days);
            // System.out.println("high: " + high + " low: " + low + " mid: " + mid + " D: " + D);

            if(D <= days){
                high = mid;
            }
            else{
                low = mid + 1;
            }
            
        }

        return low;
    }

    static int isPossible(int capacity, int[]weights, int days){
        int sum = 0;
        int index = 0;
        int ans = 1;
        // while(index < weights.length){
        //     while(sum <= capacity && index<weights.length){
        //         if(sum >= capacity) break;
        //         sum = sum + weights[index];
        //         index++;
                
        //     }
        //     sum = 0;
        //     ans++;
        // }


        for(int i=0; i<weights.length; i++){
            if((sum + weights[i]) > capacity){
                ans++;
                sum = 0;
            } 
            sum += weights[i];

        }

        // System.out.println("ans is " + ans);
        // if(ans <= days) return true;
        // else return false;
        return ans;
       
    }
}