public class Find_and_Remove_Nth_Node_From_end {
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
    
    public static void deleteNthfromEnd(int n)  //O(n)  
    //from start same approach onlu n-->(size-n+1)
    {
        int sz=0;
        Node temp=head;
        while(temp!=null){
            temp=temp.next;
            sz++;
        }
        if(n==sz){
            head=head.next;
            return;
        }
        //sz-n=prev of deleting node
        int i=1;
        int iToFind=sz-n;
        Node prev=head;
        while(i<iToFind){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return;
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
        deleteNthfromEnd(1);
        print();
        return;
    }
}
