/*Complete the function below*/
/*
class Node{
    int data;
    Node next;
    Node(int a){  data = a; next = null; }
}*/

class Solution
{
    //Function to count nodes of a linked list.
    public static int getCount(Node head)
    {
        // temp is pointer to node
        Node temp = head;
        int len = 0;
        
        while(temp != null){
            len++;
            temp = temp.next;
        }
        
        return len;
    }
}