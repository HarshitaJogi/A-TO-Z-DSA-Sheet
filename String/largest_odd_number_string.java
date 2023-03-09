class Solution {
    public String largestOddNumber(String num) {

        String ans = "";
        StringBuilder sb = new StringBuilder();
        int index = -1;

        for(int i = num.length()-1; i>=0; i--){
            int x = num.charAt(i) - '0';
            //int x = Integer.parseInt(num.charAt(i));
            if(x%2 != 0){
                index = i;
                System.out.println("index is " + index);
                break;
            }
        }

        if(index == -1) ans = "";
        else{
            ans = num.substring(0, index+1);
        }
        // for(int i=0; i<=index; i++){
        //     String s = "" + num.charAt(i);
        //     ans += s;
        // }

        return ans;
        
    }
}