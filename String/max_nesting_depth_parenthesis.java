class Solution {
    public int maxDepth(String s) {
        int l = s.length();
        Stack<Character> st = new Stack<Character>();
        int depth = 0;
        int max = 0;

        for(int i=0; i<l; i++){
            if(s.charAt(i) == '('){
                st.push(s.charAt(i));
                System.out.println("depth is: " + depth);
                depth = depth + 1;
                max = Math.max(max, depth);
            }
            else if(s.charAt(i) == ')'){
                st.pop();
                depth = depth - 1;
            }
        }

        return max;
    }
}