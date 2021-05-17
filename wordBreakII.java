class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String>contain = new HashSet<>(wordDict);
        Map<Integer,List<String>>path = new HashMap<>();

  
        return  dfs(s,path,contain,0);
    }
    private List<String> dfs(String s, Map<Integer,List<String>>path, Set<String>contain,int start){
         List<String>result = new ArrayList<>();
        if(start == s.length()){
            result.add("");
            return result;
        }
        if(path.containsKey(start)){
            return path.get(start);
        }
        for(int i = start; i <= s.length(); i++){
             String curr =  s.substring(start, i);
            if(contain.contains(curr)){
                List<String>temp = dfs(s,path,contain,i);
                for(String ele : temp){
                    result.add(curr + (ele.length() == 0 ? "" : " ") + ele);
                }
            }
        }
        path.put(start,result);
        return result;
    }
}
