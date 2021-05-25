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
    int[]res = new int[1]; 
    public int sumNumbers(TreeNode root) {
    
        preOrder(root,0);
        return res[0];
    }
    private void preOrder(TreeNode node, int preFix){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            res[0] += preFix * 10 + node.val;
        }
        preOrder(node.left, preFix * 10 + node.val);
        preOrder(node.right, preFix * 10 + node.val);
    }
}
