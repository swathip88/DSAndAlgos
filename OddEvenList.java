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
class OddEvenList {
    //https://leetcode.com/problems/odd-even-linked-list/submissions/
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenStart = even;
        
        while(odd!=null && even!=null){
            odd.next = even.next;
            if(odd.next !=null){
                odd = even.next;
            }    
            even.next = odd.next;
            even = odd.next;
        }
        odd.next = evenStart;
        return head;
    }
}
