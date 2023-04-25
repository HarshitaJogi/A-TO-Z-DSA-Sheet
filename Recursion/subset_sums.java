class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ArrayList<Integer> sub = new ArrayList<Integer>();
        generate(arr, N, ans, 0, sub);
        return ans;
        
    }
    
    static void generate(ArrayList<Integer> arr, int N, ArrayList<Integer> ans, int index, ArrayList<Integer> sub){
        
        
        if(index == N){
             int sum = 0;
            for(int c: sub){
                sum += c;
            }
            ans.add(sum);
            return;
        }
        
       
        
        // do not take element
        generate(arr, N, ans, index+1, sub);
        
        // take the element
        sub.add(arr.get(index));
        generate(arr, N, ans, index+1, sub);
        sub.remove(sub.size()-1);
        
    }