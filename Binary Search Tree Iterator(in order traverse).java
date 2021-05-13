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


/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node pre = null; //global variable
    public Node treeToDoublyList(Node root) {
      if(root == null)return null;
      Node dummyNode = new Node(-1,null,null);
      pre = dummyNode;
      helper(root);
      pre.right = dummyNode.right;
      dummyNode.right.left = pre;
      return dummyNode.right;
      
    }
    private Node helper(Node node){
        if(node == null)return null;
        helper(node.left);
        pre.right = node;
        node.left = pre;
        pre = pre.right;
        helper(node.right);
        return pre.right;
    }
    
}
