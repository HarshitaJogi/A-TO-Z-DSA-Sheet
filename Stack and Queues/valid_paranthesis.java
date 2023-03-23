class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();

        int l = s.length();
        boolean ans = true;
        
        
        for(int i=0; i<l; i++){
            char c = s.charAt(i);
            if(c=='(' || c=='[' || c=='{'){
                st.push(c);
            }
            else{
                if(st.isEmpty()==true){
                    ans = false;
                    break;
                }
                char last = st.peek();
                if(last=='(' && c==')') st.pop();
                else if(last=='[' && c==']') st.pop();
                else if(last=='{' && c=='}') st.pop();
                else{
                    ans = false;
                    break;
                }
            }
        }

        if(st.isEmpty() != true) ans = false;
        return ans;
    }
}