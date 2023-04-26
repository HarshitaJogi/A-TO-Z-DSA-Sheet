class Solution {
    static List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        ans.clear();
        List<Integer> sub = new ArrayList<Integer>();
        Arrays.sort(candidates);
        generate(candidates, target, 0, 0, sub);

        
        // to remove duplicates
        // HashSet<List<Integer>> set = new HashSet();
        // for(List<Integer> li: ans){
        //     set.add(li);
        // }
        // ans.clear();

        // for(List<Integer> l1: set){
        //     ans.add(l1);
        // }

        return ans;
    }

    static void generate(int [] candidates, int target, int currsum, int index, List<Integer> sub){

        if(currsum > target) return;

        if(currsum == target){
            List<Integer> l = new ArrayList<Integer>();
            for(int i: sub) l.add(i);
            Collections.sort(l);
            ans.add(l);
        }
        
        for(int i=index; i<candidates.length; i++){
            if(i>index && candidates[i]==candidates[i-1]) continue;
            sub.add(candidates[i]);
            currsum += candidates[i];
            generate(candidates, target, currsum, i+1, sub);
            currsum -= candidates[i];
            sub.remove(sub.size()-1);
        }
    }
}