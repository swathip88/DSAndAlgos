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
class PalindromeLinkedList {
    //https://leetcode.com/problems/palindrome-linked-list/submissions
    ListNode p1;
    public boolean isPalindrome(ListNode head) {
        
        p1 = head;
        ListNode p2 = head;
        return isPali(p2);
    }
    
    private boolean isPali(ListNode p2){
        if(p2 == null){
            return true;
        }
        boolean a = isPali(p2.next);
        if(!a){
            return false;
        }
        boolean res = (p2.val == p1.val);
            
        p1 = p1.next;
        return res;
    }
}
