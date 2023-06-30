class Solution {
    public static ArrayList<String> findPath(int[][] matrix, int n) {
        
        String sub = "";
        ArrayList<String> ans = new ArrayList<>();
        
        func(0, 0, sub, ans, matrix);
        
        
        
        return ans;
    }
    
    static void func(int row, int col, String sub, ArrayList<String> ans, int[][] matrix){
        int n = matrix.length;
        
        if(row>=n || col>=n || row<0 || col<0) return;
        if(matrix[row][col] != 1) return;
        
        if(row==n-1 && col==n-1){
            ans.add(sub);
            return;
        }
        
        // backtracking to prevent from going back to same place IN THAT PATH
        // since we have to find multiple paths, we do this
        // otherwise we would have used visited array
        int orignal = matrix[row][col];
        matrix[row][col] = 2;
        
        // up
        sub += 'U';
        func(row-1, col, sub, ans, matrix);
        sub = sub.substring(0, sub.length()-1);
        
        // down
        sub += 'D';
        func(row+1, col, sub, ans, matrix);
        sub = sub.substring(0, sub.length()-1);
        
        // right
        sub += 'R';
        func(row, col+1, sub, ans, matrix);
        sub = sub.substring(0, sub.length()-1);
        
        // left
        sub += 'L';
        func(row, col-1, sub, ans, matrix);
        sub = sub.substring(0, sub.length()-1);
        
        // restore the backtracking
        matrix[row][col] = orignal;
        
    }
}