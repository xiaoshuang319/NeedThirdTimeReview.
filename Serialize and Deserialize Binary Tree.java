/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    private String DELIMETER = ",";
    private String NULL_SIGNAL = "#";
    public String serialize(TreeNode root) {
        if(root == null){
            return NULL_SIGNAL;
        }
        return root.val + DELIMETER + serialize(root.left) + DELIMETER + serialize(root.right); 
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[]ele = data.split(",");
        Queue<String>queue = new LinkedList<>();
        for(String e : ele){
            queue.add(e);
        }
        return helper(queue);
       
    }
    private TreeNode helper(Queue<String>queue){
        String curr = queue.poll();
        if(curr.equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(curr));
        root.left = helper(queue);
        root.right = helper(queue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
