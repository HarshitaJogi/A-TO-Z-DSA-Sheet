class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        Stack<Integer> st = new Stack<Integer>();
        int [] ans = new int [nums.length];
        Arrays.fill(ans, -1);
        int n = nums.length;

        for(int i=0; i<2*n; i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i%n]){
                ans[st.peek()] = nums[i%n];
                st.pop();
            }
            st.push(i%n);
        }


        return ans;
    }
}