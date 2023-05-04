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
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(); 

        ArrayList<Integer> l = new ArrayList<Integer>();
        
        for(int i=0; i<lists.length; i++){
            ListNode temp = lists[i];
            while(temp != null){
                // System.out.println(temp.val);
                // pq.add(temp);
                l.add(temp.val);
                temp = temp.next;
            }
        }

        Collections.sort(l);

        int n = l.size();
        ListNode head = arrayToList(l, n);

      


        // ListNode head = new ListNode(pq.get(0));
        // // tail will act as iterator
        // ListNode tail = head;

        // Iterator itr = pq.iterator();
        // while (itr.hasNext()){
            
        // }
            

        return head;
    }

    static ListNode arrayToList(ArrayList<Integer> arr, int n)
    {
        ListNode root = null;
        for (int i = 0; i < n; i++)
            root = insert(root, arr.get(i));
        return root;
    }

    // Function to insert node
    static ListNode insert(ListNode root, int item)
    {
        ListNode temp = new ListNode();
        ListNode ptr;
        temp.val = item;
        temp.next = null;
    
        if (root == null)
            root = temp;
        else 
        {
            ptr = root;
            while (ptr.next != null)
                ptr = ptr.next;
            ptr.next = temp;
        }
        return root;
    }

}