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
    public int getDecimalValue(ListNode head) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ListNode temp = head;
        while(temp != null){
            int x = temp.val;
            list.add(x);
            temp = temp.next;
        }

        int l = list.size();
        int pow = 0;
        int ans = 0;
        for(int i=l-1; i>=0; i--){
            int c = list.get(i);
            ans += c*(1<<pow);
            pow++;
        }

        return ans;
    }
}