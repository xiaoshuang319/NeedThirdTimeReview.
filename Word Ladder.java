class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String>contain = new HashSet<>(wordList);
        Queue<String>queue = new LinkedList<>();
        Set<String>visit = new HashSet<>();
        queue.add(beginWord);
        int level = 1;
        char[]options = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
       
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String curr = queue.poll();
                char[]temp = curr.toCharArray();//巧妙用一个char array
                for(int j = 0; j < temp.length; j++){
                    char a = temp[j];
                    for(char ele : options){
                        temp[j] = ele;
                        String nextEle = String.valueOf(temp);
                        if(contain.contains(nextEle)&& nextEle.equals(endWord)){
                            return level + 1;
                        }
                        if(contain.contains(nextEle) && visit.add(nextEle)){
                            queue.add(nextEle);
                            visit.add(nextEle);
                        }
                    }
                     temp[j] = a;//记得还原
                }
            }
           level++;
        }
        return 0;
      
    }
}
