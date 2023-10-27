package Practise;

public class Deletealloccurrencesofagivenkeyinadoublylinkedlist {
    public static Node deleteAllOccurrences(Node head, int k) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == k) {
                Node next = curr.next;
                head = deleteNode(head, curr);
                curr = next;
            } else
                curr = curr.next;
        }
        return head;
    }

    private static Node deleteNode(Node head, Node curr) {
        if (head == null || curr == null)
            return null;

        if (head == curr)
            return head.next;

        if (curr.next != null)
            curr.next.prev = curr.prev;

        if (curr.prev != null)
            curr.prev.next = curr.next;

        return head;
    }


}
