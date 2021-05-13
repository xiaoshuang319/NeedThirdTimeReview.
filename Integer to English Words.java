class Solution {
        //1-20
        private final String[] LESS_THAN_TWENTIES = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        //10,20,30,~,90
       private final String[] TENS = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    public String numberToWords(int num) {
       
        if(num == 0)return "Zero";
      
        return helper(num);
    }
    private String helper(int num){
        String res = "";
        if(num < 20){ //case 1: less than 20
            res = LESS_THAN_TWENTIES[num];
        }else if(num < 100){ //case 2 : less than 100
             res = TENS[num / 10] + " " + LESS_THAN_TWENTIES[num % 10];
        }else if(num < 1000){ //case3: less than 1000 
            res = LESS_THAN_TWENTIES[num / 100] + " Hundred " + helper(num % 100);
        }else if(num < 1000000){ //case4: less than 10^6 34345
            res = helper(num / 1000) + " Thousand " + helper(num % 1000);
        }else if(num < 1000000000){ //case5: less than 10^9
            res = helper(num / 1000000) + " Million " + helper(num % 1000000);
        }else{
            res = helper(num / 1000000000) + " Billion " + helper(num % 1000000000);
        }
        return res.trim(); 
    }
    
}



