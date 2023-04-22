class Solution {
    static String [] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    static List<String> ans = new ArrayList<String>();
    public List<String> letterCombinations(String digits) {

        ans.clear();

        int n = digits.length();

        List<String> matrix = new ArrayList<String>();

        for(int i=0; i<digits.length(); i++){
            int num = digits.charAt(i) - '0';
            matrix.add(phone[num]);
        }

        String curr = "";

        generate(0, curr, matrix);

        return ans;  
    }

    static void generate(int index, String curr, List<String> matrix){

        if(index == matrix.size()){
            if(curr.length()>0){
                ans.add(curr);
            }
            
            return;
        }

        String s = matrix.get(index);
        int l = s.length();


        for(int i=0; i<l; i++){
            curr += s.charAt(i);
            generate(index+1, curr, matrix);
            curr = curr.substring(0, curr.length()-1);
        }
    }
}