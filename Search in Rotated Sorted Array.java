//Search in Rotated Sorted Array.java

//Search in Rotated Sorted Array II.java
class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) /2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[start] == nums[mid]){
                start++;
            }else if(nums[end] == nums[mid]){
                end--;
            }else if(nums[start] < nums[mid]){
                if(nums[start] <= target && target < nums[mid]){
                    end = mid;
                }else{
                    start = mid;
                }
            }else if(nums[mid] < nums[end]){
                if(nums[mid] < target && target <= nums[end]){
                    start = mid;
                }else{
                    end = mid;
                }                
            }
        }
        if(nums[start] == target)return true;
        if(nums[end] == target)return true;
        return false;
    }
}
