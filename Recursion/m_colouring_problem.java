class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        
        // getting in g form
        ArrayList<Integer> [] g = new ArrayList[n+1];
        for(int i=0; i<g.length; i++){
            g[i] = new ArrayList<Integer>();
        }
        
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(graph[i][j] == true){
                    int x = i;
                    int y = j;
                    g[x].add(y);
                }
            } 
        }
        
        int [] colour_arr = new int [n+5];
        
        boolean ans = solve(0, g, m, n, colour_arr);
        
        return ans;
    }
    
    static boolean solve(int node, ArrayList<Integer> [] g, int m, int n, int [] colour_arr){
        
        if(node == n) return true;    // all nodes coloured
        
        for(int colour=1; colour<=m; colour++){
            
            if(canColour(node, colour, g, colour_arr)){
                
                colour_arr[node] = colour;
                if(solve(node+1, g, m, n, colour_arr) == true) return true;
                colour_arr[node] = 0;   // backtracking
                
            }
        }
        
        // tried all possible combinations & couldnt colour all nodes
        return false;
    }
    
    static boolean canColour(int node, int colour, ArrayList<Integer> [] g, int [] colour_arr){
        // check if g has any neighbours already coloured with 'colour'
        for(int child: g[node]){
            if(colour_arr[child] == colour) return false;
        }
        
        return true;
    }
}