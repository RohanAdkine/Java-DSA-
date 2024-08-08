public class Swap_pairs {
    public static class ListNode {
        int val;
        ListNode next;
    
        ListNode() {}
    
        ListNode(int val) {
            this.val = val;
        }
    
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    
        public ListNode swapPairs(ListNode head) {
            int temp;
            ListNode temp1 = head;
            while (temp1 != null && temp1.next != null) {
                temp = temp1.val;
                temp1.val = temp1.next.val;
                temp1.next.val = temp;
                temp1 = temp1.next.next;
            }
            return head;
        }
    
        // Helper method to print the linked list
        public static void printList(ListNode head) {
            ListNode temp = head;
            while (temp != null) {
                System.out.print(temp.val + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    
        // Helper method to create a linked list from an array
        public static ListNode createList(int[] values) {
            if (values.length == 0) return null;
            ListNode head = new ListNode(values[0]);
            ListNode current = head;
            for (int i = 1; i < values.length; i++) {
                current.next = new ListNode(values[i]);
                current = current.next;
            }
            return head;
        }
    
        public static void main(String[] args) {
            Swap_pairs solution = new Swap_pairs();
    
            // Example usage
            int[] values = {1, 2, 3, 4};
            ListNode head = createList(values);
            System.out.print("Original list: ");
            printList(head);
    
            head = solution.swapPairs(head);
            System.out.print("Swapped list: ");
            printList(head);
        }
    }
    

