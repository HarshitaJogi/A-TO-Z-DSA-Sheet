class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // we are performing bfs
        
        // queue will store word and its level
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        // making arrayList into set as finding a word in set has O(logn) complexity
        Set<String> st = new HashSet<String>();
        for(int i=0; i<wordList.size(); i++){
            st.add(wordList.get(i));
        }

        // insread of visited array, to mark a word as visited we remove it from the set (it will not be found in set)
        // hance remove beginWord from set
        st.remove(beginWord);

        while(!q.isEmpty()){
            Pair curr = q.poll();
            String word = curr.first;
            int steps = curr.second;

            if(word.equals(endWord) == true) return steps;

            // children of word will be: replace a letter in word by all letters of the alphabet one by one. If
        // we find a word present in set, it is a valid child hence remove from set, increment steps and put in queue.
            // Do this for all letters in the word
            for(int i=0; i<word.length(); i++){

                for(char ch = 'a'; ch<='z'; ch++){
                    // convert 'word' to an array of char
                    char [] replacedCharArray = word.toCharArray();
                    // replace the letter with new letter
                    replacedCharArray[i] = ch;
                    // convert array to the new word
                    String replacedWord = new String(replacedCharArray);

                    // if it exists in the set
                    if(st.contains(replacedWord) == true){
                        // it is a valid child
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps+1));
                    }

                }
            }
        }

        // if conversion not possible
        return 0;

    }

}

class Pair{
    String first;
    int second;
    Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}