/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)return null;
        Map<Node,Node>meToCopy = new HashMap<>();
        meToCopy.put(node, new Node(node.val));
        Queue<Node>queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node curr = queue.poll();
                for(Node ele : curr.neighbors){
                    if(!meToCopy.containsKey(ele)){
                         meToCopy.put(ele, new Node(ele.val));
                          queue.add(ele);
                    }
                    meToCopy.get(curr).neighbors.add(meToCopy.get(ele));
                }
            }
        }
        return meToCopy.get(node);
    }
}
