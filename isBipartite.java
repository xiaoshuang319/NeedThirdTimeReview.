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
