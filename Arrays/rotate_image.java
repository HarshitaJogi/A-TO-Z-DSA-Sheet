class Solution {
    public void rotate(int[][] matrix) {
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        // reverse the matrix:

        for(int i=0; i<row/2; i++){
            for(int j=0; j<col; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[row-1-i][j];
                matrix[row-1-i][j] = temp;
            }
        }

        // swap elements i,j and j,i
        for(int i=0; i<row; i++){
            for(int j=i+1; j<col; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}