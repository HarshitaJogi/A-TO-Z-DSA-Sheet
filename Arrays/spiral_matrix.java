class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        ArrayList<Integer> ans = new ArrayList<Integer>();

        int top = 0;
        int bottom = matrix.length;
        int left = 0;
        int right = matrix[0].length;

        while(top<bottom && left<right){

            // left to right
            for(int i=left; i<right; i++){
                ans.add(matrix[top][i]);
            }
            top++;

            // top to bottom
            for(int i=top; i<bottom; i++){
                ans.add(matrix[i][right-1]);
            }
            right--;

            if(top>=bottom || left>=right) break;

            // right to left
            for(int i=right-1; i>=left; i--){
                ans.add(matrix[bottom-1][i]);
            }
            bottom--;

            // bottom to top
            for(int i=bottom-1; i>=top; i--){
                ans.add(matrix[i][left]);
            }
            left++;
        }

        return ans;


        // int row = matrix.length;
        // int col = matrix[0].length;
        // ArrayList<Integer> ans = new ArrayList<Integer>();
        // int i=0;
        // int j=0;

        // for(int k=0; k<row/2; k++){

        //     // left to right
        //     for(j=j; j<col; j++){
        //         ans.add(matrix[i][j]);
        //     }
        //     j=j-1;

        //     // top to botton
        //     for(i=i+1; i<row; i++){
        //         ans.add(matrix[i][j]);
        //     }
        //     i=i-1;

        //     // right to left
        //     for(j=j-1; j>=0; j--){
        //         ans.add(matrix[i][j]);
        //     }
        //     j=j+1;

        //     // bottom to top
        //     for(i=i-1; i>0; i--){
        //         ans.add(matrix[i][j]);
        //     }
        //     i=i+1;

        //     i=i+1;
        //     j=j+1;
        //     col = col-1;
        //     row = row-1;
        // }
        

        // for(int h: ans){
        //     System.out.print(h + " ");
        // }

        // return ans;
    }
}