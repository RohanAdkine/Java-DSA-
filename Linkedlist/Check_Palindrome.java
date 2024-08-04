public class Check_Palindrome {
        public static class Node {
            int data;
            Node next;
    
            public Node(int data) {
                this.data = data;
                this.next = null;
            }
        }
        public static Node head;
        public static Node tail;
        public static int size;
    
        public static void print()
        {
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data +"-->");
                temp=temp.next;
            }
            System.out.println("null");  
        }
    
        //Slow-Fast Approach
        public static Node findMid(Node head) { //helper
            Node slow = head;
            Node fast = head;
    
            while(fast != null && fast.next != null) {
                slow = slow.next; //+1
                fast = fast.next.next;//+2
            }
            return slow; //slow is my midNode
        }
    
        public static boolean checkPalindrome() {
            if(head == null || head.next == null) {
                return true;
            }
            //step1 - find mid
            Node midNode = findMid(head);
    
            //step2 - reverse 2nd half
            Node prev = null;
            Node curr = midNode;
            Node next;
            while(curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
    
            Node right = prev;//right half head
            Node left = head;
    
            //step3 - check left half & right half
            while(right != null) {
                if(left.data != right.data) {
                    return false;
                }
                left = left.next;
                right = right.next;
            }
    
            return true;
        }
        public static void main(String args[]) 
        {
            head=new Node(1);
            head.next=new Node(2);
            head.next.next=new Node(3);
            head.next.next.next=new Node(2);
            head.next.next.next.next=new Node(1);
            print();
            System.out.println(checkPalindrome());
           
        }
    }
