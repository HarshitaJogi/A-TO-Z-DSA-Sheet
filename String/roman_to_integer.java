class Solution {
    public int romanToInt(String s) {
        int l = s.length();
        int ans = 0;

        Map<Character, Integer> m = new HashMap<Character, Integer>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);

        for(int i=0; i<l-1; i++){
            char c1 = s.charAt(i);
            char c2 = s.charAt(i+1);

            if(m.get(c1)>=m.get(c2)){
                ans += m.get(c1);
                //System.out.println("added is: " + m.get(c1));
            }
            else{
                ans -= m.get(c1);
                //System.out.println("sub is: " + m.get(c1));
            }
        }

        ans += m.get(s.charAt(l-1));

        return ans;
    }
}