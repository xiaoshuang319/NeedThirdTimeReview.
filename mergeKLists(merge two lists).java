/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null )return null;
        PriorityQueue<ListNode>pq = new PriorityQueue<>((a,b) -> (a.val - b.val));
        for(ListNode ele : lists){
            if(ele != null){
                pq.add(ele);
            }
        }
        ListNode dummyNode = new ListNode(0,null);
        ListNode pointer = dummyNode;
        while(!pq.isEmpty()){
            ListNode curr = pq.poll();
            if(curr.next != null){
                pq.add(curr.next);
            }
            pointer.next = curr;
            pointer = pointer.next;
        }
        return dummyNode.next;
    }
}
