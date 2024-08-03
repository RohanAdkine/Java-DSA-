import java.util.LinkedList;

public class Searching {
    public static class Node
    {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public static int LinearSearch(int key)  //O(n)
    {
        Node temp=head;
        int i=0;
        while(temp!=null){
            if(temp.data==key){
                return i;
            }
            temp=temp.next;
            i++;
        }
        return -1;
    }
    
    public static int RecursiveSearch(int key)   //O(n)
    {
        return helper(head,key);
    }
    public static int helper(Node head,int key) 
    {
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int idx = helper(head.next,key);
            if(idx==-1){
                return -1;
            }
        return idx+1;
    }

    public static void print()
    {
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data +" ");
            temp=temp.next;
        }
        System.out.println();  
    }

    public static void main(String args[]){
        head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        print();
        System.out.println(LinearSearch(3));
        System.out.println(RecursiveSearch(2));
        return;
    }
    
}
