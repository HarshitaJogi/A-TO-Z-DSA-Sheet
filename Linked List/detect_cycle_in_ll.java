/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        if(head == null || head.next == null){
            return false;
        }

        // brute force: create hashmap, put nodes in hashmap while traversing.
        // if a node already exists in the hashmap, cycle exists.

        // optimal: take slow pointer and fast pointer (hare and tortoise method)
        // if cycle exists, slow and fast pointer will meet at some point.

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }

        return false;
        
    }
}