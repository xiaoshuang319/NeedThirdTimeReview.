class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character,Character>strobogrammatic = new HashMap<>();
        strobogrammatic.put('6','9');
        strobogrammatic.put('9','6');
        strobogrammatic.put('8','8');
        strobogrammatic.put('1','1');
        strobogrammatic.put('0','0');
        int len = num.length();
        int left = 0, right = len - 1;
        while(left <= right){
            if(!strobogrammatic.containsKey(num.charAt(left)) || strobogrammatic.get(num.charAt(left)) != num.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
