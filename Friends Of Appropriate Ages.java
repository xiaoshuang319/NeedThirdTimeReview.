class Solution {
    //we need to find the range.
    //B valid range is (1/2 * A + 7, A]
    //binarySearch to find the last element <= 1/2 * A + 7 => lower
    //binarySearch to find the last element <= A =>upper
    //count the number of element in betewee by (upper - 1) - lower + 1 - 1 (exclude element itselft)
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int result = 0;
        for(int age : ages){
            int lower = findIndex(ages,(age * 1 / 2 ) + 7);
            int upper = findIndex(ages,age);
            result += Math.max(upper - lower - 1,0);
        }
        
        return result;
    }
    private int findIndex(int[]ages, int target){
        int start = 0, end = ages.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(ages[mid] <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start;
    }
}

  



// class Solution {
//     public int numFriendRequests(int[] ages) {
//         int res = 0;
//         Arrays.sort(ages);
//         for (int i = 0; i < ages.length; ++i) {
//             int age = ages[i];
//             int lower = firstIdx(ages, age/2+7);
//             int upper = firstIdx(ages, age);
//             res += Math.max(upper-lower-1, 0);
//         }
//         return res;
//     }
    
//     private static int firstIdx(int[] ages, int target) {
//         int beg = 0;
//         int end = ages.length-1;
//         while (beg <= end) {
//             int mid = beg + (end-beg)/2;
//             if (ages[mid] <= target) beg = mid + 1;
//             else end = mid - 1;
//         }
//         return beg;
//     }
// }
