class Solution {

    static List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        
        // List<List<Integer>> ans = new ArrayList<>();
        // int n = nums.length;

        // for(int i=0; i<(1<<n); i++){
        //     int curr = i;
        //     List<Integer> l = new ArrayList<Integer>();
        //     for(int j=0; j<31; j++){
        //         if(((curr>>j)&1)!=0){
        //             l.add(nums[j]);
        //         }
        //     }
        //     ans.add(l);
        // }

        // return ans;

        
        List<Integer> sub = new ArrayList<Integer>();
        ans.clear();
        generate(nums, 0, sub);
        return ans;

    }

    static void generate(int [] nums, int index, List<Integer> sub){

        if(index == nums.length){
            List<Integer> l = new ArrayList<Integer>();
            for(int p: sub){
                l.add(p);
            }
            ans.add(l);
            return;
        }
        
        // do not pick the number
        generate(nums, index+1, sub);

        // pick the number
        sub.add(nums[index]);
        generate(nums, index+1, sub);
        sub.remove(sub.size()-1);

    }
}