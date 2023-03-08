class Solution {
    public String removeOuterParentheses(String s) {
        String ans = "";
        int l = s.length();
        Stack<Character> st = new Stack<Character>();

        for(int i=0; i<l; i++){

            if(!st.isEmpty()){
                ans += s.charAt(i);
            }
            if(s.charAt(i) == '('){
                st.push(s.charAt(i));
            }
            else{
                st.pop();
                if(st.isEmpty()){
                    ans = ans.substring(0, ans.length()-1);
                }
            }
        }
        return ans;
    }
}
