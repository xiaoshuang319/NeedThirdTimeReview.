class Solution {
    public int maxPathSum(TreeNode root) {
        int[]res = new int[1];
        res[0] = Integer.MIN_VALUE;
        maxPathFromRootToLeaf(root,res);
        return res[0];
    }
    private int maxPathFromRootToLeaf(TreeNode node, int[]res){
        if(node == null){
            return 0;
        }
        int leftSum = maxPathFromRootToLeaf(node.left, res);
        int rightSum = maxPathFromRootToLeaf(node.right, res);
        //if leftSum < 0,give up left
        if(leftSum < 0){
            leftSum = 0;
        }
        //if rightSum < 0,give up right
        if(rightSum < 0){
            rightSum = 0;
        }
        res[0] = Math.max(res[0], leftSum + rightSum + node.val);
        return Math.max(leftSum, rightSum) + node.val;
    }
}

//Diameter of Binary Tree
