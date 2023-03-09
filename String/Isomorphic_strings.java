class Solution {
    public boolean isIsomorphic(String s, String t) {

        int [] m1 = new int [256];
        int [] m2 = new int [256];
        Arrays.fill(m1, 0);
        Arrays.fill(m2, 0);

        for(int i=0; i<s.length(); i++){
            int x = s.charAt(i);
            int y = t.charAt(i);
            if(m1[x] != m2[y]){
                return false;
            }
            m1[x] = i+1;
            m2[y] = i+1;
        }
        return true;
        
        // boolean ans = true;
        
        // int s_l = s.length();
        // int t_l = t.length();

        // if(s_l != t_l) ans = false;
        // else{

        //     // for s
        //     Map <Character, Integer> ms = new HashMap<Character, Integer>();
        //     for(int i=0; i<s_l; i++){
        //         if(ms.containsKey(s.charAt(i))){
        //             ms.put(s.charAt(i), ms.get(s.charAt(i))+1);
        //         }
        //         else{
        //             ms.put(s.charAt(i), 1);
        //         }
        //     }

        //     // for t
        //     Map <Character, Integer> mt = new HashMap<Character, Integer>();
        //     for(int i=0; i<t_l; i++){
        //         if(mt.containsKey(t.charAt(i))){
        //             mt.put(t.charAt(i), mt.get(t.charAt(i))+1);
        //         }
        //         else{
        //             mt.put(t.charAt(i), 1);
        //         }
        //     }

        //     int [] s_arr = new int [s_l];
        //     for(int i=0; i<s_l; i++){
        //         char c = s.charAt(i);
        //         s_arr[i] = ms.get(c);
        //     }

        //     int [] t_arr = new int [t_l];
        //     for(int i=0; i<t_l; i++){
        //         char c = t.charAt(i);
        //         t_arr[i] = mt.get(c);
        //     }

        //     for(int i=0; i<s_l; i++){
        //         if(s_arr[i] != t_arr[i]){
        //             ans = false;
        //             break;
        //         }
        //     }
        // }

        
        // return ans;

    }
}