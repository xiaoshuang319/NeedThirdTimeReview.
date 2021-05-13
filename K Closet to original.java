//method2: quicksort
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][]result = new int[k][2];
        QuickSort(points,k, 0, points.length - 1);
        for(int i = 0; i < k; i++){
            result[i] = points[i]; 
        }
        return result;
    }
    private void QuickSort(int[][]input, int k, int start, int end){
        if(start > end){
            return;
        }
        int pivotIndex = partition(input, start, end);
        int numberOfEle = pivotIndex - start + 1;
        if(numberOfEle == k){
            return;
        }else if(numberOfEle < k){
            QuickSort(input,k - numberOfEle, pivotIndex + 1, end); //less than k,再找剩余的k - numberOfEle
        }else{
             QuickSort(input,k, start, pivotIndex - 1);
        }
    }
    private int partition(int[][]input, int start, int end){
        int left = start - 1, pivotIndex = end;
        for(int i = start; i < end; i++){
            if(getDistance(input[i]) <= getDistance(input[pivotIndex])){
                left++;
                int[]temp = input[left];
                input[left] = input[i];
                input[i] = temp;
            }
        }
          int[]temp = input[left + 1];
          input[left + 1] = input[pivotIndex];
          input[pivotIndex] = temp;
          return left + 1;
    }
    private double getDistance(int[]input){
        return input[0] * input[0] + input[1] * input[1];
    }
    
}

//Kth Largest Element in an Array

class Solution {
    public int findKthLargest(int[] nums, int k) {
      return partition(nums, 0, nums.length - 1, k);
    }
 
    private int partition(int[]nums, int start, int end, int k){
        int left = start - 1, peekIndex = end;
        for(int i = start; i < end; i++){
            if(nums[i] < nums[peekIndex]){
                left++;
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
            }
        }
        int temp = nums[left + 1];
        nums[left + 1] =  nums[peekIndex];
        nums[peekIndex] = temp;
        
        int count = end - left;
        if(count == k) return nums[left + 1];
        if(count < k){//reduce pivot value
           return partition(nums, start, left, k - count);//made mistaken
        }else{ //increase pivot value
           return partition(nums, left + 2, end, k);
        }
    }
}
