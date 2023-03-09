class Solution {
    public String reverseWords(String s) {
        
        String ans = "";
        // String [] words = s.split(" +");

        // for(int i=words.length-1; i>=0; i--){
        //     if(words[i]!= " " && i!=0){
        //         ans += words[i];
        //         ans += " ";
        //     }
        //     else if(words[i] != " " && i==0){
        //         ans += words[i];
        //     }
        // }

        // if(ans.charAt(ans.length()-1) == ' '){
        //     ans = ans.substring(0, ans.length()-2);
        // }
        

        // for(String x: words){
        //     System.out.print("1" + x + " "); 
        // }

        ans = reverse(s);

        return ans;
    }

    static String reverse(String s){
        String [] words = s.split(" +");
        StringBuilder sb = new StringBuilder();
        for(int i=words.length-1; i>=0; i--){
            sb.append(words[i]);
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}