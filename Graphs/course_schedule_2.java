class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        ArrayList<Integer> [] g = new ArrayList[numCourses];

        for(int i=0; i<numCourses; i++){
            g[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<prerequisites.length; i++){
            int par = prerequisites[i][1];
            int child = prerequisites[i][0];

            g[par].add(child);
        }

        int [] indegree = new int [numCourses];

        for(int i=0; i<g.length; i++){
            for(int child: g[i]){
                indegree[child] += 1;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> topo = new ArrayList<Integer>();

        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            topo.add(curr);

            for(int child: g[curr]){
                indegree[child] -= 1;
                if(indegree[child] == 0){
                    q.add(child);
                }
            }
        }

        int [] ans = new int [topo.size()];
        for(int i=0; i<ans.length; i++){
            ans[i] = topo.get(i);
        }

        
        if(topo.size() != numCourses){
            return new int [0];
        }
        else{
            return ans;
        }

    }
}