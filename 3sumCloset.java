class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int sum = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < len; i++){
            int start = i + 1, end = len - 1;
            while(start + 1 <= end){
                int tempSum = nums[i] + nums[start] + nums[end];
                
                if(Math.abs(tempSum - target) <= Math.abs(sum - target)){
                     sum = tempSum;
                }
                if(tempSum > target){
                    end--;
                }else if(tempSum < target){
                    start++;
                }else{
                    return target;
                }
            }
        }
        return sum;
    }
}
