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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>>result = new ArrayList<>();
        int height = getHeight(root);
        int totalBucket = 2 * height - 1;
       
        for(int i = 0;  i < totalBucket; i++){
            result.add(new ArrayList<>());
        }
        int midIndex = height - 1;
        Queue<Pair>queue = new LinkedList<>();
        queue.add(new Pair(root,midIndex));
        while(!queue.isEmpty()){
            int size = queue.size();
            Map<Integer,List<Integer>>colToResult = new HashMap<>();
            for(int i = 0; i < size; i++){
                Pair curr = queue.poll();
                int index = curr.colIndex;
                if(!colToResult.containsKey(index)){
                    List<Integer>temp = new ArrayList<>();
                    temp.add(curr.root.val);
                    colToResult.put(index,temp);
                       System.out.println(curr.root.val);
                }else{
                 
                    colToResult.get(index).add(curr.root.val);
                }         
                if(curr.root.left != null){
                   queue.add(new Pair(curr.root.left,index - 1 ));
                }
                if(curr.root.right != null){
                   queue.add(new Pair(curr.root.right,index + 1 ));
                }
            }
            for(Map.Entry<Integer,List<Integer>>ele : colToResult.entrySet()){
                 int index = ele.getKey();
                 List<Integer>temp = ele.getValue();
                 Collections.sort(temp);
                 result.get(index).addAll(temp);
            }
            
        }
        result.removeIf(ele -> ele.size() == 0);
        return result;
        
    }
    private int getHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        return Math.max(getHeight(node.left),getHeight(node.right)) + 1;
    }
    private class Pair{
        TreeNode root;
        int colIndex;
        public Pair(TreeNode root, int colIndex){
            this.root = root;
            this.colIndex = colIndex;
        }
    }
}
