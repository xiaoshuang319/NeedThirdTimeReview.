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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>result = new ArrayList<>();
        helper(root,targetSum,result, new ArrayList<>());
        return result;
    }
    private void helper(TreeNode node, int targetSum,List<List<Integer>>result,List<Integer>path){
        if(node == null){
            return;
        }
        path.add(node.val);
        if(targetSum == node.val && node.left == null && node.right == null){
           result.add(new ArrayList<>(path));
           path.remove(path.size() - 1); //加完path要删除node去遍历右边的children
           return;
        }
        helper(node.left, targetSum - node.val,  result,path);
        helper(node.right, targetSum - node.val, result,path);
        path.remove(path.size() - 1); //遍历完左右后，要删除parent
    }
}

