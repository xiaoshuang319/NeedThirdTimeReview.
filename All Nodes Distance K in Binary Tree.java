/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//:buil child to node relationship 
//:bfs treenode starting from tareget node level by level, untill k == 0

    
    
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,List<TreeNode>>nodeToNeight = new HashMap<>();
        Set<TreeNode>visit = new HashSet<>();
        Queue<TreeNode>queue = new LinkedList<>();
        queue.add(target);
        visit.add(target);
        buildChildToParent(root,nodeToNeight,null);
        List<Integer>result = new LinkedList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            if(k == 0){
                for(int j = 0; j < size; j++){
                    result.add(queue.poll().val); 
                }
                return result;
            }
        
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                for(TreeNode ele : nodeToNeight.get(curr)){
                    if(visit.contains(ele)){
                        continue;
                    }
                    queue.add(ele);
                    visit.add(ele);
                }
            }
            k--;
        }
        return new ArrayList<>();
    }
    private void buildChildToParent(TreeNode node, Map<TreeNode,List<TreeNode>>nodeToNeight,TreeNode parent){
            if(node == null){
                return;
            }
           if(!nodeToNeight.containsKey(node)){
                nodeToNeight.put(node, new ArrayList<>());
                if(parent != null){
                    nodeToNeight.get(node).add(parent);
                    nodeToNeight.get(parent).add(node);
                }
           }
            buildChildToParent(node.left,nodeToNeight,node);
            buildChildToParent(node.right,nodeToNeight,node);
     
    }
}
