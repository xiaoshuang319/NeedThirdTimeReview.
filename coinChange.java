class Solution {
    public int coinChange(int[] coins, int amount) {
        //dp[i] : the minum coin need to make up amout i;
        //dp[i] = Math.min(dp[i], dp[ i - corn]);
        int[]dp = new int[amount + 1];
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int coin : coins){
                if(i < coin)continue;
                dp[i] = Math.min(dp[i],dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
