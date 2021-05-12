class WordDictionary {
    private class Trie{
        Trie[]children = new Trie[26];//因为是字母，所以开辟长度26. children[字母-‘a’]表示的是当前Trie的children里面有没有包含字母。。。
        boolean isWord;
    }
    Trie node;
    /** Initialize your data structure here. */
    public WordDictionary() {
        node = new Trie();
    }
    
    public void addWord(String word) {
         Trie pointer = node;//从node开始
        for(char c : word.toCharArray()){
            if(pointer.children[c - 'a'] == null){//当前node的children 里没有c
                pointer.children[c - 'a'] = new Trie();
            }
            pointer =  pointer.children[c - 'a'];
        }
        pointer.isWord = true;
    }
    
    public boolean search(String word) {
       return findWord(word,0,node);
    }

    private boolean findWord(String word, int index, Trie node){
        if(index == word.length()){
            return node.isWord;//终止条件
        }
        char currentCharacter = word.charAt(index);
        if(currentCharacter != '.'){//如果要找的character不是.
          //判断当前的Trie里收否包含了要找的character以及要找的character 的children里是否包含了下一个character；
            return node.children[currentCharacter - 'a'] != null && findWord(word,index + 1,node.children[currentCharacter - 'a']);
        }else{
            for(int i = 0; i < 26; i++){
              //如果是.的话可以代表任何的character。如果某个children不是null，那就判断这个不是null的children是不是包含了下一个
                if(node.children[i] != null && findWord(word,index + 1,node.children[i])){
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
