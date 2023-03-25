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
        
        Map<ListNode, Integer> m = new HashMap<ListNode, Integer>();
        ListNode temp = head;
        int cnt = 0;

        while(temp != null){
            m.put(temp, cnt);
            cnt++;
            temp = temp.next;

            if(m.containsKey(temp)){
                return temp;
            }
        }

        return null;
    }
}