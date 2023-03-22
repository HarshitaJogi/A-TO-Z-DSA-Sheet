
class Solution {
    public static int findXOR(int l, int r) {
        
        // for xor from 1 to l-1:
        int ans1 = 0;
        if(((l-1)%4)==0){
            ans1 = l-1;
        }
        else if(((l-1)%4)==1){
            ans1 = 1;
        }
        else if(((l-1)%4)==2){
            ans1 = (l-1)+1;
        }
        else{
            ans1 = 0;
        }
        
        // for xor from 1 to r:
        int ans2 = 0;
        if(((r)%4)==0){
            ans2 = r;
        }
        else if(((r)%4)==1){
            ans2 = 1;
        }
        else if(((r)%4)==2){
            ans2 = (r)+1;
        }
        else{
            ans2 = 0;
        }
        
        int ans = ans1^ans2;
        return ans;
    }
}