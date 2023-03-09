class Solution {
    public boolean rotateString(String s, String goal) {
        
        if(s.length() != goal.length()) return false;
        
        // logic: if goal is a substing of s+s, then goal is a rotated string of s else not
        
        String s2 = "";
        s2 += s;
        s2 += s;

        int index = -1;
        index = s2.indexOf(goal);
        if(index == -1) return false;

        return true;
    }
}