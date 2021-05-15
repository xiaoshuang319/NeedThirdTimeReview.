class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String,List<String>>patternToString = new HashMap<>();
        for(String ele : strings){
            String pattern = findPattern(ele);
            if(patternToString.containsKey(pattern)){
               patternToString.get(pattern).add(ele);
            }else{
                List<String>list = new ArrayList<>();
                list.add(ele);
                patternToString.put(pattern, list);
            }
        }
        List<List<String>>result = new ArrayList<>();
        for(List<String>ele : patternToString.values()){
            result.add(ele);
        }
        return result;
    }
    private String findPattern(String ele){
        int len = ele.length();
        //empty
         if(len == 0){
             return "";
         }
        //one character
        if(len == 1){
            return ",";
        }
        StringBuilder pattern = new StringBuilder();
        for(int i = 0; i + 1 < len; i++){
            int diff = ele.charAt(i + 1) - ele.charAt(i);
            //negative
            if(diff < 0){
                diff += 26;
            }
            pattern.append(diff);
             pattern.append(',');
        }
        return pattern.toString();
       
    }
}
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>>result = new ArrayList<>();
        Map<String,List<String>>patternToGroup = new HashMap<>();
        for(String ele : strs){
            String pattern = getPattern(ele);
            if(patternToGroup.containsKey(pattern)){
                patternToGroup.get(pattern).add(ele);
            }else{
                List<String>temp = new ArrayList<>();
                temp.add(ele);
                patternToGroup.put(pattern,temp);
            }
        }
       for(List<String>ele : patternToGroup.values()){
           result.add(ele);
       }
       return result;
    }
    private String getPattern(String input){
        char[]count = new char[26];
        StringBuilder pattern = new StringBuilder();
        for(char c : input.toCharArray()){
            count[c - 'a']++;
        }
        for(char c : count){
            pattern.append(c);
            pattern.append("#");
        }
        return pattern.toString();
    }
}
