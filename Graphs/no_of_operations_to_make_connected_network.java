class Solution {
    public int makeConnected(int n, int[][] connections) {
        
        if(connections.length < (n-1)) return -1;

        DisjointSet ds = new DisjointSet(n);

        int no_of_extra_edges = 0;
        for(int i=0; i<connections.length; i++){
            int u = connections[i][0];
            int v = connections[i][1];

            if(ds.findUPar(u) == ds.findUPar(v)) no_of_extra_edges++;
            else ds.unionBySize(u, v);
        }

        int no_of_components = 0;
        for(int i=0; i<n; i++){
            if(ds.findUPar(i) == i) no_of_components++;
        }

        // tells us the number of edges needed to connect these no of compoenents
        int ans = no_of_components-1;

        if(no_of_extra_edges >= ans) return ans;
        else return -1;

    }
}

class DisjointSet{

    public List<Integer> rank = new ArrayList<Integer>();
    public List<Integer> parent = new ArrayList<Integer>();
    public List<Integer> size = new ArrayList<Integer>();

    public DisjointSet(int n){
        // <=n for 1 based indexing
        for(int i=0; i<=n; i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    // finds ultimate parent
    public int findUPar(int node){
        if(node == parent.get(node)){
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        // means they have the same ultimate parent
        if(ulp_u == ulp_v) return;

        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
        }

        else if(rank.get(ulp_v) < rank.get(ulp_u)){
            parent.set(ulp_v, ulp_u);
        }

        else{
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            // increase rank of u by 1
            rank.set(ulp_u, rankU+1);
        }
    }


    public void unionBySize(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        // means they have the same ultimate parent
        if(ulp_u == ulp_v) return;

        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        }

        else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }


    }
}