class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
       UnionFind uf = new UnionFind();
       Map<String,String>emailToName = new HashMap<>();
       Map<String,Integer>emailToID = new HashMap<>();
       int index = 0;
//             for(List<String> ele : accounts){
//               String name = ele.get(0);
//               String email = "";
//               for(int i = 1; i < ele.size(); i++){
//                   email = ele.get(i);
//                   emailToName.putIfAbsent(email, name);  
//                   if(!emailToID.containsKey(email)){
//                     emailToID.put(email, index);
//                     index++;
//                 }
//                 dsu.union(emailToID.get(ele.get(1)),emailToID.get(email));
//               }
//           }
        
        
       for(List<String> ele : accounts){
           String name = ele.get(0);
           String emailElement = "";
           for(int i = 1; i < ele.size(); i++){
              emailElement =   ele.get(i);
               if(!emailToName.containsKey(emailElement)){
                   emailToName.put(emailElement,name);
               }
               if(!emailToID.containsKey(emailElement)){
                   emailToID.put(emailElement,index);
                   index++;
               }
            
               uf.union(emailToID.get(ele.get(1)),emailToID.get(emailElement));
           }
       }
         
       Map<Integer,List<String>>ans = new HashMap<>();
       for(String email : emailToID.keySet()){
           int rootId = uf.find(emailToID.get(email));
           if(ans.containsKey(rootId)){
               ans.get(rootId).add(email);
           }else{
               List<String>temp = new ArrayList<>();
               temp.add(email);
               ans.put(rootId,temp);
           }
       }
          // Map<Integer,List<String>>ans = new HashMap<>();
          // for(String ele : emailToID.keySet()){
          //     int rootId = uf.find(emailToID.get(ele));
          //     ans.computeIfAbsent(rootId, x -> new ArrayList<>()).add(ele);
          // }
       for(List<String> ele : ans.values()){
              Collections.sort(ele);
              ele.add(0,emailToName.get(ele.get(0)));
         }
        
        
      return new ArrayList<>(ans.values());
    }
    private class UnionFind{
    int[]marker = new int[10001];
    public UnionFind(){
      for(int i = 0; i <= 10000; i++){
        marker[i] = i;
      }
    }
    private int find(int x){
        if(marker[x] != x){
            marker[x] = find(marker[x]);
        }
        return marker[x];
    }
    private void union(int x, int y){
        int parentX = find(x);
        int parentY = find(y);
        if(parentX != parentY){
            marker[parentX] = parentY;
        }
    }
  }
    
    //    private class UnionFind{
    //     int[] mark = new int[10001];
    //     public UnionFind(){
    //         for(int i = 0; i < mark.length; i++){
    //             mark[i] = i;
    //         }
    //     }
    //     private int find(int x){
    //         if(x != mark[x]){
    //             mark[x] = find(mark[x]);
    //         }
    //         return mark[x];
    //     }
    //    private void union(int x, int y){
    //        int parentX = find(x);
    //        int parentY = find(y);
    //        if(parentX != parentY){
    //            mark[parentX] = parentY;
    //        }
    //    }
    // }
}
