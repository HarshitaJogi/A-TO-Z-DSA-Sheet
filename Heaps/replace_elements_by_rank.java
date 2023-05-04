class Solution {
    static int[] replaceWithRank(int arr[], int N) {
     // code here
    //  PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<ArrayList<Integer>>();
     
    //  for(int i=0; i<arr.length; i++){
    //      ArrayList<Integer> l = new ArrayList<Integer>();
    //      l.add(arr[i]);
    //      l.add(i+1);
    //      pq.add(l);
    //  }
     
    //  int [] ans = new int [arr.length];
     
    //  int index = 0;
    //  while(!pq.isEmpty()){
    //      ArrayList<Integer> li = pq.peek();
    //      int x = li.get(1);
    //      arr[index] = x;
    //      index++;
    //      pq.poll();
    //  }
     
    //  return arr;
    
    int [] nums = new int [arr.length];
    for(int i=0; i<N; i++){
        nums[i] = arr[i];
    }
    
    Arrays.sort(nums);
    
    HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
    
    int ind = 1;
    for(int i=0; i<nums.length; i++){
        if(m.containsKey(nums[i])){
            // dont do anything
        }
        else{
            m.put(nums[i], ind);
            ind++;
        }
    }
    
    int [] ans = new int [arr.length];
    
    for(int i=0; i<N; i++){
        int x = arr[i];
        int num = m.get(x);
        ans[i] = num;
    }
    
    return ans;

  }
}