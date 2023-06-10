class Solution{
	static int spanningTree(int V, int E, int edges[][]){  
	   
	   // KRUSKAL'S ALGO
	   
	   
	   // sort edges array according to weight, i.e. acc to col no 2
	   sortbyColumn(edges, 2);
	   
	   int ans = 0;
	   ArrayList<pair> mst = new ArrayList<>();
	   
	   // make object of class disjointset (written below)
	   DisjointSet ds = new DisjointSet(V);
	   
	   for(int i=0; i<edges.length; i++){
	       int u = edges[i][0];
	       int v = edges[i][1];
	       int wt = edges[i][2];
	       
	       if(ds.findUPar(u) == ds.findUPar(v)) continue;
	       
	       else{
	           ds.unionBySize(u, v);
	           ans += wt;
	           mst.add(new pair(u, v));
	       }
	   }
	   
	   // for(int i=0; i<mst.size(); i++){
	   //     System.out.println(mst.get(i).first + " - " + mst.get(i).second);
	   // }
	   
	   return ans;
	   
	    
	}
	
	
	public static void sortbyColumn(int edges[][], int col)
    {
        // Using built-in sort function Arrays.sort with lambda expressions
       
      Arrays.sort(edges, (a, b) -> Integer.compare(a[col],b[col])); // increasing order
         
    }
	
	


class pair{
    int first, second;
    public pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class tuple{
    int first, second, third;
    public tuple(int first, int second,int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}




class DisjointSet{

    List<Integer> rank = new ArrayList<Integer>();
    List<Integer> parent = new ArrayList<Integer>();
    List<Integer> size = new ArrayList<Integer>();

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