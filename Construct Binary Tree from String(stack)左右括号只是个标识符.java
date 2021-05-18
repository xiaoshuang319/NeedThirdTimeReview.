/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode str2tree(String s) {
        if(s == null || s.length() == 0)return null;
        Stack<TreeNode>stack = new Stack<>();
        int len = s.length(), idx = 0;
        while(idx < len){
            char curr = s.charAt(idx);
            if(Character.isDigit(curr) || curr == '-'){
                int startPos = idx;
                while( idx < len && (Character.isDigit(s.charAt(idx))|| s.charAt(idx) == '-'))idx++; 
               // System.out.println(s.substring(startPos, idx));
                int val =  Integer.parseInt(s.substring(startPos, idx));
                TreeNode node = new TreeNode(val);
                if(!stack.isEmpty()){
                    TreeNode peek = stack.peek();
                    if(peek.left == null){
                        peek.left = node;
                    }else{
                        peek.right = node;
                    }
                }
                stack.add(node);
                continue;
          }else if (curr == ')'){
              stack.pop();  
          }
        idx++;
      }
        return stack.pop();
        
    }
}
