//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    static Node reverseList(Node head) {
        
        Node temp = head;
        Node next = null;
        Node prev = null;

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
    
    public static Node addOne(Node head) 
    { 
        Node rev = reverseList(head);
        
        rev.data += 1;
        int carry = 0;
        
        Node temp = rev;
        
        while(temp != null){
            if(temp.next == null){
                temp.data += carry;
            }
            else if(temp.data + carry > 9){
                carry = 1;
                temp.data = 0;
            }
            else{
                temp.data += carry;
                if(temp.data <= 9) carry = 0;
            }
            temp = temp.next;
        }
        
        head = reverseList(rev);
        
        return head;
        
        
        // int carry = 0;
        // Node temp2 = rev;
        // while(temp2 != null){
        //     int val = temp2.data;
        //     if(val == 9){
        //         val = 0;
        //         carry = 1;
        //     }
        //     else{
        //         val = val + carry;
        //     }
        //     temp2.data = val;
            
        //     temp2 = next;
        // }
        
        
        // return temp2;
        
    }
}
