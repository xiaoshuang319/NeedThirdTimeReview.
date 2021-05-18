class Solution {
    public String simplifyPath(String path) {
     //case1:current element = '.'    or / do nothing 
     //case2: current element = "..", pop
     //case3: current element = char. add
        Stack<String>stack = new Stack<>();
        String[] input = path.split("/");
       
        for(String ele : input){
            if(ele.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            if(!ele.equals("..") && !ele.equals(".") && ele.length() != 0){
                stack.add(ele);
            }
            
        }
        return "/"+ String.join("/",stack);
    
    }
}
