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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null || head.next == null) return null;
        
        // to find length of ll (1-based)
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }

        // handling a special case, i.e. if first node is to be removed (nth node from end)
        if(len == n){
            head = head.next;
            return head;
        }

        // to see which node from front do we have to remove
        int ind = (len-n) + 1;
        //System.out.println(ind);

        // removing the node
        ListNode prev = head;
        ListNode next = null;
        temp = head;
        int cnt = 0;

        while(temp != null){
            cnt++;
            
            next = temp.next;
            if(cnt == ind){
                //System.out.println(temp.val + " " + prev.val);
                prev.next = temp.next;
            }
            prev = temp;
            
            temp = next;

        }

        //System.out.println(len);
        return head;
    }
}