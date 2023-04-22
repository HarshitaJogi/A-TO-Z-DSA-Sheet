class Solution {
    static List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        ans.clear();
        List<Integer> sub = new ArrayList<Integer>();
        Arrays.sort(candidates);
        generate(candidates, target, 0, sub);


        // to make ans unique
        HashSet<List<Integer>> set = new HashSet();
        for(int i=0; i<ans.size(); i++){
            List<Integer> list = new ArrayList<Integer>();
            list = ans.get(i);
            set.add(list);
        }

        ans.clear();
        for(List<Integer> li: set){
            ans.add(li);
        }


        return ans;
    }

    static void generate(int [] candidates, int target, int index, List<Integer> sub){

        
        int sum = 0;
        for(int c: sub) sum+= c;
        
        if(sum > target || index == candidates.length) return;

        if(sum == target){
            List<Integer> l = new ArrayList<Integer>();
            for(int i: sub) l.add(i);
            ans.add(l);
        }
        
        
        // do not take number
        generate(candidates, target, index+1, sub);

        // take the number
        sub.add(candidates[index]);
        generate(candidates, target, index, sub);
        sub.remove(sub.size()-1);
    }
}