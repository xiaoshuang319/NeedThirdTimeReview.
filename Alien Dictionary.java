class Solution {
    public String alienOrder(String[] words) {
        //topological sort + graph(BFS iterating graph)
        //record indegree for each character, 
        //initialize queue with indegree = 0;for example w
        //BFS all the children of w and degree children's indegree by 1. 
        //if it is 0, then add current children to result, as well queue unitll the queue is empty.
        //end: compare result.length() with graph
        //graph handle unique case [z,z,z]
        int[]indegree = new int[26];
        Map<Character,Set<Character>>meToChildren = new HashMap<>();
        for(String word : words){
            for(char c : word.toCharArray()){
                if(!meToChildren.containsKey(c)){
                    meToChildren.put(c, new HashSet<>());
                }
            }
        }
        int len = words.length;
        StringBuilder result = new StringBuilder();
        for(int i = 1; i < len; i++){
            String pre = words[i - 1];
            String curr = words[i];
            int minLen = Math.min(pre.length(), curr.length());
            int idx1 = 0, idx2 = 0;
            while(idx1 < minLen && idx2 < minLen){
                char preC = pre.charAt(idx1);
                char currC = curr.charAt(idx2);
                if(preC != currC){
                     if(meToChildren.get(preC).add(currC)){ //in case ac->ab, zc->zb:一对pair出现多次
                           indegree[currC - 'a']++;  
                     }
                     meToChildren.get(preC).add(currC);
                     break;
                }
                idx1++;
                idx2++;
                //空是小于任何字母abc -> ab
                if(idx1 < pre.length() && idx2 == curr.length()){
                    return "";
                }
            }
            
        }
        Queue<Character>queue = new LinkedList<>();
        for(char key : meToChildren.keySet()){ 
            if(indegree[key - 'a'] == 0){
                queue.add(key);
                result.append(key);
            }
        }
       while(!queue.isEmpty()){
           int size = queue.size();
           for(int i = 0; i < size; i++){
               char curr = queue.poll();
               for(char key : meToChildren.get(curr)){
                     indegree[key - 'a']--;
                     if(indegree[key - 'a'] == 0){
                       queue.add(key);
                       result.append(key);
                      
                     }
                }   
           }
       }
    
        return result.length() == meToChildren.size() ? result.toString() : "";
    
    }
}
