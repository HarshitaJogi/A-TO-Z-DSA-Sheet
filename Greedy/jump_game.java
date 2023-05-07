class Solution {
    public boolean canJump(int[] nums) {
        // int dist = 0;
        // boolean ans = false;

        // int index = 0;

        // while(index < nums.length){
        //     if(index >= nums.length-1) return true;
        //     System.out.println("index: " + index + " distance: " + dist);
        //     if(nums[index] == 0 && index != nums.length-1) return false;

        //     int max = -1;
        //     int max_index = 1;
        //     for(int j=1; j<=nums[index]; j++){
        //         if(index+j >= nums.length) return true;
        //         if(index+j < nums.length){
        //              if(nums[index+j]>max){
        //                 max = nums[j];
        //                 max_index = j;
        //             }
        //         }
               
        //     }

        //     if(max != -1){
        //         System.out.println("hi");
        //         dist += max_index - index;
        //         index += max_index;
        //     }
        //     else{
        //         dist += nums[index];
        //         index += nums[index];
        //     }
            
        // }

        // if(index >= nums.length-1) return true;
        // return ans;

        int n = nums.length;

        int [] vis = new int [nums.length];
        Arrays.fill(vis, 0);

        vis[0] = 1;

        if(n == 1) return true;

        if(nums[0] == 0) return false;

        boolean ans = true;

        for(int i=0; i<nums.length; i++){
            if(nums[i] >= n) return true;
            for(int j=1; j<=nums[i]; j++){
                
                if(vis[i] == 1 && i+j < n){
                    // marking them reachable
                    vis[i+j] = 1;
                }  
            }
        }

        if(vis[n-1] != 1) return false;

        return ans;
    }
}