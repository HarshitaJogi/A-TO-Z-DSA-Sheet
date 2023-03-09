class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        String ans = "";
        int n = strs.length;

        int min = Integer.MAX_VALUE;
        for(String st: strs){
            min = Math.min(min, st.length());
        }
        System.out.println(min);

        String c = "";
        for(int i=0; i<min; i++){
            boolean add = true;
            for(int j=0; j<n-1; j++){
                if(strs[j].charAt(i) != strs[j+1].charAt(i)){
                    System.out.println(strs[j].charAt(i));
                    //c = "" + strs[j].charAt(i);
                    add = false;
                }
            }
            if(add == true){
                ans += strs[0].charAt(i);
            }
            else{
                break;
            }
            
        }
        return ans;
    }
}