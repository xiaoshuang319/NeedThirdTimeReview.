class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0, end = arr.length - k;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(x > arr[mid]){
                if(x - arr[mid] > arr[mid + k] - x){
                    start = mid + 1;
                }else{
                    end = mid;
                }
            }else{
                end = mid;
            }
        }
        List<Integer>result = new ArrayList<>();
        int index = start;
        while(k > 0){
            result.add(arr[index]);
            index++;
            k--;
        }
        return result;
    }
}
