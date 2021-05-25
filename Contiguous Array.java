
class Solution {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        int zeroCount = 0, result = 0;
        Map<Integer,Integer>valueToIndex = new HashMap<>();
        valueToIndex.put(0,-1);
        for(int i = 0; i < len; i++){
            if(nums[i] == 0){
                zeroCount++;
            }
            if(nums[i] == 1){
                zeroCount--;
            }
            if(valueToIndex.containsKey(zeroCount)){
                result = Math.max(result, i - valueToIndex.get(zeroCount) );
            }else{
                valueToIndex.put(zeroCount,i);
            }
        }
        return result;
    }
}
//不能用sliding window

class Solution {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        int start = 0, end = len - 1,zeroCount = 0, result = 0;
        while(end < len){
            zeroCount += nums[end] == 0 ? -1 : 1;
            while(zeroCount != 0 && start <= end){ //不能确定window什么时候开始移动
                zeroCount += nums[start] == 0 ? -1 : 1;
                start++;
            }
            end++;
            if(zeroCount == 0){
                result = Math.max(result, end - start);
            }
        }
        return result;
    }
}
