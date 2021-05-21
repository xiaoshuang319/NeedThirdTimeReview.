class Solution {
    public int[] searchRange(int[] nums, int target) {
       int startPos = binarySearch(nums,target - 1);
       int endPos = binarySearch(nums,target);
        if(startPos == endPos){
            return new int[]{-1,-1}; //找不到的情况
        }
       return new int[]{startPos + 1,endPos};
    }
    private int binarySearch(int[]nums, int target){
        int start = 0, end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return end;
    }
}
