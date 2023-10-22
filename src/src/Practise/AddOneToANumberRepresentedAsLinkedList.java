package Practise;

public class AddOneToANumberRepresentedAsLinkedList {
    public static void main(String[] args) {
//        Node a = new Node(4);
//        Node b = new Node(5);
//        Node c = new Node(6);
//        a.next = b;
//        b.next = c;
//        Node ans = addNode(a);
        Node ans = addNode(new Node(9));
        while (ans != null) {
            System.out.println(ans.data);
            ans = ans.next;
        }
    }

    public static Node addNode(Node head) {
        //int carry = 1;
        head = reverse(head);
        Node temp = head;
        while (temp != null) {
            if (temp.data < 9) {
                temp.data += 1;
                return reverse(head);
            }
            temp.data = 0;
            if (temp.next == null)
                break;
            temp = temp.next;
        }
        Node newNode = new Node(1);
        temp.next = newNode;
        return reverse(head);
    }

    private static Node reverse(Node head) {
        Node curr = head;
        Node next;
        Node prev = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


}
