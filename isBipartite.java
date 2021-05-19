class Solution {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[]color = new int[len];
        for(int i = 0; i < len; i++){ //handle the stand alone graph
            if(color[i] != 0){
                continue;
            }
            Queue<Integer>queue = new LinkedList<>();
            queue.add(i);
            color[i] = 1;
            while(!queue.isEmpty()){
                int curr = queue.poll();
                int paintColor = (color[curr] == 1 ? 2 : 1) ;
                for(int ele : graph[curr]){
                    if(color[ele] == 0){
                        queue.add(ele);
                        color[ele] = paintColor;
                    }else{
                         if(paintColor != color[ele]){
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
//union find
class Solution {
    int[] parent;
    public boolean isBipartite(int[][] graph) {
        int N = graph.length;
        parent = new int[N];
        for(int i = 0; i < N; i++)
            parent[i] = i;
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                if(find(i) == find(graph[i][j]))
                    return false;
                union(graph[i][0], graph[i][j]);
            }
        }
        
        return true;
    }
    
    private int find(int x) {
        while(x != parent[x]){
            x = find(parent[x]);
        }
        return x;
    }
    
    private void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        parent[parentY] = parentX;
    }
}
