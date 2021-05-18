class Solution {
    public String minWindow(String s, String t) {
        int len = s.length();
        Map<Character,Integer>tCharacterToFreq = new HashMap<>();
        for(char c : t.toCharArray()){
            tCharacterToFreq.put(c, tCharacterToFreq.getOrDefault(c,0) + 1);
        }
        int totalCharactesToBeFound = tCharacterToFreq.size();
        int start = 0, end = 0, subLen = Integer.MAX_VALUE, startPos = 0;
        while(end < len){
            char currCharacter = s.charAt(end);
            if(tCharacterToFreq.containsKey(currCharacter)){
                tCharacterToFreq.put(currCharacter,tCharacterToFreq.get(currCharacter) - 1);
                if(tCharacterToFreq.get(currCharacter) == 0){
                    totalCharactesToBeFound--;
                }
            }
            end++;
            while(totalCharactesToBeFound == 0){
                if(subLen > end - start){
                    subLen = end - start;
                    startPos = start;
                }
                char tobedeletedChar = s.charAt(start);
                if(tCharacterToFreq.containsKey(tobedeletedChar)){
                    tCharacterToFreq.put(tobedeletedChar,tCharacterToFreq.get(tobedeletedChar) + 1);
                    if(tCharacterToFreq.get(tobedeletedChar) > 0){
                        totalCharactesToBeFound++;
                    }
                }
                start++;
            }
        
              
            
        }
        return subLen ==  Integer.MAX_VALUE ? "" : s.substring(startPos,startPos + subLen);
    }
}
