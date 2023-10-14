package Practise;

public class ReverseDoublyLinkedList {

    public static Node reverseDLL(Node head)
    {
        if (head == null)
            return null;

        Node curr = head;
        Node next;
        Node newHead = null;

        while (curr != null) {
            next = curr.next;
            curr.next = curr.prev;
            curr.prev = next;
            newHead = curr;
            curr = next;
        }

        return newHead;
    }
}
