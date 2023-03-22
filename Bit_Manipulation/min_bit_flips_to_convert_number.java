class Solution {
    public int minBitFlips(int start, int goal) {

        int xor = start^goal;
        int cnt = 0;

        for(int i=0; i<31; i++){
            if(((xor>>i)&1)!=0) cnt++;
        }

        return cnt;

    }
}