
// User function Template for Java

/*
class Node { 
    int data; 
    Node next; 

    Node() { data = 0; }
    Node(int d) { data = d; }  //constructor to create a new node
} 
*/
class Solution {
    static Node constructLL(int arr[]) {
        int N = arr.length;
        Node root = ArraytoList(arr, N);
        return root;
    }
    
    // representation of a node
    // static class Node{
    //     int data;
    //     Node next;
    // }
    
    static Node root;
    
    // function to insert node
    static Node insert(Node root, int item){
        Node temp = new Node();
        temp.data = item;
        temp.next = root;
        root = temp;
        return root;
    }
    
    // static void display(Node root){
    //     while(root != null){
    //         System.out.print(root.data + " ");
    //         root = root.next;
    //     }
    // }
    
    static Node ArraytoList(int arr[], int N){
        root = null;
        for(int i=N-1; i>=0; i--){
            root = insert(root, arr[i]);
        }
        return root;
    }
}
