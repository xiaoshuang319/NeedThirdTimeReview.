/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        helper(root,null);
        return root;
    }
    private void helper(Node currNode, Node next){
        if(currNode == null){
            return;
        }
        currNode.next = next;
        helper(currNode.left, currNode.right);
        helper(currNode.right, currNode.next == null ? null : currNode.next.left);
    }
}
//
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node dummyNode = new Node(-1);//keep the first node at each layer
        Node pre = dummyNode;
        Node curr = root;
        while(curr != null){
            if(curr.left != null){
                pre.next = curr.left;
                pre = pre.next;
            }
            if(curr.right != null){
                pre.next = curr.right;
                pre = pre.next;
            } 
            curr = curr.next;
            if(curr == null){
                pre = dummyNode;
                curr =  dummyNode.next;
                dummyNode.next = null;
                
            }
        }
        return root;
        
    }
}
