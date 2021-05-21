class Solution {
    public boolean isNumber(String s) {
        //+3.444e55666
        int len = s.length();
        int idex = 0;
        boolean isDigit = false;
        //remove whitespace
        while(idex < len && Character.isWhitespace(s.charAt(idex))){
            idex++;
        }
      //+/- appear in the front, or after E
        if(idex < len && (s.charAt(idex) == '+' || s.charAt(idex) == '-')){
            idex++;
            if(idex < len && (s.charAt(idex) == '+' || s.charAt(idex) == '-')){
                return false;
            }
        }
      //Digit
        while(idex < len && Character.isDigit(s.charAt(idex))){
            isDigit = true;
             idex++;
        }
      //.1,Digit 
        if(idex < len && s.charAt(idex) == '.'){
            idex++;
            while(idex < len && Character.isDigit(s.charAt(idex))){
                idex++;
                isDigit = true;
            }
        }
      //e: 1)it has digit before and after. 2)only allow one + or -
        if(idex < len && (s.charAt(idex) == 'e' || s.charAt(idex) == 'E') && isDigit){
            idex++;
            isDigit = false;
            if(idex < len && (s.charAt(idex) == '+'  || s.charAt(idex) == '-') ) {
                idex++;
            }
            while(idex < len && Character.isDigit(s.charAt(idex)) ){
                idex++;
                isDigit = true;
            }
        }
        
        return idex == len && isDigit;
    }
}
