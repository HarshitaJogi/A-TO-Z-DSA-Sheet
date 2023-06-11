class Solution {
    public void solve(char[][] board) {
        
        int m = board.length;
        int n = board[0].length;

        boolean [][] vis = new boolean [m][n];

        // for(int i=0; i<m; i++){
        //     for(int j=0; j<n; j++){
        //         System.out.print(board[i][j] + " ");
        //     }
        //     System.out.println();
        // }


        // traversing through first row
        for(int i=0; i<n; i++){
            if(vis[0][i] == true) continue;
            if(board[0][i] == 'O'){
                // System.out.println("first row entered");
                dfs(board, vis, 0, i);
            } 
        }
        
        // traversing through last row
        for(int i=0; i<n; i++){
            if(vis[m-1][i] == true) continue;
            if(board[m-1][i] == 'O'){
                // System.out.println("last row entered");
                dfs(board, vis, m-1, i);
            } 
        }

        // traversing through first col
        for(int i=0; i<m; i++){
            if(vis[i][0] == true) continue;
            if(board[i][0] == 'O'){
                // System.out.println("first col entered");
                dfs(board, vis,i, 0);
            } 
        }

        // traversing through last col
        for(int i=0; i<m; i++){
            if(vis[i][n-1] == true) continue;
            if(board[i][n-1] == 'O'){
                // System.out.println("last col entered");
                dfs(board, vis,i, n-1);
            } 
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(vis[i][j] == true) continue;
                board[i][j] = 'X';
            }
        }

        

    }

    static void dfs(char [][] board, boolean [][] vis, int row, int col){
        int m = board.length;
        int n = board[0].length;
        vis[row][col] = true;
        // System.out.println("child is: " + row + " " + col);

        int [] x = {0, 0, 1, -1};
        int [] y = {1, -1, 0, 0};

        for(int i=0; i<4; i++){
            int child_x = row + x[i];
            int child_y = col + y[i];

            if(child_x>=m || child_x<0 || child_y>=n || child_y<0) continue;

            if(vis[child_x][child_y] == true) continue;

            if(board[child_x][child_y] != 'O') continue;

            dfs(board, vis, child_x, child_y);
        }
    }
}