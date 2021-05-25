/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
//better solution: without hashmap
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)return null;
        Node curr = head;
        //step1:duplicate each node;
        while(curr != null){
            Node next = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = next;
            curr = next;
        }
    
       //step2: make random pointing to the random;
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
       
        
    
    
        //restore
        Node copyNode = head.next;
        Node scanner = copyNode;
        curr = head;
        while(scanner.next != null){
            curr.next = curr.next.next;
            curr = curr.next;
            scanner.next = scanner.next.next;
            scanner = scanner.next;
        }
        curr.next = null;
        return copyNode;
    }
}
//method1: with hashmap.
class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node>nodeToCopy = new HashMap<>();
        Node curr = head;
        while(curr != null){
            Node newNode = new Node(curr.val);
            nodeToCopy.put(curr, newNode);
            curr = curr.next;
        }
        curr = head;
        while(curr != null){
            Node copy = nodeToCopy.get(curr);
            nodeToCopy.get(curr).next = nodeToCopy.get(curr.next);
            nodeToCopy.get(curr).random = nodeToCopy.get(curr.random);
            curr = curr.next;
        }
        return nodeToCopy.get(head);
    }
}
