class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int p1 = g.length-1;
        int p2 = s.length-1;

        int ans = 0;

        while(p1>=0 && p2>=0){
            if(s[p2] >= g[p1]){
                ans++;
                p1--;
                p2--;
            }

            else{
                p1--;
            }
        }

        return ans;
    }
}
