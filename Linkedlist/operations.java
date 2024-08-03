public class operations 
{
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

    public static void addFirst(int data)
    {
        Node newnode = new Node(data);
        size++;
        if(head==null){
            head=tail=newnode;
            return;
        }
        newnode.next=head;
        head=newnode;
        return;
    }

    public static void addLast(int data)
    {
        Node newnode = new Node(data);
        size++;
        if(head==null){
            head=tail=newnode;
            return;
        }
        tail.next=newnode;
        tail=newnode;
        return;
    }

    public static void add(int idx,int data)
    {
        if(idx==0){
            addFirst(data);
            return;
        }
        Node newnode = new Node(data);
        size++;
        Node temp=head;
        int i=0;
        while(i<idx-1){
            temp=temp.next;
        }
        newnode.next=temp.next;
        temp.next=newnode;
        return;
    }
    public static int removeFirst()
    {
        if(size==0){
            System.out.println("LinkList is Empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            head=tail=null;
            int val = head.data;
            size=0;
            return val;
        }
        else{
            int val=head.data;
            head=head.next;
            size--;
            return val;
        }
    }
    public static int removeLast()
    {
        if(size==0){
            System.out.println("LinkList is Empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            head=tail=null;
            int val = head.data;
            size=0;
            return val;
        }
        else{
            Node prev=head;
            for(int i=0;i<size-2;i++){
                prev=prev.next;
            }
            int val=prev.next.data;
            prev.next=null;
            tail=prev;
            size--;
            return val;
        }
    }
    public static void reverse(){
        Node prev=null;
        Node curr=head;
        Node next;
        while(curr !=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
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
        operations ll =new operations();
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addLast(4);
        ll.print();
        ll.removeFirst();
        ll.removeLast();
        ll.add(0,3);
        ll.print();
        ll.reverse();
        ll.print();
    }
}
    

