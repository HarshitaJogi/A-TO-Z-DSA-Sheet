class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        //Arrays.sort(nums);

        
        // VOTING ALGORITHM
        int num1 = -1;
        int num2 = -1;
        int cnt1 = 0;
        int cnt2 = 0;

        for(int element : nums){

            if(element == num1) cnt1++;
            else if(element == num2) cnt2++;

            else if(cnt1==0){
                num1 = element;
                cnt1 = 1;
            }
            else if(cnt2==0){
                num2 = element;
                cnt2 = 1;
            }

            else{
                cnt1--;
                cnt2--;
            }
        }

        // check again if frequency is greater or not
        int freq_num1 = 0;
        for(int i=0; i<n; i++){
            if(nums[i]==num1) freq_num1++;
        }

        int freq_num2 = 0;
        for(int i=0; i<n; i++){
            if(nums[i]==num2) freq_num2++;
        }

        if(freq_num1>(n/3)) ans.add(num1);
        if(freq_num2>(n/3) && num2!=num1) ans.add(num2);

        return ans;
        
        
        
        // BRUTE FORCE
        // Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        // for(int i=0; i<n; i++){
        //     if(map.containsKey(nums[i])){
        //         map.put(nums[i], map.get(nums[i])+1);
        //     }
        //     else map.put(nums[i], 1);
        // }

        // for(Map.Entry<Integer, Integer> entry: map.entrySet()){
        //     System.out.println(entry.getValue());
        //     if(entry.getValue()>n/3){
        //         ans.add(entry.getKey());
        //     }
        // }

        
    //return ans;
    }
    

}