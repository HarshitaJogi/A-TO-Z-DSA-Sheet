class Solution {
    public int trap(int[] height) {
        // find next greater element
        // if next greater element exists, find water

        int n = height.length;
        int [] maxleft = new int [n];

        int left = 0;
        for(int i=0; i<n; i++){
            maxleft[i] = left;
            left = Math.max(left, height[i]);
        }
        
        int [] maxright = new int [n];
        int right = 0;
        for(int i=n-1; i>=0; i--){
            maxright[i] = right;
            right = Math.max(right, height[i]);
        }

        int cnt = 0;
        for(int i=0; i<n; i++){
            int min = Math.min(maxleft[i], maxright[i]);
            int x = min - height[i];
            if(x>0){
                cnt += x;
            }
        }

        return cnt;
    }
}