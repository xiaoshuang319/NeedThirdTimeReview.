class Solution {
    public String reverseWords(String s) {
        StringBuilder temp = new StringBuilder();
        removeSpace(temp, s);
       
        reverseSentence(temp, 0, temp.length());
        reverseEachWord(temp);
        return temp.toString();
    }
    private void removeSpace(StringBuilder temp, String s){
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(curr == ' ' && ( i == 0 || (i - 1 >= 0 && s.charAt(i - 1) == ' ')))continue;
            temp.append(curr);
        }
      
        if(temp.charAt(temp.length() - 1) == ' '){
            temp.deleteCharAt(temp.length() - 1);
        }
    }
    private void reverseSentence(StringBuilder temp, int start, int end){
        end--;
        while(start < end){
            char tempChar = temp.charAt(end);
            temp.setCharAt(end, temp.charAt(start));
            temp.setCharAt(start, tempChar);
            start++;
            end--;
        }
    }
    private void reverseEachWord(StringBuilder temp){
        int start = 0;
        for(int end = 0; end <= temp.length(); end++){
            if(end == temp.length() || temp.charAt(end) == ' '){
                reverseSentence(temp, start, end);
                start = end + 1;
            }
        }
    }
    
}
