class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper(n,n);
    }
    private List<String> helper(int n, int currLen){
          if(n == 0){
            List<String>temp = new ArrayList<>();
             temp.add("");
            return temp;   
        }
        if(n == 1){
            List<String>temp = new ArrayList<>();
            temp.add("0");
            temp.add("1");
            temp.add("8");
            return temp;
        }
      
        List<String>temp = helper(n - 2,currLen);
        List<String>res = new ArrayList<>();
        for(String ele : temp){
            if(currLen != n){
              res.add("0" + ele + "0");
            }
           res.add("1" + ele + "1");
           res.add("6" + ele + "9");
           res.add("8" + ele + "8");
           res.add("9" + ele + "6");
        }
        return res;
    }
}
