class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<Integer>();
        int [] ans = new int [nums1.length];
        Arrays.fill(ans, -1);

        //map will contain values and indices of all elements in nums1 array
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for(int i=0; i<nums1.length; i++){
            m.put(nums1[i], i);
        }

        // stack stores the indexes of the numbers
        for(int i=0; i<nums2.length; i++){
            while(!st.isEmpty() && nums2[st.peek()]<nums2[i]){
                if(m.containsKey(nums2[st.peek()])){
                     ans[m.get(nums2[st.peek()])] = nums2[i];
                }
                st.pop();
            }
            st.push(i);
        }

        return ans;



        // map will contain values and indices of all elements in nums1 array
        // Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        // for(int i=0; i<nums1.length; i++){
        //     m.put(nums1[i], i);
        // }

        // st.push(nums2[0]);
        // for(int i=1; i<nums2.length; i++){
        //     int curr = nums2[i];
        //     if(m.containsKey(curr)){
        //         if(curr>st.peek() && st.isEmpty()==false){
        //             while(!st.isEmpty()){
        //                 int top = st.pop();
        //                 int index = m.get(top);
        //                 ans[index] = top;
        //             }
        //         }
        //         else{
        //             st.push(curr);
        //         }
        //     }
            
        // }

        // return ans;
        
        // int [] ans = new int [nums1.length];
        // int index = 0;
        // for(int i=0; i<nums1.length; i++){
        //     int curr = nums1[i];
        //     for(int j=0; j<nums2.length; j++){
        //         if(curr == nums2[j]){
        //             index = j;
        //             break;
        //         }
        //     }
        //     int a = -1;
        //     for(int j=index; j<nums2.length; j++){
        //         if(nums2[j]>nums2[index]){
        //             a = nums2[j];
        //             break;
        //         }
        //     }
        //     ans[i] = a;
        // }

        // return ans;

        
    }
}