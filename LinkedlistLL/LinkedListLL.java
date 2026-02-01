public class LinkedListLL {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
        public static Node head;
        public static Node tail;

        public void addFirst(int data){
            Node newNode = new Node(data);
            if(head == null){
                head = tail = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        public void addLast(int data){
            Node newNode = new Node(data);
            if(head == null || tail == null){
                head = tail = newNode;
            }
            tail.next = newNode;
            tail = newNode;
        }

        public void printLL(){
            if(head == null){
                System.out.println("null");
            return;
            }
            Node curr = head;
            while(curr != null){
                System.out.print(curr.data + "->");
                curr = curr.next;
            }
            System.out.println("null");
        }

        public static Node mAndN(Node head, int m, int n){
            Node curr = head;
            while(curr != null){
                for(int i = 1; i < m && curr != null; i++){
                    curr = curr.next;
                }
                if(curr == null){
                    break;
                }
                Node temp = curr.next;
                for(int j = 0; j < n && temp != null; j++){
                    temp = temp.next;
                }
                curr.next = temp;
                curr = temp;
            }
            return head;
        }

    public static void main(String[] args) {
        LinkedListLL ll = new LinkedListLL();
        
        ll.addFirst(10);
        ll.addFirst(9);
        ll.addFirst(8);
        ll.addFirst(7);
        ll.addFirst(6);
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);

        ll.printLL();
        ll.mAndN(head, 2,2);
        ll.printLL();
    }
}