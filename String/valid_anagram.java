class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()) return false;
        
        int [] arr = new int [26];
        for(int i=0; i<s.length(); i++){
            int index = s.charAt(i) - 'a';
            arr[index] += 1;
        }

        for(int i=0; i<t.length(); i++){
            int index = t.charAt(i) - 'a';
            arr[index] -= 1;
        }

        for(int i=0; i<arr.length; i++){
            if(arr[i]!=0) return false;
        }

        return true;
    }
}