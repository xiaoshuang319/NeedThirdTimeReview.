class Solution {
    public int compress(char[] chars) {
        int newPointer = 0, len = chars.length, index = 0;
        while(index < len){
            char curr = chars[index];
            int count = 1;
            while(index + 1 < len && chars[index + 1] == curr){
                count++;
                index++;
            } //temination: curr  != next
          
            chars[newPointer] = curr;
            newPointer++;
            index++; //move to next.
            if(count != 1){
                for(char c : Integer.toString(count).toCharArray()){
                        chars[newPointer] = c;
                        newPointer++;
                }
            }
        }
        return newPointer;
    }
}
