class Solution {
    static List<String> ans = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {

        String sub = "";
        ans.clear();
        generate(sub, n, n);
        return ans;
        
    }

    static void generate(String sub, int open, int close){

        
        if(open == 0 && close == 0){
            ans.add(sub);
            return;
        }
        
        if(open > 0){
            sub += '(';
            generate(sub, open-1, close);
            sub = sub.substring(0, (sub.length()-1));
        }

        if(close > 0){
            if(open < close){
                sub += ')';
                generate(sub, open, close-1);
                sub = sub.substring(0, (sub.length()-1));
            }
        }
    }
}