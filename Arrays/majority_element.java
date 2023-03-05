class Solution {
    public int majorityElement(int[] nums) {
        
        // WAY ONE:

        // Arrays.sort(nums);
        // //for(int h: nums) System.out.print(h + " ");
        // System.out.println();
        // int point = 1;
        // int n = nums.length;
        // int ans = nums[0];

        // for(int i=0; i<n-1; i++){
        //     //System.out.println("point is: " + point);
        //     if(nums[i]==nums[i+1]){
        //         point++;
        //     }
        //     else{
        //         point=1;
        //     }
        //      if(point>(n/2)){
        //             ans = nums[i];
        //             break;
        //         }
            
        // }
        // return ans;

        // WAY TWO:
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n/2];
    }
}