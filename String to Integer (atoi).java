class Solution {
    public int myAtoi(String s) {
        if(s == null || s.length() == 0)return 0;
        int index = 0;
        int signal = 1;
        while(index < s.length() &&Character.isWhitespace(s.charAt(index)) ){
             index++;
        }
      //"+-12" if else， 不能用两个if if。。。。
        if(index < s.length() && s.charAt(index) == '+'){
                signal=1;
                index++;
        }else if(index < s.length() && s.charAt(index) == '-'){
                signal=-1;
                index++;
        }
        long sum = 0;
        while(index < s.length()){
            if(!Character.isDigit(s.charAt(index))){
                return (int)(sum * signal);  
            }
            sum = sum * 10 + ( s.charAt(index) - '0');
            if(signal == 1 && sum >= Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(signal == -1 && -1 * sum <= Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            } 
            index++;
        }
        return(int) (sum * signal);
        
    }
}
