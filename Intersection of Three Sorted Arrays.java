class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int idx1 = 0, idx2 = 0, idx3 = 0;
        List<Integer>result = new ArrayList<>();
        while(idx1 < arr1.length && idx2 < arr2.length && idx3 < arr3.length){
            int min = Math.min(Math.min(arr1[idx1], arr2[idx2]),arr3[idx3]);
            if(arr1[idx1] == min && arr2[idx2] == min && arr3[idx3] == min){
                result.add(min);
             
            }
            if(arr1[idx1] == min){
                idx1++;
            }
            if(arr2[idx2] == min){
                idx2++;
            } 
            if(arr3[idx3] == min){
                idx3++;
            }             
        }
        return result;
        
    }
}
