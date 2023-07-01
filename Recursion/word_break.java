class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

            // putting worddict in a hashset to find word with lesser time
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<wordDict.size(); i++){
            set.add(wordDict.get(i));
        }

        // dp[i] means no of sentences that can be made using wordDict at index i.
        int [] dp = new int [n];

        for(int i=0; i<n; i++){
            // forms word of s from j to i
            for(int j=0; j<=i; j++){
                String wordToCheck = s.substring(j, i+1);

                // if it is a word in wordDict
                if(set.contains(wordToCheck)){
                    // for words with index 1 onwards, i.e. for words with index 1,2,... to i onwards
                    if(j>0){
                        dp[i] += dp[j-1];  
                    }
                    // if entire word from 0 to i is in wordDict, simply increment dp[i] by 1
                    else{
                        dp[i] += 1;
                    }
                }
            }
        }

        if(dp[n-1] > 0) return true;
        else return false;

    }

}