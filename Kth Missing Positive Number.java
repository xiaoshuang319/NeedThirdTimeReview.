class Solution {
    public int findKthPositive(int[] arr, int k) {
        //in order to get Kth misssing elemement:
        //step1: we can get the last position which missing eleement is less than k, let us use pos repents  last position
        //step2: pos + 1(actaul number), before it, there are arr[pos] - (pos + 1) missing element, then, we only need to get the number of k - (arr[pos] - (pos + 1))
        int start = 0, end = arr.length - 1;
        int pos = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] -(mid + 1) < k){
                pos = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return pos + 1 + k;
    }
}
