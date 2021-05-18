//MAP + DoubldLinkedList;
//Map: <key,value> pair
//DoubldLinkedList : dummyhead->node1->node2->node3->dummTail
//for get operation:
//map: if map doese not cotain, reutn -1.
//.    otherwise, return falue, and add the node to tail
//for put operation:
//if it exceed the size, then delete from map, delete head
//otherwise, keep add it
class LRUCache {
    Map<Integer,Node>keyToValue = new HashMap<>(); //key to Node 
    DoubleLinkedList cutomizedNode = new DoubleLinkedList();//double linked list
    int capacity = 0;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    public int get(int key) {
        if(!keyToValue.containsKey(key)){
            return -1;
        }
        Node node = keyToValue.get(key); // 
        cutomizedNode.deleteByNode(node); //delete , insert to make sure the elemen is just visited.
        cutomizedNode.addNode(node);
        return node.val;
    }
    public void put(int key, int value) {
        Node node;
        if(keyToValue.containsKey(key)){
            node = keyToValue.get(key);
            node.val = value;
            cutomizedNode.deleteByNode(node);
        }else{  
            if(keyToValue.size() == capacity){
                int deletedKey = cutomizedNode.deleteByHead().key;
                keyToValue.remove(deletedKey);
            }
            node = new Node(key,value);
        }
        keyToValue.put(key, node);
        cutomizedNode.addNode(node);
    }
    private class DoubleLinkedList{
        Node dummyHead;
        Node dummyTail;;
        public DoubleLinkedList(){
            dummyHead = new Node(0,0);
            dummyTail = new Node(0,0);
            dummyHead.next = dummyTail;
            dummyTail.prev = dummyTail;
        }
        private void addNode(Node node){
            dummyTail.prev.next = node;
            node.next = dummyTail;
            node.prev =  dummyTail.prev;
            dummyTail.prev = node;
        }
        private void deleteByNode(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        private Node deleteByHead(){
            Node head = dummyHead.next;
            dummyHead.next = head.next;
            head.next.prev = dummyHead;  
            return  dummyHead.next;
        }
    }
    private class Node{
        Node prev;
        Node next;
        int key;
        int val;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

  
