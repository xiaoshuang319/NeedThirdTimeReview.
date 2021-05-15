class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int lenA = firstList.length, lenB = secondList.length;

        int idx1 = 0, idx2 = 0;
        List<int[]>temp = new ArrayList<>();
        while(idx1 < lenA && idx2 < lenB){
            int endA = firstList[idx1][1];
            int startB = secondList[idx2][0];
            int endB =  secondList[idx2][1];
            int startA = firstList[idx1][0];
            if(startA <= endB && startB <= endA){
                int[] intersection = new int[]{Math.max(startA, startB), Math.min(endA, endB)};
                temp.add(intersection);
            }
            if(endA < endB){
                idx1++;
            }else{
                idx2++;
            }
        }
        int[][]result = new int[temp.size()][2];
        int index = 0;
        while(index < temp.size()){
            result[index] = temp.get(index);
            index++;
        }
        return result;
    }
}
