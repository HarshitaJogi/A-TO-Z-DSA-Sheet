class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int [] heights = new int [m+5];

        // for every row we are passing the heights histogram to findMaxArea function.
        // This function returns max area of all histograms of that row
        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == '1') heights[j]++;
                else heights[j] = 0;
            }
            int area = findMaxArea(heights);
            ans = Math.max(ans, area);
        }

        return ans;
    }

    // code taken from Largest Rectangle in Histogram sum
    static int findMaxArea (int [] heights){

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