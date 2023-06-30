class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean ans = false;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == word.charAt(0)){
                    ans |= func(i, j, 0, word, board);
                }
            }
        }

        return ans;
    }

    static boolean func(int row, int col, int ind, String word, char [][] board){
        int m = board.length;
        int n = board[0].length;

        if(ind == word.length()){
            return true;
        }
        
        if(row>=m || row<0 || col>=n || col<0) return false;
        if(board[row][col] != word.charAt(ind)) return false;

        
        boolean ans = false;

        int [] dx = {0, 0, 1, -1};
        int [] dy = {1, -1, 0, 0};

        
        // backtracking, done so that we dont go back from were we came
        char curr = board[row][col];
        board[row][col] = '#';
        for(int i=0; i<4; i++){
            int child_row = row + dx[i];
            int child_col = col + dy[i];

            ans |= func(child_row, child_col, ind+1, word, board);
        }
        // restoring the backtracking
        board[row][col] = curr;

        return ans;
    }
}