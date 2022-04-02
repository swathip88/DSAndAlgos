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
class ReverseLinkedList {
    //https://leetcode.com/problems/reverse-linked-list/submissions/
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        
        while(cur!=null){
            ListNode t = cur.next;
            cur.next = prev;
            prev = cur;
            cur = t;
        }
        
        return prev;
    }
}
