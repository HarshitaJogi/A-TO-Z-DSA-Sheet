class Solution {
    public int largestRectangleArea(int[] heights) {

        /*
         1. find next smaller element fill with n
         2. find prev smaller element fill with -1
         3. maximize area = nextsmaller[i]-prevsmaller[i]-1
        */
        
        int n = heights.length;

        // for next smaller
        int [] nextSmaller = new int [n];
        Arrays.fill(nextSmaller, n);

        Stack<Integer> st = new Stack<Integer>();

        for(int i=0; i<n; i++){
            if(st.isEmpty()){
                st.push(i);
            }
            else{
                while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                    nextSmaller[st.peek()] = i;
                    st.pop();
                }
                st.add(i);
            }
        }

        // for prev smaller
        int [] prevSmaller = new int [n];
        Arrays.fill(prevSmaller, -1);


        for(int i=n-1; i>=0; i--){
            if(st.isEmpty()){
                st.push(i);
            }
            else{
                while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                    prevSmaller[st.peek()] = i;
                    st.pop();
                }
                st.add(i);
            }
        }

        for(int i: nextSmaller) System.out.print(i + " ");
        System.out.println();
        for(int i: prevSmaller) System.out.print(i + " ");
        System.out.println();


        int ans = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            int h = heights[i];
            int l = nextSmaller[i] - prevSmaller[i] - 1;
            int area = h*l;
            // System.out.println("height: " + h + " length " + l);
            ans = Math.max(ans, area);
        }

        return ans;
    }
}