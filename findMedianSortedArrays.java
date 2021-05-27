class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //(len + 1) / 2 :  there are total (len + 1) / 2 inclusive before this position
        //               : median number starting position
        //
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1 > len2){
            return findMedianSortedArrays(nums2,nums1);
        }
        int half = (len1 + len2 + 1) / 2; 
        boolean even = (len1 + len2) % 2 == 0 ? true : false;
        int start = 0;
        int end = len1;
        int apart = 0;
        int bpart = 0;
        while(start <= end){
            apart = (start + end) / 2;//这是表示1）从第几个数字开始cut 2）前面有几个数字
            bpart = half - apart;
            
            if(apart > start && nums1[apart - 1] >nums2[bpart]){
                end = apart - 1;
            }else if(apart < end && nums1[apart] < nums2[bpart - 1]){
                start = apart + 1;
            }else{
                int leftMax = 0;
                if(apart == 0){
                    leftMax = nums2[bpart - 1];      
                }else if(bpart == 0){
                     leftMax = nums1[apart - 1];  
                }else{
                    leftMax = Math.max(nums1[apart - 1],nums2[bpart - 1]);
                }
                if(!even)return leftMax;
              
                int rightMin = 0;
                if(apart == len1 ){
                    rightMin = nums2[bpart];//  0,1,2 // 3,4,5,6
                }else if(bpart == len2){
                    rightMin = nums1[apart];
                }else{
                    rightMin = Math.min(nums1[apart],nums2[bpart]);
                }
                
                return (leftMax + rightMin) * 1.0 / 2;
            }
        }
        return 0;
        
    }
}
