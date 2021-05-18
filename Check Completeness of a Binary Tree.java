class Solution {
    // level-order traverse the complete tree, after last node, queue should only contain null value
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode>queue = new LinkedList<>();
        queue.add(root);
        boolean meetNull = false;
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr == null)meetNull= true;
            else{
                if(meetNull)return false;
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
        return true;
    }
}
