class Solution {
    public int removeStones(int[][] stones) {
    
        int n = stones.length;

        // tells us about the location of last stone (for size of stone array whose coordinates are given in stones arr)
        int maxRow = 0;
        int maxCol = 0;
        for(int i=0; i<n; i++){
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }


        // 1 is added for safety
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);

        HashMap<Integer, Integer> stoneNodes = new HashMap<>();
        // Explanation given at end
        for(int i=0; i<n; i++){
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;
            ds.unionByRank(nodeRow, nodeCol);
            // put in hashmap bec we do not want duplicate nodes
            stoneNodes.put(nodeRow, 1);
            stoneNodes.put(nodeCol, 1);
        }

        int no_of_components = 0;
        for(Map.Entry<Integer, Integer> m : stoneNodes.entrySet()){
            int node = m.getKey();
            // i.e. if this is ultimate parent
            if(ds.findUPar(node) == node){
                no_of_components++;
            }
        }

        int ans = n - no_of_components;
        return ans;



        // Explanation:
         /*
					  5 6 7 8  --> colno
					0 1
					1
					2
					3
					4--> rowno 

					node between (0,0)==(0,5)


				*/



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