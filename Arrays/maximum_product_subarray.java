class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        // KADANE'S ALGORITHM

        int maxi = Integer.MIN_VALUE;
        int prod = 1;

        for(int i=0; i<n; i++){
            prod *= nums[i];
            maxi = Math.max(maxi, prod);
            if(prod == 0){
                prod = 1;
            }
        }

        prod = 1;
        for(int i=n-1; i>=0; i--){
            prod *= nums[i];
            maxi = Math.max(maxi, prod);
            if(prod == 0) prod = 1;
        }

        return maxi;
    }

}