/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //as long as path headA walk through is same as path headB walk through, then they must meet
        //if headA == null, then make it to walk through path headB walked,
        ListNode currA = headA;
        ListNode currB = headB;
        while(currA != currB){
            currA = currA == null ? headB : currA.next;
            currB = currB == null ? headA : currB.next;
        }
        return currA;
    }
}

//Lowest Common Ancestor of a Binary Tree III
