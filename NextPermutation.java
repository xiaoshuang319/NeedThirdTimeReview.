class Solution {
    public void nextPermutation(int[] nums) {
        //iterate from end to start such sthat nums[i - 1] < nums[i] => there is a replacement we can use to replace nums[i-1], otherwise, the biggest element is always at the highest level.
        //order the number after pos in acesnding
        int len = nums.length;
        int peekIndex = -1;
      
        for(int i = len - 1; i>= 0; i--){
            if(i> 0 && nums[i - 1] < nums[i]){
                peekIndex = i - 1;
                break;
            }
        }
        if(peekIndex == -1){
            int start = 0, end = len - 1;
            while(start < end){
                int temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
                end--;
                start++;
            }
        }else{
             for(int j = len - 1; j > peekIndex; j--){
               if(nums[j] > nums[peekIndex]){
                   int temp = nums[peekIndex];
                   nums[peekIndex] = nums[j];
                   nums[j] = temp;
                   break;
               }
           }
            int start = peekIndex + 1, end = len - 1;
            while(start < end){
                int temp1 = nums[end];
                nums[end] = nums[start];
                nums[start] = temp1;
                end--;
                start++;
            }
        }
    }
}
