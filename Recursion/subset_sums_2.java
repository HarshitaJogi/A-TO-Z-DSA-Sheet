class Solution {
    static List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<Integer> sub = new ArrayList<Integer>();
        ans.clear();
        generate(nums, 0, sub);

        // to make it without duplicates
        HashSet<List<Integer>> set = new HashSet();
        for(int i=0; i<ans.size(); i++){
            List<Integer> list = new ArrayList<Integer>();
            list = ans.get(i);
            set.add(list);
        }

        List<List<Integer>> ans1 = new ArrayList();
        for(List<Integer> i: set){
            ans1.add(i);
        }

        return ans1;

    }

    static void generate(int [] nums, int index, List<Integer> sub){

            
            if(index == nums.length){
                List<Integer> l = new ArrayList<Integer>();
                for(int c: sub){
                    l.add(c);
                }
                Collections.sort(l);
                ans.add(l);
                return;
            }
            
            // do not take the element
            generate(nums, index+1, sub);

            // take the element
            sub.add(nums[index]);
            generate(nums, index+1, sub);
            sub.remove(sub.size()-1);
    }
}