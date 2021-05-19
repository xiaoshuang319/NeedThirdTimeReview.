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
//time complixty :nlgn => merge sort: lng divide conquer, n operatior for each divide conquer
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)return null;
        return helper(lists,0,lists.length - 1);
    }
    private ListNode helper(ListNode[]lists, int start, int end){
        if(start == end){
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode l1 = helper(lists,start, mid);
        ListNode l2 = helper(lists,mid + 1, end);
        return merge2List(l1,l2);
    }
    private ListNode merge2List(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = merge2List(l1.next, l2);
            return l1;
        }else{
            l2.next =  merge2List(l1, l2.next);
            return l2;
        }
   
