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
    public ListNode detectCycle(ListNode head) {
        
        // Map<ListNode, Integer> m = new HashMap<ListNode, Integer>();
        // ListNode temp = head;
        // int cnt = 0;

        // while(temp != null){
        //     m.put(temp, cnt);
        //     cnt++;
        //     temp = temp.next;

        //     if(m.containsKey(temp)){
        //         return temp;
        //     }
        // }

        // return null;

        if(head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode entry = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                while(slow != entry){
                    slow = slow.next;
                    entry = entry.next;
                }
                return entry;
            }
        }
        return null;
    }
}