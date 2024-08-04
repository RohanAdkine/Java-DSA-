public class Zigzag_LL {

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
    
        public static void print() { // O(n)
            Node temp = head;
            while(temp != null) {
                System.out.print(temp.data+"->");
                temp = temp.next;
            }
            System.out.println("null");
        }
        public static void zigZag() {
            //find mid
            Node slow = head;
            Node fast = head.next;
            while(fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            Node mid = slow;
    
            //reverse 2nd half
            Node curr = mid.next;
            mid.next = null;
            Node prev = null;
            Node next;
            
            while(curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
    
            Node left = head;
            Node right = prev;
            Node nextL, nextR;
    
            //alt merge - zig-zag merge
            while(left != null && right != null) {
                nextL = left.next;
                left.next = right;
                nextR = right.next;
                right.next = nextL;
    
                left = nextL;
                right = nextR;
            }
        }
        public static void main(String args[]) {
            head = new Node(1);
            head.next = new Node(4);
            head.next.next = new Node(3);
            head.next.next.next = new Node(2);
            head.next.next.next.next = new Node(5);
    
            print();
            zigZag();
            print();
        }
    }   

