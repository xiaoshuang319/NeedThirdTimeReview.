class Solution {
    public int shortestDistance(int[][] grid) {
        int rowLen = grid.length, colLen = grid[0].length;
        int[][]numLevel = new int[rowLen][colLen];
        int[][]numReach = new int[rowLen][colLen];
        int countOfBuildings = 0;
        int[][]directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int i = 0; i < rowLen; i++){
            for(int j = 0; j < colLen; j++){
                if(grid[i][j] == 1){
                    bfs(grid,numLevel,numReach,i,j,directions);
                    countOfBuildings++;
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < rowLen; i++){
            for(int j = 0; j < colLen; j++){
                if(grid[i][j] == 0 && numReach[i][j] == countOfBuildings){
                    result = Math.min(result,numLevel[i][j]);
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
  
    
    
    private void bfs(int[][]grid, int[][]numLevel, int [][]numReach, int row, int col, int[][]directions){
      int rowLen = grid.length, colLen = grid[0].length;
        boolean[][]visit = new boolean[rowLen][colLen];
        Queue<int[]>queue = new LinkedList<>();
        queue.add(new int[]{row,col});
        int level = 1;
        visit[row][col] = true;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[]curr = queue.poll();
                for(int[] ele : directions){
                    int nextRow = curr[0] + ele[0];
                    int nextCol = curr[1] + ele[1];
                    if(nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length || visit[nextRow][nextCol] || grid[nextRow][nextCol] != 0){
                        continue;
                    }
                    visit[nextRow][nextCol] = true;
                    numLevel[nextRow][nextCol] += level;
                    numReach[nextRow][nextCol]++;
                    queue.add(new int[]{nextRow,nextCol});
                   
                }
            }
            level++;
        }
    }
}
