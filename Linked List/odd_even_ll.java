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
    public ListNode oddEvenList(ListNode head) {

        // base cases
        if(head == null || head.next == null || head.next.next == null) return head;
        
        
        // APPROACH 2
        // makes two linked lists, one that has odd nodes and one that has even nodes
        // after traversal of both. connect tail of odd with head of even

        ListNode odd = head;
        ListNode even = head.next;
        ListNode odd_head = head;
        ListNode even_head = head.next;
        
        
        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            // to continue traversal
            odd = odd.next;
            even = even.next;
        }
        
         // after traversal of both. connect tail of odd with head of even
         odd.next = even_head;

         return head;
        
        
        
        // APPROACH 1
        // // to find end node:
        // ListNode end = head;
        // int count = 0; // tells us number of jumps needed to reach last node
        // while(end.next != null){
        //     count++;
        //     end = end.next;
        // }
        // //System.out.println(count);

        // // to calculate how many operations we need to perform
        // int no_of_nodes = count + 1;
        // int operations = 0;
        // if(no_of_nodes%2==0) operations = (count/2) + 1;
        // else operations = count/2;

        // ListNode temp = head;
        // while(operations-->0){
        //     // append end.next to temp.next
        //     end.next = temp.next;

        //     // point temp.next to temp.next.next
        //     temp.next = temp.next.next;

        //     // make end.next.next = null
        //     end.next.next = null;

        //     temp = temp.next;
        //     end = end.next;
        // }


        // return head;

    }
  
}