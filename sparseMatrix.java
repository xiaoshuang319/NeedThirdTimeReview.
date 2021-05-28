class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowLen = matrix.length, colLen = matrix[0].length;
        int rowStart = 0, rowEnd = rowLen - 1, colStart = 0, colEnd = colLen - 1;
        List<Integer>result = new ArrayList<>();
        
        while(rowStart <= rowEnd && colStart <= colEnd){
            for(int col = colStart; col <= colEnd; col++){
                result.add(matrix[rowStart][col]);
            }
            rowStart++;
       
            for(int row = rowStart; row <= rowEnd; row++){
                 result.add(matrix[row][colEnd]);
            } 
            colEnd--;
            
            if(rowStart <= rowEnd){
                for(int col = colEnd; col >= colStart; col--){
                        result.add(matrix[rowEnd][col]);
                }
            }
            rowEnd--;
            
            if(colStart <= colEnd){
                for(int row = rowEnd; row >= rowStart; row--){
                      result.add(matrix[row][colStart]);
                }
            }
            colStart++;

        }
        return result;
    }
}
