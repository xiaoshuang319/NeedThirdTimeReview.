class Solution {
    public String simplifyPath(String path) {
     //case1:current element = '.'    or / do nothing 
     //case2: current element = "..", pop
     //case3: current element = char. add
        Stack<String>stack = new Stack<>();
        String[] input = path.split("/"); //split string before it. if no string before it, it will return empty string
       
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
