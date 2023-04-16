class Solution {
  public static List<String> generateBinaryStrings(int n) {
    // code here
    List< String> ans = new ArrayList<String>();
    String sub = "";
    for(int i=0; i<n; i++){
        sub += '0';
    }
    generate(0, sub, n, ans);
    return ans;

  }
  
  static void generate(int index, String sub, int n, List<String>ans){
      
      if(index >= n){
           ans.add(sub);
           return;
      } 
      
      // do not make index 1:
      generate(index+1, sub, n, ans);
      
      // make index 1:
      sub = sub.substring(0, index) + '1' + sub.substring(index+1);
      generate(index+2, sub, n, ans);
       sub = sub.substring(0, index) + '0' + sub.substring(index+1);
  }
}
