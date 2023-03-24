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
    public ListNode reverseList(ListNode head) {
        
        ListNode temp = head;
        ListNode next = null;
        ListNode prev = null;

        while(temp != null){
            // store next element address
            next = temp.next;
            // change current address of node to prev address
            temp.next = prev;
            // update prev
            prev = temp;
            // go to next element
            temp = next;
        }

        return prev;
    }
}