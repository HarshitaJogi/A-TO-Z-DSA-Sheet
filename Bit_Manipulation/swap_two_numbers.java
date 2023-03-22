
class Solution{
    static List<Integer> get(int a,int b)
    {
        List<Integer> ans = new ArrayList<Integer>();
        // ans.add(b);
        // ans.add(a);
        
        // a = (a^b)^a;
        // b = (b^a)^b;
        
        a = a^b;
        b = b^a;
        a = a^b;
        
        ans.add(a);
        ans.add(b);
        
        return ans;
    }
}