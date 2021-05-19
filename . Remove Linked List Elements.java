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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode curr = head;
        while(curr != null){
            if(curr.val == val){
                pre.next =  curr.next; //无需再要更新pre
       
            }else{
                
                pre = pre.next;
            }
           curr = curr.next;
        }
        return dummyNode.next;
    }
    
     
}
