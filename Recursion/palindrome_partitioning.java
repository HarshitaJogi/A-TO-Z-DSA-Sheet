class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> sub = new ArrayList<>();

        func(0, ans, s, sub);
        return ans;
    }

    static void func(int ind, List<List<String>> ans, String s, List<String> sub){
        if(ind == s.length()){
            ans.add(new ArrayList<>(sub));
            return;
        }

        String temp = "";

        for(int i=ind; i<s.length(); i++){
            temp += s.charAt(i);
            if(isPalindrome(temp) == true){
                sub.add(temp);
                func(i+1, ans, s, sub);
                sub.remove(sub.size()-1);
            }
        }
    }

    static boolean isPalindrome(String s){
        String rev = "";
        for(int i=s.length()-1; i>=0; i--){
            rev += s.charAt(i);
        }
        if(rev.equals(s)) return true;
        else return false;
    }
}