class Solution {
    public int beautySum(String s) {

        int n = s.length();
        int ans = 0;

        for(int i=0; i<n; i++){
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            String sub = "";
            for(int j=i; j<n; j++){
                sub += s.charAt(j);
                if(map.containsKey(s.charAt(j))){
                    map.put(s.charAt(j), map.get(s.charAt(j))+1);
                }
                else{
                    map.put(s.charAt(j), 1);
                }

                // System.out.println("substring is " + sub);

                int max = -1;
                int min = 1000;

                for(Map.Entry<Character, Integer> entry: map.entrySet()){
                    int freq = entry.getValue();
                    max = Math.max(max, freq);
                    min = Math.min(min, freq); 
                    // System.out.println(entry.getKey() + " : " + entry.getValue());
                    // System.out.println("freq: " + freq + " max: " + max + " min: " + min);
                }
                if(map.size()>1){
                    ans+= (max - min);
                    // System.out.println("ans: " + ans);
                }

            }
            

        }

        return ans;
        
    }
}