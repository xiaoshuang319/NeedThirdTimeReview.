class Solution {
    public boolean isMatch(String s, String p) {
       
        //case1: p.charAt(i) == s.charAt(j) 
        //caase2: p.charAt(i) == '.' => dp[i][j] = dp[i-1][j-1];
        //case3: p.charAt(i) == '*'
                //1.s:XXXXA p:~~~B* => p.charAt(i - 1) != s.charAt(j) && p.charAt(i - 1) !='.' =>dp[i][j] = dp[i][j-2]
                //2. p.charAt(i - 1) == s.charAt(j) || p.charAt(i - 1) =='.'
                //2.1 p.charAt(i - 1): s:XXXXA p:~~~A*   counted once => dp[i][j] = dp[i-1][j-2]
                //2.2 p.charAt(i-1): counted empty  dp[i][j] = dp[i][j-2]
                 //2.3 p.charAt(i-1): counted multiple dp[i][j] = dp[i-1][j]
       int sLen = s.length(), pLen = p.length();
       boolean[][]dp = new boolean[sLen + 1][pLen + 1]; //因为看的是长度，所以加1
        dp[0][0] = true;
        for(int i = 2; i <= pLen; i += 2){ //要保证偶数位置上的是*
            dp[0][i] = p.charAt(i - 1) == '*' && dp[0][i - 2]; // i- 1 无所谓，因为要ignore
        } 
        for(int i = 1; i <= sLen; i++){
            for(int j = 1;j <= pLen; j++){
                char currP = p.charAt(j - 1);
                char currS = s.charAt(i - 1);
                if(currP == currS || currP == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(currP == '*'){
                    char preCurP = p.charAt(j - 2);
                    if(currS != preCurP && preCurP != '.'){
                        dp[i][j] = dp[i][j-2];
                    }else{
                         dp[i][j] = ( dp[i-1][j-2] || dp[i][j-2] || dp[i-1][j]);
                                                            
                    }
                 }
            }
        }
        return dp[sLen][pLen];
       
        
    }
}
