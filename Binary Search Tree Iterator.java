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
class BSTIterator {
    Stack<TreeNode>stack = new Stack<>();;
    public BSTIterator(TreeNode root) {
            push(root);//push left to the stack
    }
    public int next() {
        int res = 0;
        if(hasNext()){
            TreeNode curr = stack.pop();
            res = curr.val;
            if(curr.right != null){ //push right to stack if curr node has right; 
                push(curr.right);
            }
        }
        return res;
    }
    public boolean hasNext() {
        return stack.size() != 0;
    }
    private void push(TreeNode root){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
